package com.example.michelledussault.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
    }

    public void buttonAddTask(View view){
        Intent createTaskIntent = new Intent(this, CreateTaskActivity.class);
        startActivity(createTaskIntent);
    }
}
