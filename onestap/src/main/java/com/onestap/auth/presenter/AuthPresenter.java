/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.presenter;

import android.content.Context;

import com.onestap.auth.model.usecase.AuthUseCase;
import com.onestap.auth.presenter.contract.AuthContract;
import com.onestap.core.model.domain.boundary.CallbackBoundary;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class AuthPresenter implements AuthContract.Presenter {

    private Context context;
    private AuthUseCase useCase;

    public AuthPresenter(Context context) {
        this.context = context;
        this.useCase = new AuthUseCase(context);
    }

    @Override
    public void requestToken(String authCode, CallbackBoundary callbackBoundary) {
        useCase.requestToken(authCode, callbackBoundary);
    }

    @Override
    public void refreshToken(CallbackBoundary callbackBoundary) {
        useCase.refreshToken(callbackBoundary);
    }

    @Override
    public void verifyToken(CallbackBoundary callbackBoundary) {
        useCase.verifyToken(callbackBoundary);
    }

    @Override
    public void revokeToken(final CallbackBoundary callbackBoundary) {
        useCase.revokeToken(callbackBoundary);
    }

}
