/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.service;

import com.onestap.core.helper.LoggerHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class NetworkConnection {

    private static OkHttpClient client() {
        return new OkHttpClient.Builder().addInterceptor(interceptor()).build();
    }

    public static Retrofit retrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client())
                .build();
    }


    public static Interceptor interceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                String urlRequest = request.url().toString();
                String keyResponse = response.header("requestKey");

                LoggerHelper.debug(String.format("{ \n url: %1s, \n key: %2s \n }",  urlRequest, keyResponse));

                return response;
            }
        };
    }
}
