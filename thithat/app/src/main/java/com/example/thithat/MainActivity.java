package com.example.thithat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView anh;
    Button dangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anh= findViewById(R.id.imgA);
        dangnhap = findViewById(R.id.btndangnhap);

    }
    public void chuyen(View view){
        Intent chuyenmh= new Intent(MainActivity.this,DanhsachActivity.class);
        startActivity(chuyenmh);

    }
}