/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.login.presenter.contract;

import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.core.presenter.contract.OSTBaseContract;
import com.onestap.onestap.user.model.domain.entities.TempProfile;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public interface LoginContract {

    interface View extends OSTBaseContract.View {

        void loginWithSuccess(AuthToken token);

        void loginFailed(Throwable t);

        void goToWebView();
    }

    interface Presenter extends OSTBaseContract.Presenter<LoginContract.View> {
        void loadCredentials(String authCode);

        void saveTemporaryProfile(TempProfile tempProfile);
    }
}
