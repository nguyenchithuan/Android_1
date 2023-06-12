package edu.poly.baitest4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.baitest4.Adapter.XeAdapter;
import edu.poly.baitest4.DAO.XeDao;
import edu.poly.baitest4.DTO.Xe;

public class DanhSachActivity extends AppCompatActivity {
    ListView lvDanhSach;
    XeAdapter adapter;
    XeDao dao;
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
    protected void onResume() { // chuẩn bị hiện gia diện thì được chạy
        super.onResume();
        dao = new XeDao(this);
        list = dao.selectAll();
        adapter = new XeAdapter(list, dao);
        lvDanhSach.setAdapter(adapter);
    }

}