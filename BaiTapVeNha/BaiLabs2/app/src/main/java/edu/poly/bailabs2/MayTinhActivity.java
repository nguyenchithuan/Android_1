package edu.poly.bailabs2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MayTinhActivity extends AppCompatActivity {
    EditText ed_soa, ed_sob;
    TextView tv_ketQua, tv_thongTin;
    Button btntong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh); // lấy dữ liệu intent ở sau setContentView

        // lấy dữ liệu từ intent
        // mỗi 1 activity có một intent
        Intent intent = getIntent(); // lấy intent của activity của hiện tại

        Bundle objBundle = intent.getBundleExtra("goiHang"); // lấy ra gói hàng

        // mở gói hàng
        String hoTen = objBundle.getString("chuoiHoTen");
        int tuoi = objBundle.getInt("soTuoi");

        // in thông tin ra textview
        tv_thongTin = findViewById(R.id.tv_thongTin);
        tv_thongTin.setText("Họ tên: " + hoTen + "\nTuổi: " + tuoi);


        // ánh xạ
        ed_soa = findViewById(R.id.ed_soa);
        ed_sob = findViewById(R.id.ed_sob);
        btntong = findViewById(R.id.btnTong);
        tv_ketQua = findViewById(R.id.tv_ketQua);


        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ---- lấy gia trị số nhập vào
                double a = Double.parseDouble(ed_soa.getText().toString());
                double b = Double.parseDouble(ed_sob.getText().toString());
                double tong = a + b;


                // Toast để hiển thị một thanh nhỏ ở dưới
                Toast.makeText(MayTinhActivity.this, "Tổng: " + tong, Toast.LENGTH_SHORT).show();
                tv_ketQua.setText("Tổng: " + tong);
            }
        });
    }
}