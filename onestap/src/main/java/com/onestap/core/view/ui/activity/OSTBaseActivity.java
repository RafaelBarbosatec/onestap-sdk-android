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


    protected abstract String urlToLoad();

    protected abstract WebViewClient client();

    protected abstract void loadWebView();
}
