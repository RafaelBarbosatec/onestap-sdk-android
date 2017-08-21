/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.model.manager;

import com.onestap.onestap.OST;
import com.onestap.onestap.core.model.domain.enumerator.Options;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public abstract class OSTBaseManager {

    protected Map<String, String> options;

    protected abstract void request();


    protected OSTBaseManager() {
        options = new HashMap<>();
        options.put(Options.CLIENT_ID.toString(), OST.getInstance().getClientId());
        options.put(Options.CLIENT_SECRET.toString(), OST.getInstance().getClientSecret());
    }

}
