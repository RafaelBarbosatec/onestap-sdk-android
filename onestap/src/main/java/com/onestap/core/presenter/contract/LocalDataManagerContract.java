/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.presenter.contract;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface LocalDataManagerContract {

    void saveData(Object value, String key);

    void remove(String key);

    <T> T getData(String key, Class<T> clazz);
}
