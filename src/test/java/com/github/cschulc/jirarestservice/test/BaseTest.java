package com.github.cschulc.jirarestservice.test;


import com.github.cschulc.jirarestservice.JiraRestService;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaseTest {

    static final String CONFIGFILENAME = "config.properties";

    static final String URL_PARAM = "url";
    static final String LOGIN_PARAM = "login";
    static final String PASSWORD_PARAM = "password";

    static final String PROJECT_NAME_PARAM = "project.name";
    static final String PROJECT_KEY_PARAM = "project.key";
    static final String ISSUE_COUNT_PARAM = "issue.count";


    String testSystemUrl;
    String login;
    String password;

    String projectName;
    String projectKey;

    JiraRestService restService;

    @BeforeSuite
    public void connect() throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        loadConfig();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        ProxyHost proxy = new ProxyHost("proxy", 3128);
        URI uri = new URI(testSystemUrl);
        restService = new JiraRestService(executorService);
        restService.connect(uri, login, password);
    }

    private void loadConfig() throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Properties config = new Properties();
        config.load(new FileInputStream(path + CONFIGFILENAME));
        testSystemUrl = config.getProperty(URL_PARAM);
        login = config.getProperty(LOGIN_PARAM);
        password = config.getProperty(PASSWORD_PARAM);
    }

}
