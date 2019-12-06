package com.sinhro.mentorapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sinhro.mentorapp.Model.FullTask;

public class FullTaskActivity extends AppCompatActivity {

    private LinearLayout titleLinearLayout;
    private TextView taskTitleTextView,
            taskDescriptionTextView,mentorTextView;

    private void findViews(){
        titleLinearLayout = findViewById(R.id.fullTask_title_layout);
        View titleView = getLayoutInflater().inflate(
                R.layout.tasks_title,titleLinearLayout,false
        );
        LinearLayout home = titleView.findViewById(R.id.tasks_title_leftButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleLinearLayout.addView(titleView);

        mentorTextView = findViewById(R.id.fullTask_body_mentor_textView);
        taskDescriptionTextView= findViewById(R.id.fullTask_body_taskDescription_textView);
        taskTitleTextView= findViewById(R.id.fullTask_body_taskTitle_textView);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_info_activity);

        findViews();

        FullTask task = getCurrentTask();

        taskTitleTextView.setText(task.getTask().getTitle());
        taskDescriptionTextView.setText(task.getDescription());
    }

    private FullTask getCurrentTask(){
        Bundle arguments = getIntent().getExtras();
        FullTask tasksList = null;
        if (arguments!= null)
            tasksList = (FullTask) arguments.getSerializable(FullTask.class.getSimpleName());
        return tasksList;
    }
}
