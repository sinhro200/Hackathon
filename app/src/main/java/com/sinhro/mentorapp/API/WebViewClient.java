package com.sinhro.mentorapp.API;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;

public class WebViewClient extends android.webkit.WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        System.out.println(request.getUrl().toString());
        view.loadUrl(request.getUrl().toString());
      return true;
    }


}
