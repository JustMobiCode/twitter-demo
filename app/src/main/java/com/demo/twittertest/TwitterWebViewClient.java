package com.demo.twittertest;

//public class TwitterWebViewClient {
//}
//
//
//import android.webkit.WebResourceResponse;
//        import android.webkit.WebView;
//        import android.webkit.WebViewClient;
//        import android.webkit.WebResourceRequest;

import android.os.Build;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

public class TwitterWebViewClient extends WebViewClient {
    public static final String TAG = "TwitterWebViewClient";
    private String cookie;
    private String csrfToken;

//    @Override
//    public WebResourceResponse shouldInterceptResponse(WebView view, WebResourceRequest request, WebResourceResponse response) {
//        String url = request.getUrl().toString();
//
//        // Check if it's the Twitter login response
//        if (url.contains("https://twitter.com/sessions")) {
//            // Extract the cookie value
//            cookie = response.getResponseHeaders().get("Set-Cookie");
//            csrfToken = response.getResponseHeaders().get("X-Csrf-Token");
//
//            // Extract the X-Csrf-Token value
//
//        }
//
//        return super.shouldInterceptResponse(view, request, response);
//    }


    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();
        WebResourceResponse response = super.shouldInterceptRequest(view, request);

        Log.e(TAG, "shouldInterceptRequest: " +  response);

        // load native js
        if (url.contains("https://twitter.com/sessions")) {

            // Check if it's the Twitter login response
            if (url.contains("https://twitter.com/sessions")) {
                // Extract the cookie value
                cookie = response.getResponseHeaders().get("Set-Cookie");
                csrfToken = response.getResponseHeaders().get("X-Csrf-Token");

                // Extract the X-Csrf-Token value

            }

//            response = new WebResourceResponse(
//                    "text/javascript",
//                    "utf-8",
//                    loadJsInputStream(url, JsCache.getJsFilePath(path) /* InputStream */));
        }


        Log.d(TAG, "shouldInterceptRequest: " + response);

        return response;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        // Handle the form submission or redirect manually
        view.loadUrl(request.getUrl().toString());
        return true;
    }



    public String getCookie() {
        return cookie;
    }

    public String getCsrfToken() {
        return csrfToken;
    }
}
