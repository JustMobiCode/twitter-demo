package com.demo.twittertest;

import android.os.Bundle;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    WebView webView;
    String url = "https://twitter.com/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(url);
    }


    @Override
    protected void onResume() {
        super.onResume();

        CookieManager cookieManager = CookieManager.getInstance();
        // Retrieve the cookies for the specified URL
        String cookies = cookieManager.getCookie(url);

        Log.e(TAG, "cookies: " + cookies);
    }
}