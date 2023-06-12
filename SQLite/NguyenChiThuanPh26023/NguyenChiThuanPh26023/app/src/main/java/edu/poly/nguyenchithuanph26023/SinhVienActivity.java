package edu.poly.nguyenchithuanph26023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.nguyenchithuanph26023.DAO.SinhVienDAO;
import edu.poly.nguyenchithuanph26023.DTO.SinhVien;

public class SinhVienActivity extends AppCompatActivity {
    EditText etTen, etSdt, etGhiChu;
    SinhVienDAO dao;
    Button btnLuu;
    int bienId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);
        etTen = findViewById(R.id.etTen);
        etSdt = findViewById(R.id.etSdt);
        etGhiChu = findViewById(R.id.etGhiChu);
        btnLuu = findViewById(R.id.btnLuu);
        writeForm();
    }

    public void writeForm() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle == null) {
            return;
        }
        dao = new SinhVienDAO(this);
        bienId = bundle.getInt("id");
        SinhVien sv = dao.getById(bienId);
        etTen.setText(sv.getHoTen());
        etSdt.setText(sv.getSodt());
        etGhiChu.setText(sv.getGhiChu());



        btnLuu.setText("Sửa");
    }

    public void luuOnclick(View view) {
        dao = new SinhVienDAO(this);
        SinhVien sv = new SinhVien();
        sv.setId(bienId);
        sv.setHoTen(etTen.getText().toString());
        sv.setSodt(etSdt.getText().toString());
        sv.setGhiChu(etGhiChu.getText().toString());
        if(btnLuu.getText().toString().equalsIgnoreCase("Lưu")) {
            dao.insert(sv);
            Toast.makeText(this, "Bạn thêm một sinh viên", Toast.LENGTH_SHORT).show();
        } else {
            dao.update(sv);
            Toast.makeText(this, "Bạn đã sửa một sinh viên", Toast.LENGTH_SHORT).show();
        }
    }


}