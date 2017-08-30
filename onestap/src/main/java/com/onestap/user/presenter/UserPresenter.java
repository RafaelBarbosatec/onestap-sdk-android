/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.presenter;

import android.content.Context;

import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.user.model.domain.entities.AccountResponse;
import com.onestap.user.model.usecase.UserUseCase;
import com.onestap.user.presenter.contract.UserContract;

/**
 * Created on 28/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class UserPresenter implements UserContract.Presenter {

    private UserUseCase useCase;

    public UserPresenter(Context context) {
        this.useCase = new UserUseCase(context);

    }

    @Override
    public void getUser(CallbackBoundary<AccountResponse> callbackBoundary) {
        useCase.getUser(callbackBoundary);
    }
}
