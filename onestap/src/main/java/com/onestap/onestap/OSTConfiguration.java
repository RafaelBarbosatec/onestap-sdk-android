/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap;

import com.onestap.onestap.core.model.domain.enumerator.OSTEnvironment;
import com.onestap.onestap.core.util.StringUtil;

import java.util.UUID;

/**
 * Created on 17/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class OSTConfiguration {

    private String clientId;
    private String host;
    private String schema;
    private String clientSecret;
    private String fingerPrintID;
    private String fingerPrintSessionId;

    private String dataKey;

    private OSTEnvironment environment;


    public OSTConfiguration() {

    }



    /*****

     GETTERS

     ****/


    String getClientId() {
        if (clientId == null)
            throw new RuntimeException("clientId not defined");
        return clientId;
    }

    String getHost() {
        if (host == null)
            throw new RuntimeException("Host not defined");
        return host;
    }


    String getSchema() {
        if (schema == null)
            throw new RuntimeException("Schema not defined");
        return schema;
    }

    String getClientSecret() {
        if (clientSecret == null)
            throw new RuntimeException("ClientSecret not defined");
        return clientSecret;
    }

    String getFingerPrintID() {
        if (fingerPrintID == null)
            throw new RuntimeException("FingerPrint not defined");
        return fingerPrintID;
    }

    String getFingerPrintSessionId() {
        if (StringUtil.isEmptyOrNull(fingerPrintSessionId)) {
            fingerPrintSessionId = UUID.randomUUID().toString();
        }
        return fingerPrintSessionId;
    }

    OSTEnvironment getEnvironment() {
        if(environment == null)
            throw new RuntimeException("Environment not defined");
        return environment;
    }

     String getLoginUrl(){
        switch (this.getEnvironment()){
//            case SANDBOX:
//                return BuildConfig.FLIP_LOGIN_SANDBOX;
//            case PRODUCTION:
//                return BuildConfig.FLIP_LOGIN_PRODUCTION;
            default:
                throw new RuntimeException("Environment not configured to get base url");
        }
    }

    String getBaseApiUrl(){
        switch (this.getEnvironment()){
//            case SANDBOX:
//                return BuildConfig.API_BASE_URL_SANDBOX;
//            case PRODUCTION:
//                return BuildConfig.API_BASE_URL_SANDBOX;
            default:
                throw new RuntimeException("Environment not configured to get base url");
        }
    }

    String getPrivateApiUrl(){
        switch (this.getEnvironment()){
//            case SANDBOX:
//                return BuildConfig.PRIVATE_API_SANDBOX;
//            case PRODUCTION:
//                return BuildConfig.PRIVATE_API_PRODUCTION;
            default:
                throw new RuntimeException("Environment not configured to get private url");
        }
    }


    String getDataKey() {
        if(dataKey == null){
            throw new RuntimeException("Data key not defined");
        }
        return dataKey;
    }

    /*****

     SETTERS

     ****/


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setFingerPrintID(String fingerPrintID) {
        this.fingerPrintID = fingerPrintID;
    }

    public void setFingerPrintSessionId(String fingerPrintSessionId) {
        this.fingerPrintSessionId = fingerPrintSessionId;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public void setEnvironment(OSTEnvironment environment) {
        this.environment = environment;
    }



}

