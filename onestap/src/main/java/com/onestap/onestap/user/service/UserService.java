/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.user.service;

import com.onestap.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.onestap.user.model.domain.entities.TempProfile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface UserService {


    @POST("/user/temporaryProfile")
    Call<PendingProfile> saveTempProfile(@Body TempProfile body);

}
