package edu.poly.baitest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.poly.baitest3.DAO.XeDao;
import edu.poly.baitest3.DTO.Xe;

public class MainActivity extends AppCompatActivity {
    EditText edTenXe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTenXe = findViewById(R.id.etTenXe);
    }

    public void themOnclick(View view) {
        Xe xe = new Xe();
        xe.setTenXe(edTenXe.getText().toString());
        XeDao dao = new XeDao(this);
        dao.insert(xe);
        Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
    }

    public void danhSachOnclick(View view) {
        Intent intent = new Intent(this, DanhSachActivity.class);
        startActivity(intent);
    }
}