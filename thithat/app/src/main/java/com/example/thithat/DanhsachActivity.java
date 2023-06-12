package com.example.thithat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.thithat.Adapter.DanhsachAdapter;
import com.example.thithat.Adapter.Danhsanh;
import com.example.thithat.SQL.DanhsachDao;

import java.util.ArrayList;

public class DanhsachActivity extends AppCompatActivity {
     private ListView lvlits;
    ArrayList<Danhsanh> arrayList;
    DanhsachDao dao;
    DanhsachAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach);
        lvlits = findViewById(R.id.lvlist);
        dao = new DanhsachDao(DanhsachActivity.this);
        arrayList = dao.getAll();
        adapter = new DanhsachAdapter(this,arrayList);
        lvlits.setAdapter(adapter);


        lvlits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder hopthoai= new AlertDialog.Builder(DanhsachActivity.this);
                hopthoai.setMessage("Ban co muon xoa hay khong");

                hopthoai.setPositiveButton("co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.xoa(arrayList.get(position));
                        arrayList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                hopthoai.show();
            }
        });


        lvlits.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getBaseContext(), Man3Activity.class);
                startActivity(intent);
                return false;
            }
        });
    }



}