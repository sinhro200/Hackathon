package com.sinhro.mentorapp.API;

import android.os.Build;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AsyncTask extends android.os.AsyncTask<URL,Void,StringBuilder> {


    @Override
    protected StringBuilder doInBackground(URL... urls) {
        StringBuilder result=new StringBuilder();
        URL url = urls[0];
        try (InputStream is = url.openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                reader.lines().forEach(result::append);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
