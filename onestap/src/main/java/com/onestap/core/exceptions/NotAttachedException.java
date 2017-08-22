/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.exceptions;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class NotAttachedException extends RuntimeException {

    public NotAttachedException() {
        super("View not attached");
    }

}
