package edu.poly.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    String name, email, phone, gioiThieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getBaseContext(), DangKyActivity.class);
        startActivity(intent);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);

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
                Toast.makeText(MainActivity.this, "" + error.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void dulieuWevView() {
        String chuoiHtml = "<h1 style='color:red'> Thông Tin Giới Thiêu </h1>" +
                "<span>Họ tên: </span>" + "<span style='color:blue'> " + name + "</span>" + "<br>" + "<br>" +
                "<span>Email: </span>" + "<span style='color:orange'> " + email + "</span>"+ "<br>" + "<br>" +
                "<span>Điện thoại: </span>" + "<span style='color:red'> " + phone + "</span>" + "<br>" + "<br>" +
                "<span>Giới thiệu: </span>" + "<span> " + gioiThieu + "</span>";

        webView.loadData(chuoiHtml, "text/html", "utf-8");
    }

    @Override
    protected void onResume() {
        super.onResume();

        nhapDuLieu();
        dulieuWevView();
    }

    public void nhapDuLieu() {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);

        name = pref.getString("name", null);
        email = pref.getString("email", null);
        phone = pref.getString("phone", null);
        gioiThieu = pref.getString("gioiThieu", null);
    }

}