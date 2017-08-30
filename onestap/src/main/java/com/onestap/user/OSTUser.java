/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user;

import android.content.Context;

import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.user.model.domain.entities.AccountResponse;
import com.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.user.model.domain.entities.TempProfile;
import com.onestap.user.model.usecase.UserUseCase;
import com.onestap.user.presenter.contract.UserContract;

/**
 * Created on 30/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public final class OSTUser implements UserContract {


    private Context context;
    private UserContract.UseCase useCase;

    public OSTUser(Context context) {
        this.context = context;
        this.useCase = new UserUseCase(context);
    }


    @Override
    public void savePendingProfile(TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary) {
        useCase.savePendingProfile(body, callbackBoundary);
    }

    @Override
    public void getUser(CallbackBoundary<AccountResponse> callbackBoundary, String... categories) {
        useCase.getUser(callbackBoundary, categories);
    }
}
