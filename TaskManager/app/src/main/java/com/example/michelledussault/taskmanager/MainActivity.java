package com.example.michelledussault.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


// ALT + ENTER for a quick fix to import

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**Button buttonUserSettings;
    Button buttonMyProfile;
    Button buttonTasks; **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**buttonUserSettings = (Button) findViewById(R.id.UserSettingsButton);
        buttonMyProfile = (Button) findViewById(R.id.MyProfileButton);
        buttonTasks = (Button) findViewById(R.id.TasksButton); **/

    }

    public void buttonTasksOnClick(View view) {
        Intent tasksIntent = new Intent(this, TasksActivity.class);
        startActivity(tasksIntent);
    }

    public void buttonMyProfileOnClick(View view) {
        Intent myProfileIntent = new Intent(this, ProfileActivity.class);
        startActivity(myProfileIntent);
    }

    public void buttonUserSettingsOnClick(View view) {
        Intent userSettingsIntent = new Intent(this, UserSettingsActivity.class);
        startActivity(userSettingsIntent);
    }


}
