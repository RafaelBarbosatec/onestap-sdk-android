/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Set;

public class SharedPreferenceHelper {

    private SharedPreferences mPreferences;
    private Editor mEditor;


    public SharedPreferenceHelper(Context context) {
        if (context != null) {
            this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
            this.mEditor = mPreferences.edit();
        }
    }

    public void writeData(String key, String value) {
        this.mEditor.putString(key, value);
        this.save();
    }

    public void writeData(String key, int value) {
        this.mEditor.putInt(key, value);
        this.save();
    }

    public void writeData(String key, boolean value) {
        this.mEditor.putBoolean(key, value);
        this.save();
    }

    public void writeData(String key, long value) {
        this.mEditor.putLong(key, value);
        this.save();
    }


    public String readStringData(String key) {
        Object defaultValue = null;
        return this.mPreferences.getString(key, (String)defaultValue);
    }

    public int readIntData(String key) {
        byte defaultValue = 0;
        return this.mPreferences.getInt(key, defaultValue);
    }

    public Set<String> readSetOfTypeStringData(String key) {
        Object defaultValue = null;
        return this.mPreferences.getStringSet(key, (Set)defaultValue);
    }

    public boolean readBooleanData(String key) {
        boolean defaultValue = false;
        return this.mPreferences.getBoolean(key, defaultValue);
    }

    public long readLong(String key) {
        long defaultValue = 0L;
        return this.mPreferences.getLong(key, defaultValue);
    }

    public float readFloat(String key) {
        float defaultValue = 0.0F;
        return this.mPreferences.getFloat(key, defaultValue);
    }

    public double readDouble(String key) {
        long defaultValue = 0L;
        return Double.longBitsToDouble(this.mPreferences.getLong(key, Double.doubleToLongBits((double)defaultValue)));
    }


    public void remove(String key) {
        this.mEditor.remove(key);
        this.save();
    }


    private void save() {
        if(Build.VERSION.SDK_INT < 9) {
            this.mEditor.commit();
        } else {
            this.mEditor.apply();
        }

    }

}
