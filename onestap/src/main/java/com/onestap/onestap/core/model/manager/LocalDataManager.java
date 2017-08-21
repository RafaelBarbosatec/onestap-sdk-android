/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.model.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.jgabrielfreitas.datacontroller.DataController;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class LocalDataManager {

    private DataController dataController;

    public LocalDataManager(Context context) {
        this.dataController = new DataController(context);
    }


    public void save(Object value, String key){
        dataController.writeData(key, new Gson().toJson(value));
    }

    public void remove(String key){
        dataController.remove(key);
    }

    public <T> T get(String key, Class<T> clazz){
        return new Gson().fromJson(dataController.readStringData(key), clazz);
    }
}
