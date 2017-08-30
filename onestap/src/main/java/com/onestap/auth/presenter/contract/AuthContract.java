/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.presenter.contract;

import android.content.Context;

import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.presenter.contract.OSTBaseContract;
import com.onestap.user.model.domain.entities.TempProfile;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface AuthContract {




    interface Manager {

        void requestToken(String authCode, CallbackBoundary callbackBoundary);

        void refreshToken(AuthToken token, CallbackBoundary callbackBoundary);

        void verifyToken(AuthToken token, CallbackBoundary callbackBoundary);

        void revokeToken(AuthToken token, CallbackBoundary callbackBoundary);
    }

    interface UseCase {
        void requestToken(String authCode, CallbackBoundary callbackBoundary);

        void refreshToken(CallbackBoundary callbackBoundary);

        void verifyToken(CallbackBoundary callbackBoundary);

        void revokeToken(CallbackBoundary callbackBoundary);
    }

    interface Presenter extends OSTBaseContract.Presenter<AuthContract.View> {

        void requestToken(String authCode, CallbackBoundary callbackBoundary);

        void refreshToken(CallbackBoundary callbackBoundary);

        void verifyToken(CallbackBoundary callbackBoundary);

        void revokeToken(CallbackBoundary callbackBoundary);

        void loadCredentials(String authCode);

        void saveTemporaryProfile(TempProfile tempProfile);

    }

    interface View extends OSTBaseContract.View {

        void loginWithSuccess(AuthToken token);

        void loginFailed(Throwable t);

        void goToWebView();
    }

}
