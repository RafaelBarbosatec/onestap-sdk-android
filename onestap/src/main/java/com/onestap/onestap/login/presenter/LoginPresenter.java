/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.login.presenter;

import android.content.Context;

import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.auth.model.usecase.AuthUseCase;
import com.onestap.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.onestap.core.model.manager.LocalDataManager;
import com.onestap.onestap.core.presenter.OSTBasePresenter;
import com.onestap.onestap.core.presenter.contract.LocalDataManagerContract;
import com.onestap.onestap.login.presenter.contract.LoginContract;
import com.onestap.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.onestap.user.model.domain.entities.TempProfile;
import com.onestap.onestap.user.model.usecase.UserUseCase;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class LoginPresenter extends OSTBasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private AuthUseCase authUseCase;
    private UserUseCase userUseCase;
    private LocalDataManagerContract localManager;
    private Context context;

    public LoginPresenter(Context context) {
        this.context = context;
        this.authUseCase = new AuthUseCase(context);
        this.userUseCase = new UserUseCase(context);

        this.localManager = new LocalDataManager(context);
    }

    @Override
    public void loadCredentials(String authCode) {
        authUseCase.requestToken(authCode, new AuthCallback() {
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
