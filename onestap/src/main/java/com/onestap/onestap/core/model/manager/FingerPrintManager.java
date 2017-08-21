/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.model.manager;

import android.content.Context;

import com.onestap.onestap.OST;
import com.onestap.onestap.auth.model.domain.entities.AuthToken;

import br.com.rexlab.fplib.FingerPrintLibrary;

/**
 * Created by ltorres on 24/07/2017.
 */

public class FingerPrintManager {
    public static void sendFingerPrint(Context context, AuthToken token) {
        //region Fingerprint
        FingerPrintLibrary.initFingerprint(
                context,
                OST.getInstance().getEnvironment().name(),
                OST.getInstance().getFingerPrintID(),
                token.getUserKey(),
                OST.getInstance().getFingerPrintSessionId());

        FingerPrintLibrary.configFingerprint(true, true, true, true, true, true);
        FingerPrintLibrary.getFingerprint();
        //endregion
    }
}
