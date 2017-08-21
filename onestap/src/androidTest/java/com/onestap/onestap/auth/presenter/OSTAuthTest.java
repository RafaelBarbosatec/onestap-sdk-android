/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth.presenter;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.onestap.onestap.OST;
import com.onestap.onestap.OSTConfiguration;
import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.onestap.core.model.domain.entities.BaseResponse;
import com.onestap.onestap.core.model.domain.enumerator.OSTEnvironment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */
@RunWith(AndroidJUnit4.class)
@MediumTest
public class OSTAuthTest {

    private Context context;

    @Before
    public void setUp() throws Exception {
        context = InstrumentationRegistry.getContext();

        OSTConfiguration config = new OSTConfiguration();
        config.setClientId("5149B5B2-0463-4752-A8A0-C37D639A1FE4");
        config.setClientSecret("FC3E9D34-978B-483B-9CC0-462DFB82A75B");
        config.setFingerPrintID("c470458e-7845-4380-a5db-e7e28548c243");
        config.setSchema("");
        config.setHost("");
        config.setEnvironment(OSTEnvironment.SANDBOX);
        OST.initializer(context, config);

    }

    @Test
    public void requestToken() throws Exception {
        new OSTAuth(context).requestToken("55d62163-cb7b-e711-80c2-0003ff3453b8", new AuthCallback() {
            @Override
            public void success(AuthToken response) {
                Assert.assertNotNull(response);
                Assert.assertNotNull(response.getAccessToken());
                Assert.assertNotNull(response.getRefreshToken());
                Assert.assertNotNull(response.getTokenCreateDate());
                Assert.assertNotNull(response.getUserKey());
            }

            @Override
            public void error(Throwable e) {
                Assert.assertNull(e);
            }
        });
    }

    @Test
    public void refreshToken() throws Exception {
        new OSTAuth(context).refreshToken(new AuthCallback() {
            @Override
            public void success(AuthToken response) {
                Assert.assertNotNull(response);
                Assert.assertNotNull(response.getAccessToken());
                Assert.assertNotNull(response.getRefreshToken());
                Assert.assertNotNull(response.getTokenCreateDate());
                Assert.assertNotNull(response.getUserKey());
            }

            @Override
            public void error(Throwable e) {
                Assert.assertNull(e);
            }
        });
    }

    @Test
    public void verifyToken() throws Exception {
        new OSTAuth(context).verifyToken(new CallbackBoundary() {
            @Override
            public void success(Object response) {
                BaseResponse resp = (BaseResponse) response;
                Assert.assertNotNull(response);
                Assert.assertNotNull(resp.hasSuccess());
            }

            @Override
            public void error(Throwable e) {
                Assert.assertNull(e);
            }
        });
    }

    @Test
    public void revokeToken() throws Exception {
        new OSTAuth(context).revokeToken(new CallbackBoundary() {
            @Override
            public void success(Object response) {
                BaseResponse resp = (BaseResponse) response;
                Assert.assertNotNull(response);
                Assert.assertNotNull(resp.hasSuccess());
            }

            @Override
            public void error(Throwable e) {
                Assert.assertNull(e);
            }
        });
    }

}