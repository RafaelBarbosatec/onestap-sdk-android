/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.onestap.core.helper.SharedPreferenceHelper;
import com.onestap.core.presenter.contract.LocalDataManagerContract;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class LocalDataManager implements LocalDataManagerContract {

    private SharedPreferenceHelper mPreferenceHelper;

    public LocalDataManager(Context context) {
        this.mPreferenceHelper = new SharedPreferenceHelper(context);
    }


    @Override
    public void saveData(Object value, String key) {
        this.mPreferenceHelper.writeData(key, new Gson().toJson(value));
    }

    @Override
    public void remove(String key) {
        this.mPreferenceHelper.remove(key);
    }

    @Override
    public <T> T getData(String key, Class<T> clazz) {
        return new Gson().fromJson(this.mPreferenceHelper.readStringData(key), clazz);
    }
}
