/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.util;


import com.onestap.onestap.OST;
import com.onestap.onestap.core.model.domain.enumerator.OSTEnvironment;

import static com.onestap.onestap.BuildConfig.BASE_API_URL;
import static com.onestap.onestap.BuildConfig.BASE_API_URL_SANDBOX;
import static com.onestap.onestap.BuildConfig.DATA_KEY;
import static com.onestap.onestap.BuildConfig.HOST;
import static com.onestap.onestap.BuildConfig.KEY;
import static com.onestap.onestap.BuildConfig.PRIVATE_API_URL;
import static com.onestap.onestap.BuildConfig.PRIVATE_API_URL_SANDBOX;
import static com.onestap.onestap.BuildConfig.SCHEMA;
import static com.onestap.onestap.BuildConfig.SIGNIN_API_URL;
import static com.onestap.onestap.BuildConfig.SIGNIN_API_URL_SANDBOX;
import static com.onestap.onestap.BuildConfig.STATE;
import static com.onestap.onestap.BuildConfig.URI;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class UrlUtil {


    public static String getLoginUrl(OSTEnvironment environment){
        switch (environment){
            case SANDBOX: {
                return OST.getInstance().getLoginUrl()
                        .replace(URI, SIGNIN_API_URL_SANDBOX)
                        .replace(KEY, OST.getInstance().getClientId())
                        .replace(HOST, OST.getInstance().getHost())
                        .replace(SCHEMA, OST.getInstance().getSchema())
                        .replace(STATE, OST.getInstance().getFingerPrintSessionId())
                        .replace(DATA_KEY, OST.getInstance().getDataKey() == null ? "" : OST.getInstance().getDataKey());
            }

            case PRODUCTION: {
                return OST.getInstance().getLoginUrl()
                        .replace(URI, SIGNIN_API_URL)
                        .replace(KEY, OST.getInstance().getClientId())
                        .replace(HOST, OST.getInstance().getHost())
                        .replace(SCHEMA, OST.getInstance().getSchema())
                        .replace(STATE, OST.getInstance().getFingerPrintSessionId())
                        .replace(DATA_KEY, OST.getInstance().getDataKey() == null ? "" : OST.getInstance().getDataKey());
            }
            default: {
                throw new RuntimeException("Environment no defined!");
            }
        }
    }


    public static String getBaseUrl(OSTEnvironment environment){
        switch (environment){
            case SANDBOX: {
                return BASE_API_URL_SANDBOX;
            }
            case PRODUCTION: {
                return BASE_API_URL;
            }
            default:
                throw new RuntimeException("Environment no defined!");
        }
    }


    public static String getPrivateUrl(OSTEnvironment environment){
        switch (environment){
            case SANDBOX: {
                return PRIVATE_API_URL_SANDBOX;
            }
            case PRODUCTION: {
                return PRIVATE_API_URL;
            }
            default:
                throw new RuntimeException("Environment no defined!");
        }
    }

}
