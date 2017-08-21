/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth.presenter.contract;

import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface AuthContract {

        void requestToken(String authCode, CallbackBoundary callbackBoundary);

        void refreshToken(AuthToken token, CallbackBoundary callbackBoundary);

        void verifyToken(AuthToken token, CallbackBoundary callbackBoundary);

        void revokeToken(AuthToken token, CallbackBoundary callbackBoundary);


    interface Manager extends AuthContract {

    }

    interface UseCase {
        void requestToken(String authCode, CallbackBoundary callbackBoundary);

        void refreshToken(CallbackBoundary callbackBoundary);

        void verifyToken(CallbackBoundary callbackBoundary);

        void revokeToken(CallbackBoundary callbackBoundary);
    }

    interface Presenter {
        void requestToken(String authCode, CallbackBoundary callbackBoundary);

        void refreshToken(CallbackBoundary callbackBoundary);

        void verifyToken(CallbackBoundary callbackBoundary);

        void revokeToken(CallbackBoundary callbackBoundary);
    }
}
