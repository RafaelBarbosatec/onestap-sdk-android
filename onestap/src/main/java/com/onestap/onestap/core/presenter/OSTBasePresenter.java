/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.core.presenter;

import com.onestap.onestap.core.exceptions.NotAttachedException;
import com.onestap.onestap.core.presenter.contract.OSTBaseContract;

/**
 * Created by jcosilva on 6/9/2017.
 */

public class OSTBasePresenter<T extends OSTBaseContract.View> implements OSTBaseContract.Presenter<T> {

    private T view;

    @Override
    public void attachView(T baseViewContract) {
        view = baseViewContract;
    }

    @Override
    public void detach() {
        view = null;
    }


    public T getView() {
        if (view == null) {
            throw new NotAttachedException();
        }
        return view;
    }
}
