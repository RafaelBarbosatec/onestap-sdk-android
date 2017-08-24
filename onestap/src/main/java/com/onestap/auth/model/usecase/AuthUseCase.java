/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.model.usecase;

import android.content.Context;

import com.onestap.OST;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.auth.model.manager.AuthManager;
import com.onestap.auth.presenter.contract.AuthContract;
import com.onestap.core.helper.LoggerHelper;
import com.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.model.domain.enumerator.Options;
import com.onestap.core.model.manager.FingerPrintManager;
import com.onestap.core.model.manager.LocalDataManager;
import com.onestap.core.model.usecase.BaseUseCase;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class AuthUseCase extends BaseUseCase implements AuthContract.UseCase {


    private Context context;
    private LocalDataManager localManager;
    private AuthToken token;
    private AuthManager manager;

    public AuthUseCase(Context context) {
        super();
        this.context = context;
        this.localManager = new LocalDataManager(context);
        this.token = localManager.getData(Options.ACCESS_TOKEN.toString(), AuthToken.class);
        this.manager = new AuthManager();

        options.put(Options.REDIRECT_URI.toString(), OST.getInstance().getSchema() + "://" + OST.getInstance().getHost());
    }

    @Override
    public void requestToken(String authCode, final CallbackBoundary callbackBoundary) {
        manager.requestToken(authCode, new AuthCallback() {
            @Override
            public void success(AuthToken response) {
                callbackBoundary.success(response);
                localManager.saveData(response, Options.ACCESS_TOKEN.toString());
                FingerPrintManager.sendFingerPrint(context, response);
            }

            @Override
            public void error(Throwable e) {
                LoggerHelper.error(e);
                callbackBoundary.error(e);
            }
        });
    }

    @Override
    public void refreshToken(final CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            manager.refreshToken(token, callbackBoundary);
            FingerPrintManager.sendFingerPrint(context, token);
        }
    }

    @Override
    public void verifyToken(final CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            manager.verifyToken(token, callbackBoundary);
            FingerPrintManager.sendFingerPrint(context, token);
        }
    }

    @Override
    public void revokeToken(final CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            manager.revokeToken(token, new CallbackBoundary<AuthToken>() {
                @Override
                public void success(AuthToken response) {
                    callbackBoundary.success(response);
                    localManager.remove(Options.ACCESS_TOKEN.toString());
                    FingerPrintManager.sendFingerPrint(context, response);
                }

                @Override
                public void error(Throwable e) {
                    LoggerHelper.error(e);
                    callbackBoundary.error(e);
                }
            });
        }
    }


}
