/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.model.domain.entities;

import com.google.gson.annotations.SerializedName;
import com.onestap.core.model.domain.entities.BaseResponse;

/**
 * Created on 28/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class AccountResponse extends BaseResponse {


    @SerializedName("account")
    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
