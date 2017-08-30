/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.user.presenter.contract;

import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.user.model.domain.entities.AccountResponse;
import com.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.user.model.domain.entities.TempProfile;
import com.onestap.user.model.domain.entities.UserResponse;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface UserContract {



    interface Manager extends UserContract {

        void savePendingProfile(TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary);

        void getUser(AuthToken token, CallbackBoundary<AccountResponse> callbackBoundary);

    }

    interface UseCase extends UserContract {

        void savePendingProfile(TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary);

        void getUser(CallbackBoundary<AccountResponse> callbackBoundary);

    }

    interface Presenter extends UserContract {

        void getUser(CallbackBoundary<AccountResponse> callbackBoundary);
    }

}
