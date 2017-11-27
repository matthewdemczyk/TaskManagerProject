package com.example.michelledussault.taskmanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by michelledussault on 2017-11-25.
 */

public class TaskList extends ArrayAdapter<Task> {
    private Activity context;
    List<Task> tasks;

    public TaskList(Activity context, List<Task> tasks) {
        super(context, R.layout.layout_task_list, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_task_list, null, true);

        TextView textViewTitle = (TextView) listViewItem.findViewById(R.id.textViewTitle);
        TextView textViewDescription = (TextView) listViewItem.findViewById(R.id.textViewDescription);
        TextView textViewDeadline = (TextView) listViewItem.findViewById(R.id.textViewDeadline);
        TextView textViewPoints = (TextView) listViewItem.findViewById(R.id.textViewPoints);

        Task task = tasks.get(position);
        textViewTitle.setText(task.getTitle());
        textViewDescription.setText(task.getDescription());
        textViewDeadline.setText(task.getDeadline());
        textViewPoints.setText(task.getPoints());
        return listViewItem;
    }

}
