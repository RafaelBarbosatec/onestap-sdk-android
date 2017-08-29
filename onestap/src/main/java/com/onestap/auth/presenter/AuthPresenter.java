/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.onestap.OST;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.auth.model.usecase.AuthUseCase;
import com.onestap.auth.presenter.contract.AuthContract;
import com.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.presenter.OSTBasePresenter;
import com.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.user.model.domain.entities.TempProfile;
import com.onestap.user.model.usecase.UserUseCase;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class AuthPresenter extends OSTBasePresenter<AuthContract.View> implements AuthContract.Presenter {

    private Context context;
    private AuthUseCase useCase;
    private UserUseCase userUseCase;

    public AuthPresenter(Context context) {
        this.context = context;
        this.useCase = new AuthUseCase(context);
        this.userUseCase = new UserUseCase(context);
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

    @Override
    public void loadCredentials(String authCode) {
        useCase.requestToken(authCode, new AuthCallback() {
            @Override
            public void success(AuthToken response) {
                getView().loginWithSuccess(response);
            }

            @Override
            public void error(Throwable e) {
                e.printStackTrace();
                getView().loginFailed(e);
            }
        });
    }

    @Override
    public void saveTemporaryProfile(TempProfile tempProfile) {
        userUseCase.savePendingProfile(tempProfile, new CallbackBoundary<PendingProfile>() {
            @Override
            public void success(PendingProfile response) {
                getView().goToWebView();
            }

            @Override
            public void error(Throwable e) {
                getView().goToWebView();
            }
        });
    }

}
