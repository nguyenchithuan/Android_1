package edu.poly.baitestamsignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void danhSachLopOnclick(View view) {
        Intent intent = new Intent(this, DanhSachLopActivity.class);
        startActivity(intent);
    }

    public void danhSachSvOnclick(View view) {

    }
}