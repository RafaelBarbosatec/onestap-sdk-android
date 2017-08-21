/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth.model.manager;

import com.onestap.onestap.OST;
import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.auth.service.AuthService;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;

import com.onestap.onestap.core.service.NetworkConnection;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class AuthManager {

    private AuthService service;

    public AuthManager() {
        service = NetworkConnection.retrofit(OST.getInstance().getBaseApiUrl()).create(AuthService.class);
    }


    public void request(Map<String, String> options, final CallbackBoundary callbackBoundary){
        service.request(options).enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
                if (response.isSuccessful() && response.body().hasSuccess()) {
                    callbackBoundary.success(response.body());
                } else {
                    callbackBoundary.error(new Throwable(response.code() + " Error: " + response.message()));
                }
            }

            @Override
            public void onFailure(Call<AuthToken> call, Throwable t) {
                callbackBoundary.error(t);
            }
        });
    }
}
