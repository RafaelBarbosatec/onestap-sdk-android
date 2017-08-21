/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.auth.service;

import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created on 18/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface AuthService {

    @POST("/api/oauth/token")
    Call<AuthToken> request(@QueryMap Map<String, String> options);

}
