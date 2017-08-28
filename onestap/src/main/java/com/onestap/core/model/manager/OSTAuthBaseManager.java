/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.manager;

import com.onestap.OST;
import com.onestap.core.model.domain.enumerator.Options;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public abstract class OSTAuthBaseManager {

    protected Map<String, String> options;

    protected abstract void request();


    protected OSTAuthBaseManager() {
        options = new HashMap<>();
        options.put(Options.CLIENT_ID.toString(), OST.getInstance().getClientId());
        options.put(Options.CLIENT_SECRET.toString(), OST.getInstance().getClientSecret());
    }

}
