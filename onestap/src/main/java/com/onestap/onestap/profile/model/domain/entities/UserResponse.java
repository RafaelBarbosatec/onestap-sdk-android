/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.profile.model.domain.entities;


import com.google.gson.annotations.SerializedName;
import com.onestap.onestap.core.model.domain.entities.BaseResponse;

public class UserResponse extends BaseResponse {

    @SerializedName("user")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return
                "UserResponse{" +
                        "operationReport = '" + getOperationReport() + '\'' +
                        ",success = '" + hasSuccess() + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}