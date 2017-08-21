/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap;

import com.onestap.onestap.core.model.domain.enumerator.OSTEnvironment;
import com.onestap.onestap.core.util.StringUtil;
import com.onestap.onestap.profile.model.domain.entities.TempProfile;

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

    private String dataKey;

    private TempProfile pendingProfile;

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

    OSTEnvironment getEnvironment() {
        if(environment == null)
            throw new RuntimeException("Environment not defined");
        return environment;
    }

    String getDataKey() {
        if(dataKey == null){
            throw new RuntimeException("Data key not defined");
        }
        return dataKey;
    }


    public TempProfile getPendingProfile() {
        return pendingProfile;
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

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public void setPendingProfile(TempProfile pendingProfile) {
        this.pendingProfile = pendingProfile;
    }

    public void setEnvironment(OSTEnvironment environment) {
        this.environment = environment;
    }



}

