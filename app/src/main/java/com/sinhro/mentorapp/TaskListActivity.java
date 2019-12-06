package com.sinhro.mentorapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.sinhro.mentorapp.Model.TasksList;

public class TaskListActivity extends AppCompatActivity {
    private ListView listView;
    private LinearLayout titleLinearLayout;
    private void initAllViews(){
        titleLinearLayout = findViewById(R.id.tasks_title_layout);
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

        listView = findViewById(R.id.tasks_listView);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_activity);

        initAllViews();

//        FragmentManager fragmentManager =getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        ExampleFragment fragment = new ExampleFragment();
//        fragmentTransaction.add(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();




        TasksList tasks = getTasks();
        listView.setAdapter(
                new TasksListAdapter(
                        tasks,getApplicationContext()
                )
        );

    }

    private TasksList getTasks(){
        Bundle arguments = getIntent().getExtras();
        TasksList tasksList = null;
        if (arguments!= null)
            tasksList = (TasksList) arguments.getSerializable(TasksList.class.getSimpleName());
        return tasksList;
    }
}
