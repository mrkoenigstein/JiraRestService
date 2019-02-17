/*
 * Copyright (c) 2019. cschulc (https://github.com/cschulc)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.github.cschulc.jirarestservice.test;


import com.github.cschulc.jirarestservice.JiraRestService;
import com.github.cschulc.jirarestservice.domain.user.UserBean;
import com.github.cschulc.jirarestservice.misc.JiraRestException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BaseTest {

    static final String CONFIGFILENAME = "config.properties";

    static final String URL_PARAM = "url";
    static final String LOGIN_PARAM = "login";
    static final String PASSWORD_PARAM = "password";

    static final String PROJECT_NAME_PARAM = "project.name";
    static final String PROJECT_KEY_PARAM = "project.key";
    static final String ISSUE_COUNT_PARAM = "issue.count";

    static final String USERNAME_TO_SEARCH = "admin";
    static final String ISSUEKEY_TO_SEARCH = "DEMO-1";
    static final String PROJECT_TO_SEARCH = "DEMO";


    String testSystemUrl;
    String login;
    String password;

    JiraRestService restService;

    @BeforeClass
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

    @Test
    public void checkConnected() throws IOException, JiraRestException, ExecutionException, InterruptedException {
        Assert.assertNotNull(restService);
        Future<UserBean> future = restService.getUserRestService().getLoggedInRemoteUser();
        UserBean userBean = future.get();
        Assert.assertEquals(userBean.getName(), login);
    }

}
