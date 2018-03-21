package com.github.cschulc.jirarestservice.util;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class URIHelper {

    public static URI parseStringToURI(String uri) {
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes, UrlValidator.ALLOW_LOCAL_URLS);
        if(urlValidator.isValid(uri)){
            try {
                return new URI(uri);
            } catch (URISyntaxException e) {
                return null;
            }
        }
        return null;
    }
}
