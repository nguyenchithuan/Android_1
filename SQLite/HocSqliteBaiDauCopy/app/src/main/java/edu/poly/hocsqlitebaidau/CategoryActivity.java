package edu.poly.hocsqlitebaidau;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.poly.hocsqlitebaidau.Adapter.CategoryAdapter;
import edu.poly.hocsqlitebaidau.DAO.CatDAO;
import edu.poly.hocsqlitebaidau.DTO.Cat;

public class CategoryActivity extends AppCompatActivity {
    ListView lvCat;
    CatDAO dao;
    ArrayList<Cat> list;
    CategoryAdapter adapter;
    String TAG = "aaaaa";

    int catId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        lvCat = findViewById(R.id.lvCat);

        // tạo DAO
        dao = new CatDAO(this);


        Cat c = new Cat(3, "hahaa");
        dao.insertRow(c);

        // thử text du lieu
        Log.d(TAG, "onCreate: Số lượng dòng = " + dao.selectAll().size());


        list  = dao.selectAll();

        // tạo đối tượng adapter
        adapter = new CategoryAdapter(list);

        // gắn vào listView
        lvCat.setAdapter(adapter);


        lvCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Cat c = list.get(i);
                catId  = c.getId();
            }
        });

        lvCat.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                xacDinhXoa(position);
                return false;
            }
        });

    }

    public void xacDinhXoa(int position) {
        AlertDialog.Builder alertDiBuilder = new AlertDialog.Builder(this);
        alertDiBuilder.setTitle("Thông báo");

        alertDiBuilder.setMessage("Bạn có muốn xóa hay không!");

        alertDiBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alertDiBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDiBuilder.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dao = new CatDAO(this);
        list = dao.selectAll();

        adapter = new CategoryAdapter(list);

        lvCat.setAdapter(adapter);
    }

    public void insertOnclick(View view) {
        Intent intent = new Intent(getBaseContext(), SaveActivity.class);
        startActivity(intent);
    }

    public void updateOnclick(View view) {

        if(catId == -1) {
            return;
        }

        Intent intent = new Intent(getBaseContext(), SaveActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", catId);
        intent.putExtra("data", bundle); // giống như đọc đữ liệu
        startActivity(intent);

        catId = -1;
    }
}