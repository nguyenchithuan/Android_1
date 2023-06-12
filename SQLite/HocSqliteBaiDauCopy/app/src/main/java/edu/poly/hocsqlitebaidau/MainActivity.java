package edu.poly.hocsqlitebaidau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import edu.poly.hocsqlitebaidau.DAO.CatDAO;
import edu.poly.hocsqlitebaidau.DTO.Cat;

public class MainActivity extends AppCompatActivity {
    String TAG = "zzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnCat = findViewById(R.id.btnCat);

        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), CategoryActivity.class);
                startActivity(i);
            }
        });
    }
}