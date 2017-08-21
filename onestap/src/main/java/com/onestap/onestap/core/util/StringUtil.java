/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.util;

/**
 * Created by ltorres on 25/07/2017.
 */

public class StringUtil {
    public static boolean isEmptyOrNull(String text){
        if( text == null || text.isEmpty())
            return true;
        else
            return false;

    }
}
