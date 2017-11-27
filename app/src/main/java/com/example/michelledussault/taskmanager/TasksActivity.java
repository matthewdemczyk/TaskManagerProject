package com.example.michelledussault.taskmanager;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends AppCompatActivity {

    Button buttonAddTask;
    EditText title1;
    EditText description1;
    EditText deadline1;
    EditText points1;
    List<Task> tasks;
    ListView listViewTasks;
    DatabaseReference databaseTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        title1 = (EditText) findViewById(R.id.editTextTitle);
        description1 = (EditText) findViewById(R.id.editTextDescription);
        deadline1 = (EditText) findViewById(R.id.editTextDeadline);
        points1 = (EditText) findViewById(R.id.editTextPoints);
        listViewTasks = (ListView) findViewById(R.id.TaskListview);
        buttonAddTask = (Button) findViewById(R.id.AddTaskbutton);

        tasks = new ArrayList<>();


        databaseTasks = FirebaseDatabase.getInstance().getReference("tasks");

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });

        listViewTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Task task = tasks.get(i);
                showUpdateDeleteDialog(task.getId(), task.getTitle());
                return true;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        // attaching value event listener
        databaseTasks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // clearing the previous task list

                tasks.clear();

                //iterating through all the nodes

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    //getting task
                    Task task = postSnapshot.getValue(Task.class);
                    //adding product to list
                    tasks.add(task);
                }
                //creating adapter, puts items from array into the listView (adapt from array to listView)
                TaskList tasksAdapter = new TaskList(TasksActivity.this, tasks);
                //attaching adapter to the listview
                listViewTasks.setAdapter(tasksAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });
    }


    private void showUpdateDeleteDialog(final String taskId, String taskTitle) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextTitle = (EditText) dialogView.findViewById(R.id.title);
        final EditText editTextDescription  = (EditText) dialogView.findViewById(R.id.description);
        final EditText editTextDeadline  = (EditText) dialogView.findViewById(R.id.deadline);
        final EditText editTextPoints  = (EditText) dialogView.findViewById(R.id.points);

        final Button buttonUpdate = (Button) dialogView.findViewById(R.id.updateButton);
        final Button buttonDelete = (Button) dialogView.findViewById(R.id.deleteButton);
        //final Button buttonSelect = (Button) dialogView.findViewById(R.id.selectButton);

        dialogBuilder.setTitle(taskTitle);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString().trim();
                String description = editTextDescription.getText().toString();
                String deadline = editTextDeadline.getText().toString();
                String points = editTextPoints.getText().toString();

                if (!TextUtils.isEmpty(title) &&  !TextUtils.isEmpty(description) && !TextUtils.isEmpty(deadline) && !TextUtils.isEmpty(points)) {
                    updateTask(taskId, title, description, deadline, points);
                    b.dismiss();
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTask(taskId);
                b.dismiss();
            }
        });
    }

    private void updateTask(String id, String title, String description, String deadline, String points) {
        //getting the specified product reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("tasks").child(id);

        // updating product
        Task newTask = new Task(id, title, description, deadline, TaskStatus.UNASSIGNED, points);
        dR.setValue(newTask);

        Toast.makeText(getApplicationContext(), "Task Updated", Toast.LENGTH_LONG).show();

    }

    private boolean deleteTask(String id) {

        // getting the specified product reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("tasks").child(id);
        //removing product
        dR.removeValue();

        Toast.makeText(getApplicationContext(), "Product deleted", Toast.LENGTH_LONG).show();
        return true;
    }


  public void addTask(){

      String title = title1.getText().toString().trim();
      String description = description1.getText().toString().trim();
      String deadline = deadline1.getText().toString().trim();
      String points = points1.getText().toString().trim();

      if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description) || TextUtils.isEmpty(deadline) || TextUtils.isEmpty(points)){

          Toast.makeText(this, "Please enter values in all fields", Toast.LENGTH_LONG).show();
      } else{

          String id = databaseTasks.push().getKey();
          Task task = new Task(id, title, description, deadline, TaskStatus.UNASSIGNED, points);

          //saving the product
          databaseTasks.child(id).setValue(task);

          // setting editText to blank again
          title1.setText("");
          description1.setText("");
          deadline1.setText("");
          points1.setText("");

          // display success
          Toast.makeText(this, "Task successfully added!", Toast.LENGTH_LONG).show();

      }
  }


}
