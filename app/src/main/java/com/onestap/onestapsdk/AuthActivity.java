/*
 * Copyright (c) Stone - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package com.onestap.onestapsdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.onestap.OST;
import com.onestap.auth.OSTAuth;
import com.onestap.auth.model.domain.entities.AuthToken;
import com.onestap.core.model.domain.boundary.AuthCallback;
import com.onestap.core.model.domain.boundary.CallbackBoundary;

public class AuthActivity extends AppCompatActivity {

    static final String TAG = AuthActivity.class.getName();

    EditText editAuthToken;
    AppCompatButton btnVerify;
    AppCompatButton btnRefresh;
    AppCompatButton btnRevoke;
    AppCompatButton btnUser;



    @Override
    protected void onStart() {
        super.onStart();

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new OSTAuth(AuthActivity.this).verifyToken(new AuthCallback() {
                    @Override
                    public void success(AuthToken response) {
                        Toast.makeText(AuthActivity.this, "Verified successed!", Toast.LENGTH_SHORT).show();
                        setTextViewAuthToken(response);
                    }

                    @Override
                    public void error(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        e.printStackTrace();
                    }
                });
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new OSTAuth(AuthActivity.this).refreshToken(new AuthCallback() {
                    @Override
                    public void success(AuthToken response) {
                        Toast.makeText(AuthActivity.this, "Refresh successed!", Toast.LENGTH_SHORT).show();
                        setTextViewAuthToken(response);
                    }

                    @Override
                    public void error(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        e.printStackTrace();
                    }
                });
            }
        });

        btnRevoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new OSTAuth(AuthActivity.this).revokeToken(new CallbackBoundary() {
                    @Override
                    public void success(Object response) {
                        Toast.makeText(AuthActivity.this, "Revoke successed!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AuthActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void error(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        e.printStackTrace();
                    }
                });
            }

        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        editAuthToken = (EditText) findViewById(R.id.txt_auth_token);
        btnVerify = (AppCompatButton) findViewById(R.id.btn_verify_token);
        btnRefresh = (AppCompatButton) findViewById(R.id.btn_refresh_token);
        btnRevoke = (AppCompatButton) findViewById(R.id.btn_revoke_token);
        btnUser = (AppCompatButton) findViewById(R.id.btn_user);
        setTextViewAuthToken(OST.getInstance().getToken());
    }


    private void setTextViewAuthToken(AuthToken token){
        editAuthToken.setText(new Gson().toJson(token));
    }


}
