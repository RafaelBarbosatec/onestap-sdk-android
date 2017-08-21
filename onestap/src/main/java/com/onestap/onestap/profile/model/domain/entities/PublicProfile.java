/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.profile.model.domain.entities;


import com.google.gson.annotations.SerializedName;
import com.onestap.onestap.core.model.domain.entities.BaseResponse;

public class PublicProfile extends BaseResponse {

    @SerializedName("pictureUrl")
    private String pictureUrl;

    @SerializedName("name")
    private String name;

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "PublicProfileAccount{" +
                        "pictureUrl = '" + pictureUrl + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}