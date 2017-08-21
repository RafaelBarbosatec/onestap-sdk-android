/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.model.usecase;



import com.onestap.onestap.OST;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcosilva on 10/07/2017.
 */

public abstract class BaseUseCase {

    protected abstract void request();


    protected Map<String, String> options;
    protected CallbackBoundary callbackBoundary;

    protected BaseUseCase() {
        options = new HashMap<>();
        options.put("CLIENT_ID", OST.getInstance().getClientId());
        options.put("CLIENT_SECRET", OST.getInstance().getClientSecret());
    }


}
