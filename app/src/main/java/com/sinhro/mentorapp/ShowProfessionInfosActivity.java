package com.sinhro.mentorapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ShowProfessionInfosActivity extends AppCompatActivity {
    private LinearLayout titleLinearLayout;
    public ShowProfessionInfosActivity() {
    }

    private void findElems(){
        professionInfos_listView = findViewById(R.id.professionInfos_listView);
        titleLinearLayout = findViewById(R.id.professionInfos_title_layout);
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
    }
    private ListView professionInfos_listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profession_infos_activity);

        professionInfos_listView.setAdapter();


    }
}
