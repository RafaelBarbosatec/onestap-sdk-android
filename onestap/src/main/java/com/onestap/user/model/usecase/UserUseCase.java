/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.model.usecase;

import android.content.Context;

import com.onestap.OST;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.model.domain.enumerator.Options;
import com.onestap.core.model.usecase.BaseUseCase;
import com.onestap.user.model.domain.entities.AccountResponse;
import com.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.user.model.domain.entities.TempProfile;
import com.onestap.user.model.manager.UserManager;
import com.onestap.user.presenter.contract.UserContract;

/**
 * Created on 22/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class UserUseCase extends BaseUseCase implements UserContract.UseCase {


    private UserManager manager;
    private AuthToken token;

    public UserUseCase(Context context) {
        super(context);
        this.manager = new UserManager();
        this.token = localManager.getData(Options.ACCESS_TOKEN.toString(), AuthToken.class);
    }

    @Override
    public void savePendingProfile(TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary) {
        body.setApplicationKey(OST.getInstance().getClientId());
        manager.savePendingProfile(body, callbackBoundary);
    }

    @Override
    public void getUser(CallbackBoundary<AccountResponse> callbackBoundary, String... categories) {
        if( token == null ){
            callbackBoundary.error(new Throwable("Token not found"));
        } else {
            manager.getUser(callbackBoundary, token, categories);
        }
    }
}
