package com.sinhro.mentorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sinhro.mentorapp.API.MyRequestService;
import com.sinhro.mentorapp.API.VkApi;
import com.sinhro.mentorapp.Model.EventsList;
import com.sinhro.mentorapp.Model.FullEvent;
import com.sinhro.mentorapp.Model.ProfessionInfo;
import com.sinhro.mentorapp.Model.ProfessionsList;
import com.sinhro.mentorapp.Utils.MyLogger;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    LinearLayout loginLayout;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


        loginButton = findViewById(R.id.login_button);
        loginLayout = findViewById(R.id.login_layout);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                playWebView();
                MyRequestService.test(getApplicationContext());
                System.out.println("\n_____");
                System.out.println(MyLogger.getInstance().getLogs());
                System.out.println("\n_____");

//                moveToTasks();
                    moveToProfessions();


            }
        });
    }

    private void moveToProfessions(){
        Intent intent = new Intent(LoginActivity.this, ShowProfessionsActivity.class);
        List<ProfessionInfo> professions = new LinkedList<>();

        professions.add(new ProfessionInfo("prof1",0.2));
        professions.add(new ProfessionInfo("prof2",0.3));
        professions.add(new ProfessionInfo("prof3",0.4));
        professions.add(new ProfessionInfo("prof4",0.1));
        ProfessionsList profs = new ProfessionsList(professions);

        intent.putExtra(ProfessionsList.class.getSimpleName(),profs);

        startActivity(intent);

    }

    private void moveToTasks(){
        Intent intent = new Intent(LoginActivity.this, ShowEventsListActivity.class);
        List<FullEvent> eventsList = new LinkedList<>();

        eventsList.add(new FullEvent("111","222","12:12","com1",1.1,2.2));
        eventsList.add(new FullEvent("100","566","00:12","com1",13.1,266.2));
        eventsList.add(new FullEvent("122","212","23:45","com1",13.31,25.2));
        EventsList tasks = new EventsList(eventsList);

        intent.putExtra(EventsList.class.getSimpleName(),tasks);

        startActivity(intent);

    }

    private void playWebView(){
        VkApi vkApi= null;
        try {
            vkApi = new VkApi("7234771","1d6af65c1d6af65c1d6af65ce91d04928f11d6a1d6af65c4082309c5689a6e6e87c2870");
            String auth = vkApi.auth("7234771");

            WebView webview = findViewById(R.id.login_webView);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.setWebViewClient(new WebViewClient());
            webview.loadUrl(auth);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
