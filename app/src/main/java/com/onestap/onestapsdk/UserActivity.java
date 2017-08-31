package com.onestap.onestapsdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.onestap.core.model.domain.boundary.CallbackBoundary;
import com.onestap.core.model.domain.enumerator.CategoryEnum;
import com.onestap.core.view.ui.widget.OSTButton;
import com.onestap.user.OSTUser;
import com.onestap.user.model.domain.entities.AccountResponse;

public class UserActivity extends AppCompatActivity {

    static final String TAG = UserActivity.class.getName();

    EditText editUser;
    OSTButton btnGetUser;


    @Override
    protected void onStart() {
        super.onStart();

        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] categories = {
                        CategoryEnum.DOCUMENTS.name(),
                        CategoryEnum.ADDRESSES.name(),
                        CategoryEnum.EMAILS.name(),
                        CategoryEnum.PERSONALDATA.name(),
                        CategoryEnum.PHONES.name(),
                        CategoryEnum.VEHICLES.name()
                };

                new OSTUser(UserActivity.this).getUser(new CallbackBoundary<AccountResponse>() {
                    @Override
                    public void success(AccountResponse response) {
                        String json = new Gson().toJson(response.getAccount());
                        editUser.setText(json);

                        Log.i(TAG, json);
                    }

                    @Override
                    public void error(Throwable e) {
                        Log.e(TAG, e.getMessage());
                        e.printStackTrace();
                    }
                }, categories);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        editUser = (EditText) findViewById(R.id.edit_user_json);
        btnGetUser = (OSTButton) findViewById(R.id.btn_get_user);
    }

}
