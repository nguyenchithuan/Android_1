package edu.poly.testwebview3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);


        final Activity activity = this;

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

                super.onReceivedError(view, request, error);
                Toast.makeText(activity, "" + error.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

        String hoTen = "Nguyễn Chí Thuận";

        String chuoiHtml = "<H1 style = 'color: blue'>Giới Thiếu</h1>" +
                " <h2 style = 'border: 1px solid red'> Giới thiệu: "  + hoTen +  " <h2>";
        webView.loadData(chuoiHtml,"text/html","utf-8");
    }
}