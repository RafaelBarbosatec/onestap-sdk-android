/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.core.view.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.onestap.onestap.R;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Created by JGabrielFreitas on 17/04/17.
 */

public abstract class OSTBaseActivity extends Activity {

    WebView webView;
    ProgressBar connectProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectProgressBar = findViewById(R.id.progress);
    }

    protected abstract String urlToLoad();

    protected abstract WebViewClient client();

    public void loadWebView() {
        webView = findViewById(R.id.web_view_ost);
        webView.setWebViewClient(client());
        webView.loadUrl(urlToLoad());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        CookieManager.getInstance().setAcceptCookie(true);
        if (SDK_INT >= LOLLIPOP)
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
    }


    public void showProgress() {
        connectProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        connectProgressBar.setVisibility(View.GONE);
    }
}
