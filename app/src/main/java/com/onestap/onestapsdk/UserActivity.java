package com.onestap.onestapsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.user.model.domain.entities.AccountResponse;
import com.onestap.user.presenter.UserPresenter;

public class UserActivity extends AppCompatActivity {

    static final String TAG = UserActivity.class.getName();

    EditText editUser;
    AppCompatButton btnGetUser;


    @Override
    protected void onStart() {
        super.onStart();

        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new UserPresenter(UserActivity.this).getUser(new CallbackBoundary<AccountResponse>() {
                    @Override
                    public void success(AccountResponse response) {
                        editUser.setText(new Gson().toJson(response.getAccount()));
                    }

                    @Override
                    public void error(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        e.printStackTrace();
                    }
                });
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        editUser = (EditText) findViewById(R.id.edit_user_json);
        btnGetUser = (AppCompatButton) findViewById(R.id.btn_get_user);
    }

}
