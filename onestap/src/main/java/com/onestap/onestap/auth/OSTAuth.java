/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth;

import android.content.Context;

import com.onestap.onestap.auth.presenter.AuthPresenter;
import com.onestap.onestap.auth.presenter.contract.AuthContract;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class OSTAuth {

    private Context context;
    private AuthContract.Presenter presenter;

    public OSTAuth(Context context) {
        this.context = context;
        this.presenter = new AuthPresenter(context);
    }


    public void requestToken(String authCode, CallbackBoundary callbackBoundary) {
        presenter.requestToken(authCode, callbackBoundary);
    }

    public void refreshToken(CallbackBoundary callbackBoundary) {
        presenter.refreshToken(callbackBoundary);
    }

    public void verifyToken(CallbackBoundary callbackBoundary) {
        presenter.verifyToken(callbackBoundary);
    }

    public void revokeToken(final CallbackBoundary callbackBoundary) {
        presenter.revokeToken(callbackBoundary);
    }
}
