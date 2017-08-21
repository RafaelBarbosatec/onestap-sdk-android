/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth.model.usecase;

import com.onestap.onestap.OST;
import com.onestap.onestap.auth.AuthContract;
import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.auth.model.manager.AuthManager;
import com.onestap.onestap.auth.service.AuthService;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.onestap.core.model.domain.enumerator.Method;
import com.onestap.onestap.core.model.domain.enumerator.Options;
import com.onestap.onestap.core.model.usecase.BaseUseCase;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class AuthUseCase extends BaseUseCase implements AuthContract {

    private AuthManager service;

    @Override
    protected void request() {
        service.request(options, callbackBoundary);
    }

    public AuthUseCase() {
        super();
        service = new AuthManager();
        options.put(Options.REDIRECT_URI.toString(), OST.getInstance().getSchema() + "://" + OST.getInstance().getHost());
    }

    @Override
    public void requestToken(String authCode, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.AUTHORIZATION_CODE.toString(), authCode);
        options.put(Options.GRANT_TYPE.toString(), Method.AUTHORIZATION_CODE.name());
        service.request(options, callbackBoundary);
        request();
    }

    @Override
    public void refreshToken(AuthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.REFRESH_TOKEN.toString(), token.getRefreshToken());
        options.put(Options.GRANT_TYPE.toString(), Method.REFRESH_TOKEN.name());
        service.request(options, callbackBoundary);
        request();
    }

    @Override
    public void verifyToken(AuthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.ACCESS_TOKEN.toString(), token.getAccessToken());
        options.put(Options.GRANT_TYPE.toString(), Method.VERIFY_TOKEN.name());
        service.request(options, callbackBoundary);
        request();
    }

    @Override
    public void revokeToken(AuthToken token, CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
        options.put(Options.ACCESS_TOKEN.toString(), token.getAccessToken());
        options.put(Options.GRANT_TYPE.toString(), Method.REVOKE_TOKEN.toString());
        service.request(options, callbackBoundary);
        request();
    }


}
