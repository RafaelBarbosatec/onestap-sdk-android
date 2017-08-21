/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth.presenter;

import android.content.Context;

import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.auth.model.usecase.AuthUseCase;
import com.onestap.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.onestap.core.model.domain.enumerator.Options;
import com.onestap.onestap.core.model.manager.LocalDataManager;
import com.onestap.onestap.core.util.StringUtil;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class OSTAuth {

    private Context context;
    private AuthUseCase useCase;
    private LocalDataManager localManager;
    private AuthToken token;

    public OSTAuth(Context context) {
        this.context = context;
        this.useCase = new AuthUseCase();
        this.localManager = new LocalDataManager(context);
        this.token = localManager.get(Options.ACCESS_TOKEN.toString(), AuthToken.class);
    }


    public void requestToken(String authCode, final AuthCallback callbackBoundary) {
        if(StringUtil.isEmptyOrNull(authCode)){
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            useCase.requestToken(authCode, new AuthCallback() {
                @Override
                public void success(AuthToken response) {
                    callbackBoundary.success(response);
                    localManager.save(response, Options.ACCESS_TOKEN.toString());
//                    FingerPrintManager.sendFingerPrint(context, response);
                }

                @Override
                public void error(Throwable e) {
                    callbackBoundary.error(e);
                }
            });
        }
    }

    public void refreshToken(CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            useCase.refreshToken(token, callbackBoundary);
//            FingerPrintManager.sendFingerPrint(context, token);
        }
    }

    public void verifyToken(CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            useCase.verifyToken(token, callbackBoundary);
//            FingerPrintManager.sendFingerPrint(context, token);
        }
    }

    public void revokeToken(final CallbackBoundary callbackBoundary) {
        if (token == null) {
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            useCase.revokeToken(token, new CallbackBoundary<AuthToken>() {
                @Override
                public void success(AuthToken response) {
                    callbackBoundary.success(response);
                    localManager.remove(Options.ACCESS_TOKEN.toString());
//                    FingerPrintManager.sendFingerPrint(context, response);
                }

                @Override
                public void error(Throwable e) {
                    callbackBoundary.error(e);
                }
            });
        }
    }



}
