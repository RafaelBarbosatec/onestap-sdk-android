/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap;

import android.content.Context;

import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.model.domain.enumerator.OSTEnvironment;
import com.onestap.core.model.domain.enumerator.Options;
import com.onestap.core.model.manager.LocalDataManager;
import com.onestap.core.util.StringUtil;
import com.onestap.core.util.UrlUtil;
import com.onestap.user.model.domain.entities.TempProfile;

import java.util.UUID;

/**
 * Created on 17/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class OST {
    private static final OST INSTANCE = new OST();

    private Context context;
    private LocalDataManager localDataManager;
    private OSTConfiguration configuration;

    private String fingerPrintSessionId;


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
        getInstance().localDataManager = new LocalDataManager(context);
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
        if (StringUtil.isEmptyOrNull(fingerPrintSessionId)) {
            fingerPrintSessionId = UUID.randomUUID().toString();
        }
        return fingerPrintSessionId;
    }

    public String getFingerPrintID(){
        return configuration.getFingerPrintID();
    }

    public String getDataKey() {
        return configuration.getDataKey();
    }


    public AuthToken getToken() {
        return localDataManager.get(Options.ACCESS_TOKEN.name(), AuthToken.class);
    }

    public TempProfile getTempProfile() {
        return configuration.getTempProfile();
    }


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
