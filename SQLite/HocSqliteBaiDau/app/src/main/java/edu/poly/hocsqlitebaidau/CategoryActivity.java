package edu.poly.hocsqlitebaidau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import edu.poly.hocsqlitebaidau.Adapter.CategoryAdapter;
import edu.poly.hocsqlitebaidau.DAO.CatDAO;
import edu.poly.hocsqlitebaidau.DTO.Cat;

public class CategoryActivity extends AppCompatActivity {
    ListView lv_cat;
    CatDAO dao;
    CategoryAdapter adapter;
    String TAG = "aaaaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        lv_cat = findViewById(R.id.lv_cat);

        // tạo DAO
        dao = new CatDAO(this);

        Cat c = new Cat(3, "hahaa");
        dao.insertRow(c);

        // thử text du lieu
        Log.d(TAG, "onCreate: Số lượng dòng = " + dao.selectAll().size());

        // tạo đối tượng adapter
        adapter = new CategoryAdapter(dao.selectAll());

        // gắn vào listView
        lv_cat.setAdapter(adapter);
    }




}