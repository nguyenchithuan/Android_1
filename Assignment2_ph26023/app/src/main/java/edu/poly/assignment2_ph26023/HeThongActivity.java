package edu.poly.assignment2_ph26023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

public class HeThongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //Ẩn tên ứng dụng
        getSupportActionBar().hide(); // Ẩn luôn thanh tiêu đề

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //bật chế độ toàn màn hình

        setContentView(R.layout.activity_he_thong);
    }


    public void danhSachLopOnclick(View view) {
        Intent intent = new Intent(getBaseContext(), DanhSachLopActivity.class);
        startActivity(intent);
    }

    public void danhSachSVOnlick(View view) {
        Intent intent = new Intent(getBaseContext(), DanhSachSvActivity.class);
        startActivity(intent);
    }

    public void gioiThieuOnlick(View view) {
        Intent intent = new Intent(getBaseContext(), WebViewActivity.class);
        startActivity(intent);
    }
}