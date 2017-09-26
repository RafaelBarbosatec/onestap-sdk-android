package com.onestap.core.util;

import android.os.Build;

import java.util.Locale;


/**
 * Created by germano on 26/09/17.
 */

public class LanguageUtil {
    public static String getLanguageTag(Locale language){
        if(Build.VERSION.SDK_INT <  Build.VERSION_CODES.LOLLIPOP){
            String languageCode = language.toString();
            if(languageCode.contains("_")){
                languageCode.replace("_", "-");
            }
            return languageCode;
        } else {

            return language.toLanguageTag();
        }
    }
}
