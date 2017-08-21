/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.exceptions;

/**
 * Created by jcosilva on 6/12/2017.
 */

public class InvalidRedirectThrowable extends Throwable {
    public InvalidRedirectThrowable(){
        super("Invalid redirect. Check your schema and host");
    }
}
