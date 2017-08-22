/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.util;


import com.onestap.OST;
import com.onestap.core.model.domain.enumerator.OSTEnvironment;

import static com.onestap.onestap.BuildConfig.BASE_API_URL;
import static com.onestap.onestap.BuildConfig.BASE_API_URL_SANDBOX;
import static com.onestap.onestap.BuildConfig.BUILD_TYPE;
import static com.onestap.onestap.BuildConfig.DATA_KEY;
import static com.onestap.onestap.BuildConfig.FLIP_LOGIN_URL;
import static com.onestap.onestap.BuildConfig.HOST;
import static com.onestap.onestap.BuildConfig.KEY;
import static com.onestap.onestap.BuildConfig.PARAM_DATA_KEY;
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


    public static String getLoginUrl(OSTEnvironment environment) {
        if (BUILD_TYPE == "staging")
            return SIGNIN_API_URL;

        switch (environment) {
            case SANDBOX:
                return buildLoginUrl(SIGNIN_API_URL_SANDBOX);

            case PRODUCTION:
                return buildLoginUrl(SIGNIN_API_URL);

            default:
                throw new RuntimeException("Environment no defined!");
        }

    }


    public static String getBaseUrl(OSTEnvironment environment) {
        if(BUILD_TYPE == "staging")
            return BASE_API_URL;

        switch (environment) {
            case SANDBOX:
                return BASE_API_URL_SANDBOX;

            case PRODUCTION:
                return BASE_API_URL;

            default:
                throw new RuntimeException("Environment no defined!");
        }
    }


    public static String getPrivateUrl(OSTEnvironment environment) {
        if(BUILD_TYPE == "staging")
            return PRIVATE_API_URL;

        switch (environment) {
            case SANDBOX:
                return PRIVATE_API_URL_SANDBOX;

            case PRODUCTION:
                return PRIVATE_API_URL;

            default:
                throw new RuntimeException("Environment no defined!");

        }
    }

    protected static String buildLoginUrl(String uri) {
        StringBuilder builder = new StringBuilder(
                FLIP_LOGIN_URL
                        .replace(URI, uri)
                        .replace(KEY, OST.getInstance().getClientId())
                        .replace(HOST, OST.getInstance().getHost())
                        .replace(SCHEMA, OST.getInstance().getSchema())
                        .replace(STATE, OST.getInstance().getFingerPrintSessionId())
        );

        if (OST.getInstance().getTempProfile() != null) {

            return builder
                    .append(
                            PARAM_DATA_KEY
                                    .replace(
                                            DATA_KEY,
                                            OST.getInstance().getDataKey() == null ? "" : OST.getInstance().getDataKey()
                                    )
                    ).toString();
        } else {
            return builder.toString();
        }
    }

}
