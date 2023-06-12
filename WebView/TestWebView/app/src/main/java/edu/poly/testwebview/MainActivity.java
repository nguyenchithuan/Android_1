package edu.poly.testwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView mWebView = findViewById(R.id.mWebview);

        mWebView.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("zzzzzzzzz", "onProgressChanged: " + newProgress); // xem log tiến trình load
                super.onProgressChanged(view, newProgress);
            }
        });

        mWebView.setWebViewClient( new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
// hiển thị lỗi nếu có lỗi xảy ra
                Toast.makeText(activity, error.getDescription() , Toast.LENGTH_SHORT).show();
            }
        });
        mWebView.loadUrl("https://zezo.dev");
    }
}