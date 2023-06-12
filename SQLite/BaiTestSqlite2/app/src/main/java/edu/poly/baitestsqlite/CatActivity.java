package edu.poly.baitestsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import edu.poly.baitestsqlite.Adapter.CatAdapter;
import edu.poly.baitestsqlite.DAO.CatDAO;
import edu.poly.baitestsqlite.DTO.Cat;

public class CatActivity extends AppCompatActivity {
    CatAdapter adapter;
    ListView lv_danhSach;
    String TAG = "aaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        lv_danhSach = findViewById(R.id.lv_danhSach);

        CatDAO catDAO = new CatDAO(this);


        Cat cat = new Cat();

        cat = catDAO.selectOne(2);

        catDAO.insertRow(cat);


        adapter = new CatAdapter(catDAO.selectAll());
        lv_danhSach.setAdapter(adapter);
    }
}