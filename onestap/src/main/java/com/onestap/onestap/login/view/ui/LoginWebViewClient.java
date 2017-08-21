/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestap.login.view.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

import com.onestap.onestap.OST;
import com.onestap.onestap.core.exceptions.InvalidRedirectThrowable;
import com.onestap.onestap.core.exceptions.InvalidStateThrowable;
import com.onestap.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.onestap.core.view.ui.OSTBaseWebViewClient;

/**
 * Created on 21/08/2017
 *
 * @author Marcos Gribel
 * @email mrebelo@stone.com.br
 */

public class LoginWebViewClient extends OSTBaseWebViewClient {

    private String uuid;
    private AuthCallback authCallback;


    public LoginWebViewClient(String uuid, AuthCallback authCallback) {
        this.uuid = uuid;
        this.authCallback = authCallback;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String redirect = OST.getInstance().getSchema() + "://" + OST.getInstance().getHost();
        if (!url.contains(uuid)) {
            authCallback.error(new InvalidStateThrowable());
            ((Activity) view.getContext()).finish();
            return false;
        }
        if (!url.contains(redirect)) {
            authCallback.error(new InvalidRedirectThrowable());
            ((Activity) view.getContext()).finish();
            return false;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        view.getContext().startActivity(intent);
        ((Activity) view.getContext()).finish();
        return true;
    }
}
