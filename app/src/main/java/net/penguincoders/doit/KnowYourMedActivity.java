package net.penguincoders.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class KnowYourMedActivity extends AppCompatActivity {

    private WebView webView2;
    private ProgressBar progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_your_med);
        progressBar1=findViewById(R.id.progressMed);

        Intent intent = getIntent();
        if (null != intent) {
            String url= intent.getStringExtra("url");
            webView2 = findViewById(R.id.webView2);
            webView2.loadUrl(url);
            webView2.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    progressBar1.setVisibility(View.VISIBLE);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    progressBar1.setVisibility(View.GONE);
                }
            });
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