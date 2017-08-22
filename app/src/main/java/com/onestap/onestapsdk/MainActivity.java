package com.onestap.onestapsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.onestap.onestap.auth.OSTAuth;
import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.auth.view.ui.widget.OSTAuthButton;
import com.onestap.onestap.core.model.domain.boundary.AuthCallback;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getName();

    OSTAuthButton mOSTAuthButton;

    @Override
    protected void onStart() {
        super.onStart();

        mOSTAuthButton.setAuthCallback(new AuthCallback() {
            @Override
            public void success(AuthToken response) {
                if (response.hasSuccess()) {
                    startActivity(new Intent(MainActivity.this, AuthActivity.class));
                    finish();
                }
            }

            @Override
            public void error(Throwable e) {
                Log.e(TAG, e.getMessage());
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new OSTAuth(this).verifyToken(new AuthCallback() {
            @Override
            public void success(AuthToken response) {
                if (response.hasSuccess()) {
                    startActivity(new Intent(MainActivity.this, AuthActivity.class));
                    finish();
                }
            }

            @Override
            public void error(Throwable e) {
                Log.e(TAG, e.getMessage());
                e.printStackTrace();
            }
        });

        mOSTAuthButton = (OSTAuthButton) findViewById(R.id.btn_auth);
    }
}
