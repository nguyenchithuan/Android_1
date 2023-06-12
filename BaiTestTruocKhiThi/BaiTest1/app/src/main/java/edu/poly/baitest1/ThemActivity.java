package edu.poly.baitest1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.baitest1.DAO.VatTuDao;
import edu.poly.baitest1.DTO.VatTu;

public class ThemActivity extends AppCompatActivity {
    EditText etTenVatTu, etGiaTien;
    Button btnLuu;
    VatTuDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);

        etTenVatTu = findViewById(R.id.etTenVatTu);
        etGiaTien = findViewById(R.id.etGiaTien);
        btnLuu = findViewById(R.id.btnLuu);
        dao = new VatTuDao(this);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatTu vatTu = new VatTu();
                vatTu.setTenVatTu(etTenVatTu.getText().toString());
                vatTu.setGiaTien(Double.parseDouble(etGiaTien.getText().toString()));
                dao.insert(vatTu);
                Toast.makeText(ThemActivity.this, "Them thanh cong!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}