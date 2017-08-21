/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestapsdk;

import android.app.Application;

import com.onestap.onestap.OST;
import com.onestap.onestap.OSTConfiguration;
import com.onestap.onestap.core.model.domain.enumerator.OSTEnvironment;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        OSTConfiguration config = new OSTConfiguration();
        config.setClientId("432B08E5-ACDA-4AD0-976F-CC5C323B2A1D");
        config.setClientSecret("FC3E9D34-978B-483B-9CC0-462DFB82A75B");
        config.setHost("onestap");
        config.setSchema("onestap");
        config.setFingerPrintID("c470458e-7845-4380-a5db-e7e28548c243");

        config.setEnvironment(OSTEnvironment.SANDBOX);

//        config.setTempProfile(feedTempProfile()); // READ THE DOCUMENTATION

        OST.initializer(App.this, config);
    }
}
