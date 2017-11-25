package com.example.michelledussault.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
    }

    public void buttonCreateUserOnClick(View view){

        Intent createUserIntent = new Intent(this, CreateUserActivity.class);
        startActivity(createUserIntent);
    }

}
