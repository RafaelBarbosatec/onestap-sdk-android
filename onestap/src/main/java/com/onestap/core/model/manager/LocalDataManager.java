/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.jgabrielfreitas.datacontroller.DataController;
import com.onestap.core.presenter.contract.LocalDataManagerContract;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class LocalDataManager implements LocalDataManagerContract {

    private DataController dataController;

    public LocalDataManager(Context context) {
        this.dataController = new DataController(context);
    }

    @Override
    public void save(Object value, String key){
        dataController.writeData(key, new Gson().toJson(value));
    }

    @Override
    public void remove(String key){
        dataController.remove(key);
    }

    @Override
    public <T> T get(String key, Class<T> clazz){
        return new Gson().fromJson(dataController.readStringData(key), clazz);
    }

}
