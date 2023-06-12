package edu.poly.nguyenchithuanph26023;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.poly.nguyenchithuanph26023.Adapter.SinhVienAdapter;
import edu.poly.nguyenchithuanph26023.DAO.SinhVienDAO;
import edu.poly.nguyenchithuanph26023.DTO.SinhVien;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;

    ArrayList<SinhVien> list;
    SinhVienDAO dao;
    SinhVienAdapter adapter;
    int id = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvDanhSach = findViewById(R.id.lvDanhSach);
        dao = new SinhVienDAO(this);
        list = dao.getAll();
        adapter = new SinhVienAdapter(list);
        lvDanhSach.setAdapter(adapter);


        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long dai) {
                id = list.get(i).getId();
            }
        });

        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                deleteSinhVien();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dao = new SinhVienDAO(this);
        list = dao.getAll();
        adapter = new SinhVienAdapter(list);

        lvDanhSach.setAdapter(adapter);
    }

    public void themOnclick(View view) {
        Intent intent = new Intent(getBaseContext(), SinhVienActivity.class);
        startActivity(intent);
    }

    public void suaOnclick(View view) {
        if(id == -1) {
            return;
        }
        Intent intent = new Intent(getBaseContext(), SinhVienActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        intent.putExtra("data", bundle);
        startActivity(intent);
        id = -1;
    }

    public void deleteSinhVien() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông báo");
        alertDialog.setMessage("Bạn có muốn xóa sinh viên này không!");

        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.delete(dao.getById(id));
                onResume();
            }
        });

        alertDialog.setNegativeButton("Không ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        alertDialog.show();
    }
}