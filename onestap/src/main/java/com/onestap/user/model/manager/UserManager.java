/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.model.manager;

import android.support.annotation.NonNull;

import com.onestap.OST;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.exceptions.GlobalException;
import com.onestap.core.helper.LoggerHelper;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.model.manager.OSTBaseManager;
import com.onestap.core.service.NetworkConnection;
import com.onestap.user.model.domain.entities.AccountResponse;
import com.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.user.model.domain.entities.TempProfile;
import com.onestap.user.presenter.contract.UserContract;
import com.onestap.user.service.UserService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class UserManager extends OSTBaseManager implements UserContract.Manager {

    private UserService service;


    public UserManager() {
        service = NetworkConnection.retrofit(OST.getInstance().getPrivateApiUrl()).create(UserService.class);
    }


    @Override
    public void savePendingProfile(TempProfile body, final CallbackBoundary<PendingProfile> callbackBoundary) {
        super.callbackBoundary(callbackBoundary);

        service.saveTempProfile(body).enqueue(new Callback<PendingProfile>() {
            @Override
            public void onResponse(@NonNull Call<PendingProfile> call, @NonNull Response<PendingProfile> response) {
                if (response.isSuccessful() && response.body().hasSuccess()) {
                    OST.getInstance().getConfiguration().setDataKey(response.body().getDataKey());
                    callbackBoundary.success(response.body());
                } else {
                    try {
                        callbackBoundary.error(new GlobalException(response.errorBody().string()));
                    } catch (IOException e) {
                        callbackBoundary.error(e);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<PendingProfile> call, Throwable t) {
                LoggerHelper.error(t);
                callbackBoundary.error(t);
            }
        });
    }


    @Override
    public void getUser(final CallbackBoundary<AccountResponse> callbackBoundary, AuthToken token, String... categories) {
        super.callbackBoundary(callbackBoundary);
        final String authorization = "Bearer " + token.getAccessToken();

        service.getUser(authorization, categories).enqueue(new Callback<AccountResponse>() {
            @Override
            public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                if (response.isSuccessful() && response.body().hasSuccess())
                    callbackBoundary.success(response.body());
                else {
                    try {
                        callbackBoundary.error(new GlobalException(response.errorBody().string()));
                    } catch (IOException e) {
                        callbackBoundary.error(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<AccountResponse> call, Throwable t) {
                LoggerHelper.error(t);
                callbackBoundary.error(t);
            }
        });
    }
}
