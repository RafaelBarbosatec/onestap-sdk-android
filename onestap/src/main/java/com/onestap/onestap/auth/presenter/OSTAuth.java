/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth.presenter;

import android.content.Context;

import com.onestap.onestap.auth.model.usecase.AuthUseCase;
import com.onestap.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class OSTAuth {

    private Context context;
    private AuthUseCase useCase;

    public OSTAuth(Context context) {
        this.context = context;
        this.useCase = new AuthUseCase(context);
    }


    public void requestToken(String authCode, final AuthCallback callbackBoundary) {
        useCase.requestToken(authCode, callbackBoundary);
    }

    public void refreshToken(CallbackBoundary callbackBoundary) {
        useCase.refreshToken(callbackBoundary);
    }

    public void verifyToken(CallbackBoundary callbackBoundary) {
        useCase.verifyToken(callbackBoundary);
    }

    public void revokeToken(final CallbackBoundary callbackBoundary) {
        useCase.revokeToken(callbackBoundary);
    }



}
