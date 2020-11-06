package net.penguincoders.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class KnowYourMedActivity extends AppCompatActivity {

    private WebView webView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_your_med);

        Intent intent = getIntent();
        if (null != intent) {
            String url= intent.getStringExtra("url");
            webView2 = findViewById(R.id.webView2);
            webView2.loadUrl(url);
            webView2.setWebViewClient(new WebViewClient());
            webView2.getSettings().setJavaScriptEnabled(true);
        }
    }
    @Override
    public void onBackPressed() {
        if (webView2.canGoBack()) {
            webView2.goBack();
        }else {
            super.onBackPressed();
        }
    }
}