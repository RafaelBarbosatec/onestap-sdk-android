/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.usecase;



import android.content.Context;

import com.onestap.OST;
import com.onestap.core.model.manager.LocalDataManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcosilva on 10/07/2017.
 */

public abstract class BaseUseCase {


    protected LocalDataManager localManager;
    protected Map<String, String> options;

    protected BaseUseCase(Context context) {
        localManager = new LocalDataManager(context);

        options = new HashMap<>();
        options.put("CLIENT_ID", OST.getInstance().getClientId());
        options.put("CLIENT_SECRET", OST.getInstance().getClientSecret());
    }


}
