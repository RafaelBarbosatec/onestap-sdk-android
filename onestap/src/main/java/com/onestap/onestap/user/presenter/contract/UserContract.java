/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.user.presenter.contract;

import com.onestap.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.onestap.user.model.domain.entities.PendingProfile;
import com.onestap.onestap.user.model.domain.entities.TempProfile;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface UserContract {

        void savePendingProfile(TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary);

    interface Manager extends UserContract {


    }

    interface UseCase {

        void savePendingProfile(TempProfile body, CallbackBoundary<PendingProfile> callbackBoundary);

    }


}
