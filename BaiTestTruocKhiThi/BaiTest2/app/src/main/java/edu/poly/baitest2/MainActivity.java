package edu.poly.baitest2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.baitest2.Adapter.VatTuAdapter;
import edu.poly.baitest2.DAO.VatTuDao;
import edu.poly.baitest2.DTO.VatTu;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    VatTuAdapter adapter;
    VatTuDao dao;
    ArrayList<VatTu> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvDanhSach = findViewById(R.id.lvDanhSach);
        dao = new VatTuDao(this);
        list = dao.selectAll();
        adapter = new VatTuAdapter(list, dao);
        lvDanhSach.setAdapter(adapter);
    }


    public void themOnclick(View view) {
        Dialog dialog = new Dialog(this, R.style.Theme_BaiTest2);
        dialog.setContentView(R.layout.activity_them);
        EditText etTenVatTu = dialog.findViewById(R.id.etTenVatTu);
        EditText etGiaTien = dialog.findViewById(R.id.etGiaTien);

        Button btnLuu = dialog.findViewById(R.id.btnLuu);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VatTu vatTu = new VatTu();
                vatTu.setTenVatTu(etTenVatTu.getText().toString());
                vatTu.setGiaTien(Double.parseDouble(etGiaTien.getText().toString()));

                dao.insert(vatTu);
                list.add(vatTu);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        dialog.show();
    }
}