/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap;

import android.content.Context;

import com.onestap.onestap.core.model.domain.enumerator.OSTEnvironment;
import com.onestap.onestap.core.util.UrlUtil;

/**
 * Created on 17/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class OST {
    private static final OST INSTANCE = new OST();

    private Context context;
    private OSTConfiguration configuration;

    /**
     *
     * @return instance from OST class
     */
    public static OST getInstance() {
        return INSTANCE;
    }


    public static void initializer(Context context, OSTConfiguration configuration){
        getInstance().context = context;
        getInstance().configuration = configuration;
    }


    public OSTConfiguration getConfiguration() {
        return configuration;
    }

    public String getClientId() {
        return configuration.getClientId();
    }

    public String getHost() {
        return configuration.getHost();
    }

    public String getSchema() {
        return configuration.getSchema();
    }

    public String getClientSecret() {
        return configuration.getClientSecret();
    }

    public String getFingerPrintSessionId() {
        return configuration.getFingerPrintSessionId();
    }

    public String getFingerPrintID(){
        return configuration.getFingerPrintID();
    }

    public String getDataKey() {
        return configuration.getDataKey();
    }

    public OSTConfiguration getConnectConfigurations() {
        return configuration;
    }

//    public AuthToken getToken() {
//        return localManager.getOauth(TokenType.ACCESS_TOKEN);
//    }

    public OSTEnvironment getEnvironment(){
        return configuration.getEnvironment();
    }

    public String getLoginUrl(){
        return UrlUtil.getLoginUrl(getEnvironment());
    }

    public String getBaseApiUrl(){
        return UrlUtil.getBaseUrl(getEnvironment());
    }

    public String getPrivateApiUrl(){
        return UrlUtil.getPrivateUrl(getEnvironment());
    }
}
