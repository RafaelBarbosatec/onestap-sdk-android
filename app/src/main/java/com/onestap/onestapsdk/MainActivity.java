package com.onestap.onestapsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.onestap.auth.OSTAuth;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.auth.view.ui.widget.OSTAuthButton;
import com.onestap.core.model.domain.boundary.AuthCallback;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getName();

    OSTAuthButton mOSTAuthButton;
    AppCompatButton mBtnAuthPage;


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

        mBtnAuthPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new OSTAuth(MainActivity.this).loadAuthPage();
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
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        mOSTAuthButton = (OSTAuthButton) findViewById(R.id.btn_auth);
        mBtnAuthPage = (AppCompatButton) findViewById(R.id.btn_auth_page);
    }
}
