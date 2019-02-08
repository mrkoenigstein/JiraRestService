package com.github.cschulc.jirarestservice.util;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.cschulc.jirarestservice.test.BaseTest;

public class HttpClientFactoryTest extends BaseTest{

	@Test
	public void testGetDefaultClient() {
        String host = "";
        int port = 443;
        String scheme = "http";
        if (port == 443) scheme = "https";
        HttpHost target = new HttpHost(host, port, scheme);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials("", ""));
        
		Assert.assertNotNull(HttpClientFactory.getDefaultClient(credsProvider));
	}

	@Test
	public void testGetClient() {
		// Here could be tests to call the different permutations of CertTrustStrategy and HostnameVerification 
	}

	@Test
	public void testGetTrustSelfsignedClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        String host = "";
        int port = 443;
        String scheme = "http";
        if (port == 443) scheme = "https";
        HttpHost target = new HttpHost(host, port, scheme);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials("", ""));
        
		Assert.assertNotNull(HttpClientFactory.getTrustSelfsignedClient(credsProvider));
	}

	@Test
	public void testGetTrustAllClient() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        String host = "";
        int port = 443;
        String scheme = "http";
        if (port == 443) scheme = "https";
        HttpHost target = new HttpHost(host, port, scheme);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials("", ""));
        
		Assert.assertNotNull(HttpClientFactory.getTrustAllClient(credsProvider));
	}

}
