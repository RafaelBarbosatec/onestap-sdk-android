/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.auth.view.ui.widget;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebViewClient;

import com.onestap.OST;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.auth.presenter.AuthPresenter;
import com.onestap.auth.presenter.contract.AuthContract;
import com.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.core.view.ui.activity.OSTBaseActivity;
import com.onestap.onestap.R;

public class OSTAuthActivity extends OSTBaseActivity implements AuthContract.View {

    public static AuthCallback authCallback;
    private AuthContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ost_auth);

        Uri uri = getIntent().getData();
        presenter = new AuthPresenter(this);
        presenter.attachView(this);
        if (uri != null) {
            showProgress();
            String authCode = uri.getQueryParameter("code");
            presenter.loadCredentials(authCode);
        } else {
            if (OST.getInstance().getConfiguration().getTempProfile() != null) {
                presenter.saveTemporaryProfile(OST.getInstance().getConfiguration().getTempProfile());
            } else {
                loadWebView();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }

    @Override
    protected String urlToLoad() {
        return OST.getInstance().getLoginUrl();
    }

    @Override
    protected WebViewClient client() {
        return null;
    }

    @Override
    public void loadWebView() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(OST.getInstance().getLoginUrl()));
        startActivity(intent);
    }

    @Override
    public void loginWithSuccess(AuthToken token) {
        authCallback.success(token);
        finish();
    }

    @Override
    public void loginFailed(Throwable t) {
        authCallback.error(t);
        finish();
    }

    @Override
    public void goToWebView() {
        loadWebView();
    }
}
