/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.model.manager;

import com.onestap.OST;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.auth.presenter.contract.AuthContract;
import com.onestap.auth.service.AuthService;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.model.domain.enumerator.Method;
import com.onestap.core.model.domain.enumerator.Options;
import com.onestap.core.model.manager.OSTBaseManager;
import com.onestap.core.service.NetworkConnection;
import com.onestap.core.util.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class AuthManager extends OSTBaseManager implements AuthContract.Manager {

    private AuthService service;
    private CallbackBoundary callbackBoundary;


    public AuthManager() {
        service = NetworkConnection.retrofit(OST.getInstance().getBaseApiUrl()).create(AuthService.class);
        options.put(Options.REDIRECT_URI.toString(), OST.getInstance().getSchema() + "://" + OST.getInstance().getHost());
    }


    @Override
    public void request(){
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
                Logger.error(t);
                callbackBoundary.error(t);
            }
        });
    }


    @Override
    public void requestToken(String authCode, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.AUTHORIZATION_CODE.toString(), authCode);
        options.put(Options.GRANT_TYPE.toString(), Method.AUTHORIZATION_CODE.name());

        request();
    }

    @Override
    public void refreshToken(AuthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.REFRESH_TOKEN.toString(), token.getRefreshToken());
        options.put(Options.GRANT_TYPE.toString(), Method.REFRESH_TOKEN.name());

        request();
    }

    @Override
    public void verifyToken(AuthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.ACCESS_TOKEN.toString(), token.getAccessToken());
        options.put(Options.GRANT_TYPE.toString(), Method.VERIFY_TOKEN.name());

        request();
    }

    @Override
    public void revokeToken(AuthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.ACCESS_TOKEN.toString(), token.getAccessToken());
        options.put(Options.GRANT_TYPE.toString(), Method.REVOKE_TOKEN.toString());

        request();
    }

}
