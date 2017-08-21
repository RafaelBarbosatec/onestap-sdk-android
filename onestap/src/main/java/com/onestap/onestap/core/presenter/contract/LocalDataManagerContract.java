/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.presenter.contract;

import com.google.gson.Gson;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface LocalDataManagerContract {

    void save(Object value, String key);

    void remove(String key);

    <T> T get(String key, Class<T> clazz);
}
