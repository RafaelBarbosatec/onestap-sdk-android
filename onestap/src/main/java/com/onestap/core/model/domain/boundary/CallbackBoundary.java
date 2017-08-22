/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.model.domain.boundary;

/**
 * Created by JGabrielFreitas on 12/04/17.
 */

public interface CallbackBoundary<T> {

  void success(T response);

  void error(Throwable e);

}
