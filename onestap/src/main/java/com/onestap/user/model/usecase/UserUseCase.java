/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.model.usecase;

import android.content.Context;

import com.onestap.OST;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.model.usecase.BaseUseCase;
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


    private Context context;
    private UserManager manager;

    public UserUseCase(Context context) {
        super();
        this.context = context;
        this.manager = new UserManager();
    }

    @Override
    public void savePendingProfile(TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary) {
        body.setApplicationKey(OST.getInstance().getClientId());
        manager.savePendingProfile(body, callbackBoundary);
    }
}
