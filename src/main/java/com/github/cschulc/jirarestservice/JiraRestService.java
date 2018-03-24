package com.github.cschulc.jirarestservice;

import com.github.cschulc.jirarestservice.domain.field.Field;
import com.github.cschulc.jirarestservice.misc.RestPaths;
import com.github.cschulc.jirarestservice.services.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class JiraRestService {

    private static final String HTTP = "http";
    private static final String HTTPS = "https";

    protected final ExecutorService executorService;

    private URI baseUri;
    private String username = StringUtils.EMPTY;
    private CloseableHttpClient client;
    private HttpHost proxy;
    private HttpClientContext context;

    private static Map<String, Field> customfields;

    private static RequestConfig config;

    private IssueService issueService;

    private UserService userService;

    private ProjectService projectService;

    private SystemService systemService;

    private SearchService searchService;

    public JiraRestService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public int connect(URI uri, String username, String password) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        return connect(uri, username, password, null);
    }

    /**
     * Builds and configures a new client connection to JIRA.
     *
     * @param uri      = the login mask URI where JIRA is running
     * @param username = login name
     * @param password = login password
     * @return 200 succees, 401 for wrong credentials and 403 for captcha is needed, you have to login at the jira website
     */
    public int connect(URI uri, String username, String password, HttpHost proxyHost) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        this.username = username;
        String host = uri.getHost();
        int port = getPort(uri.toURL());
        String scheme = HTTP;
        if (port == 443) scheme = HTTPS;
        HttpHost target = new HttpHost(host, port, scheme);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(username, password));
        client = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local
        // auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);
        // Add AuthCache to the execution context
        context = HttpClientContext.create();
        context.setAuthCache(authCache);
        this.baseUri = buildBaseURI(uri);
        if(proxyHost != null){
            this.proxy = proxyHost;
            config = RequestConfig.custom().setProxy(proxyHost).build();
        }
        return 200;
    }

    /**
     * Extract port from URL
     *
     * @param endpointUrl
     * @return
     */
    private int getPort(URL endpointUrl) {
        int port = (endpointUrl.getPort() != -1 ? endpointUrl.getPort() : endpointUrl.getDefaultPort());
        if (port != -1) {
            return port;
        }
        if (HTTPS.equals(endpointUrl.getProtocol())) {
            return 443;
        }
        return 80;
    }

    private URI buildBaseURI(URI uri) throws URISyntaxException {
        String path = uri.getPath();
        if (path.isEmpty() == false) {
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            path = path.concat(RestPaths.BASE_REST_PATH);
        } else {
            path = RestPaths.BASE_REST_PATH;
        }
        return new URIBuilder(uri).setPath(path).build();
    }

    public static RequestConfig getConfig() {
        return config;
    }

    public static Map<String,Field> getCustomfields() {
        if(customfields == null){
            customfields = new HashMap<>();
        }
        return customfields;
    }

    public URI getBaseUri() {
        return baseUri;
    }

    public CloseableHttpClient getClient() {
        return client;
    }

    public HttpClientContext getContext() {
        return context;
    }

    public String getUsername() {
        return username;
    }

    public IssueService getIssueService() {
        if(issueService == null){
            issueService = new IssueServiceImpl(this, executorService);
        }
        return issueService;
    }

    public UserService getUserService() {
        if(userService == null){
            userService = new UserServiveImpl(this, executorService);
        }
        return userService;
    }

    public ProjectService getProjectService() {
        if(projectService == null){
            projectService = new ProjectServiceImpl(this, executorService);
        }
        return projectService;
    }

    public SystemService getSystemService() {
        if(systemService == null){
            systemService = new SystemServiceImpl(this, executorService);
        }
        return systemService;
    }

    public SearchService getSearchService() {
        if(searchService == null){
            searchService = new SearchServiceImpl(this, executorService);
        }
        return searchService;
    }
}
