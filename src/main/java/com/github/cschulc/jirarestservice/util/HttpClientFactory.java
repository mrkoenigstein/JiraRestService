package com.github.cschulc.jirarestservice.util;

import static com.github.cschulc.jirarestservice.util.HttpClientFactory.HostnameVerificationStrategy.*;
import static com.github.cschulc.jirarestservice.util.HttpClientFactory.TrustReductionStrategy.*;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;


public class HttpClientFactory {
	
	public enum TrustReductionStrategy {
		TRUST_SELFSIGNED, TRUST_ALL
	}

	public enum HostnameVerificationStrategy {
		VERIFY_HOSTNAMES, DONT_VERIFY_HOSTNAMES
	}
	
	/**
	 * @param credsProvider the credentials to use
	 * @return
	 */
	public static CloseableHttpClient getDefaultClient(CredentialsProvider credsProvider) {
		return getDefaultClientBuilder(credsProvider).build();
	}

	/**
	 * More flexibility when creating the CloseableHttpClient
	 * 
	 * @param credsProvider the credentials to use
	 * @param trustStrategy the SSL-Cert-Trust-Strategy
	 * @param hostnameVerificationStrategy the Host-Name-Verification-Strategy
	 * @return a CloseableHttpClient configured as specified 
	 * 
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 */
	public static CloseableHttpClient getClient(CredentialsProvider credsProvider, TrustReductionStrategy trustStrategy, HostnameVerificationStrategy hostnameVerificationStrategy) 
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		
		return getDefaultClientBuilder(credsProvider)
				.setSSLSocketFactory(getCustomSSLSocketFactory(trustStrategy, hostnameVerificationStrategy))
				.build();
	}

	/**
	 * @param credsProvider the credentials to use
	 * @return a CloseableHttpClient that trusts all self-signed SSL Certificates and validates Hostnames
	 * 
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 */
	public static CloseableHttpClient getTrustSelfsignedClient(CredentialsProvider credsProvider) 
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		
		return getDefaultClientBuilder(credsProvider)
				.setSSLSocketFactory(
						getCustomSSLSocketFactory(TRUST_SELFSIGNED, VERIFY_HOSTNAMES)).build();
	}
	
	/**
	 * @param credsProvider the credentials to use
	 * @return a CloseableHttpClient that neither checks SSL Certificates nor validates Hostnames
	 * 
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 */
	public static CloseableHttpClient getTrustAllClient(CredentialsProvider credsProvider) 
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		
		return getDefaultClientBuilder(credsProvider)
				.setSSLSocketFactory(
						getCustomSSLSocketFactory(TRUST_ALL, DONT_VERIFY_HOSTNAMES)).build();
	}
	
	/**
	 *   
	 * @param credsProvider the credentials to use
	 * @return the base HttpClientBuilder Object that can be configured lateron
	 */
	private static HttpClientBuilder getDefaultClientBuilder(CredentialsProvider credsProvider) {
		return HttpClients.custom().setDefaultCredentialsProvider(credsProvider);
	}
	
	/**
	 * @param trustStrategy
	 * @param hostnameVerificationStrategy
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 */
	private static SSLConnectionSocketFactory getCustomSSLSocketFactory(TrustReductionStrategy trustStrategy, HostnameVerificationStrategy hostnameVerificationStrategy) 
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		
		return new SSLConnectionSocketFactory(
						getCustomSSLContext(trustStrategy), 
						getCustomHostnameVerifier(hostnameVerificationStrategy));
	}

	/**
	 * @param strategy
	 * @return
	 * @throws KeyManagementException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyStoreException
	 */
	private static SSLContext getCustomSSLContext(TrustReductionStrategy strategy) 
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		
		SSLContextBuilder builder = SSLContextBuilder.create();
		switch (strategy) {
			case TRUST_ALL:
				return builder.loadTrustMaterial(new TrustAllStrategy()).build();
			case TRUST_SELFSIGNED:
				return builder.loadTrustMaterial(new TrustSelfSignedStrategy()).build();
			default:
				throw new NoSuchAlgorithmException();
			}
	}

	/**
	 * @param strategy
	 * @return
	 */
	private static HostnameVerifier getCustomHostnameVerifier(HostnameVerificationStrategy strategy) {
		switch (strategy) {
			case DONT_VERIFY_HOSTNAMES:
				return new NoopHostnameVerifier();
			case VERIFY_HOSTNAMES:
				return new DefaultHostnameVerifier();
			default:
				throw new IllegalArgumentException();
		}
	}
}
