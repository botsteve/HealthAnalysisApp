package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WebView webView = null;
    private TextView textView;
    private Button button;
    private String API_ENDPOINT = "192.168.43.103:4200";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        textView = (TextView) findViewById(R.id.editText2);
//        button = (Button) findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                applyTexts(textView.getText().toString());
//            }
//        });


        webView = new WebView(this);
        setContentView(webView);
//        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);
        webView.loadUrl("http://" + API_ENDPOINT);
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        }


    }



    public void applyTexts(String input) {
        API_ENDPOINT = input;
        System.out.println(API_ENDPOINT);
        webView.loadUrl("http://" + API_ENDPOINT);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
        System.out.println("Saved state--------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }
}
