package edu.poly.baitest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import edu.poly.baitest3.Adapter.XeAdapter;
import edu.poly.baitest3.DAO.XeDao;
import edu.poly.baitest3.DTO.Xe;

public class DanhSachActivity extends AppCompatActivity {
    ListView lvDanhSach;
    XeDao dao;
    XeAdapter adapter;
    ArrayList<Xe> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);

        lvDanhSach = findViewById(R.id.lvDanhSach);
        dao = new XeDao(this);
        list = dao.selectAll();
        adapter = new XeAdapter(list, dao);
        lvDanhSach.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dao = new XeDao(this);
        list = dao.selectAll();
        adapter = new XeAdapter(list, dao);
        lvDanhSach.setAdapter(adapter);
    }
}