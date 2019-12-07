package com.sinhro.mentorapp;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.sinhro.mentorapp.Model.FullTask;
import com.sinhro.mentorapp.Model.Task;
import com.sinhro.mentorapp.Model.TasksList;

import java.util.function.Consumer;

public class TasksListAdapter implements ListAdapter {
    private TasksList tasksList;
    private Context context;

    public TasksListAdapter(TasksList tasksList,Context context) {
        this.tasksList = tasksList;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return tasksList.getTasks().size();
    }

    @Override
    public Object getItem(int position) {
        return tasksList.getTasks().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tasks_list_item, null);
        }

        TextView textView = convertView.findViewById(R.id.tasks_list_item_textView);
        textView.setText(tasksList.getTasks().get(position).getTitle());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,FullTaskActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                FullTask fullTask = new FullTask(
                        tasksList.getTasks().get(position),
                        ("task #" + position)
                );
                intent.putExtra(FullTask.class.getSimpleName(),fullTask);

                context.startActivity(intent);
                //context.startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
