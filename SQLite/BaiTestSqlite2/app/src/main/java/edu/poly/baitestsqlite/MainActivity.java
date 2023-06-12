package edu.poly.baitestsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.poly.baitestsqlite.DAO.CatDAO;

public class MainActivity extends AppCompatActivity {
    String TAG = "aaa";
    Button btn_danhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_danhSach = findViewById(R.id.btn_danhSach);

        btn_danhSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CatActivity.class);
                startActivity(intent);
            }
        });


    }
}