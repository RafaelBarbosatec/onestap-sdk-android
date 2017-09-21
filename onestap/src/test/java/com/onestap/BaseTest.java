package com.onestap;

import com.onestap.core.exceptions.GlobalException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created on 20/09/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class BaseTest {

    protected MockWebServer mMockWebServer = new MockWebServer();
    protected Retrofit mRetrofit;


    @Before
    public void setUp() throws Exception {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(mMockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @After
    public void tearDown() throws Exception {
            mMockWebServer.shutdown();
    }



}
