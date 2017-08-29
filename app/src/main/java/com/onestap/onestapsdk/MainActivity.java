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
import com.onestap.core.view.ui.widget.OSTButton;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getName();


    @Override
    protected void onStart() {
        super.onStart();
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
    }
}
