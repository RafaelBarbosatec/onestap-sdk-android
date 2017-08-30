/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.manager;



import com.onestap.core.model.domain.boundary.CallbackBoundary;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kanda on 10/07/2017.
 */

public abstract class OSTBaseManager<T> implements Callback<T> {

    private CallbackBoundary callbackBoundary;

    public void callbackBoundary(CallbackBoundary callbackBoundary) {
        this.callbackBoundary = callbackBoundary;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            callbackBoundary.success(response.body());
        } else {
            callbackBoundary.error(new Throwable(response.code() + " Error: " + response.message()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        callbackBoundary.error(t);
    }
}
