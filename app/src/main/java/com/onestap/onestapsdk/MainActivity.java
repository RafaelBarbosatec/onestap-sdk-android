package com.onestap.onestapsdk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onestap.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.onestap.auth.presenter.OSTAuth;
import com.onestap.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.onestap.core.view.ui.widget.OSTAuthButton;

public class MainActivity extends AppCompatActivity {

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
                e.printStackTrace();
            }
        });

        mOSTAuthButton = (OSTAuthButton) findViewById(R.id.btn_auth);
    }
}
