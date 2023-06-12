package edu.poly.baitest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import edu.poly.baitest1.Adapter.VatTuAdapter;
import edu.poly.baitest1.DAO.VatTuDao;
import edu.poly.baitest1.DTO.VatTu;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    ArrayList<VatTu> list;
    VatTuDao dao;
    VatTuAdapter adapter;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnThem = findViewById(R.id.btnThem);
        lvDanhSach = findViewById(R.id.lvDanhSach);

        dao = new VatTuDao(this);
        list = dao.selectAll();
        adapter = new VatTuAdapter(list, dao);
        lvDanhSach.setAdapter(adapter);

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ThemActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        dao = new VatTuDao(this);
        list = dao.selectAll();
        adapter = new VatTuAdapter(list, dao);
        lvDanhSach.setAdapter(adapter);
        super.onResume();
    }
}