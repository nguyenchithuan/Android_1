package edu.poly.baitest4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.baitest4.DAO.XeDao;
import edu.poly.baitest4.DTO.Xe;

public class MainActivity extends AppCompatActivity {
    EditText etTenXe;
    XeDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTenXe = findViewById(R.id.etTenXe);
        dao = new XeDao(this);
    }

    public void themOnclick(View view) {
        Xe xe = new Xe();
        xe.setTenXe(etTenXe.getText().toString());
        dao.insert(xe);
        Toast.makeText(this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
    }

    public void danhSachOnclick(View view) {
        Intent intent = new Intent(this, DanhSachActivity.class);
        startActivity(intent);
    }
}