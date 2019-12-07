package com.sinhro.mentorapp.API;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sinhro.mentorapp.Utils.MyLogger;

public class MyRequestService {

    public static void test(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://www.google.com";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        MyLogger.getInstance().log("response is :" + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                MyLogger.getInstance().log("error response");
            }
        });

        queue.add(stringRequest);
        queue.start();
    }
}
