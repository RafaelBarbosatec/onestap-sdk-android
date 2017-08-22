/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.model.domain.entities;


import com.onestap.core.model.domain.entities.BaseResponse;

/**
 * Created by ltorres on 28/07/2017.
 */

public class PendingProfile extends BaseResponse {
    private String dataKey;

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }
}
