package edu.poly.bai1_labs2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn_quaySo;
    EditText ed_nhapSo;
    TextView tv_quaySo;
    TextView tv_ketQua;
    TextView tv_khongTrung;
    TextView tv_trungThuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lấy ra các thẻ
        btn_quaySo = findViewById(R.id.btn_quaySo);
        ed_nhapSo = findViewById(R.id.ed_nhapSo);
        tv_quaySo = findViewById(R.id.tv_chonQuay);
        tv_ketQua = findViewById(R.id.tv_ketQua);
        tv_khongTrung = findViewById(R.id.tv_khongTrung);
        tv_trungThuong = findViewById(R.id.tv_trungThuong);


        // vô hiệu hóa mấy thẻ ban đầu

        tv_ketQua.setVisibility(View.GONE);
        tv_khongTrung.setVisibility(View.GONE);
        tv_trungThuong.setVisibility(View.GONE);


        // khi nào được onclick thì hàm này mời được chạy còn dữ liệu ở trên thì không được chạy lại
        btn_quaySo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int soQuay = r.nextInt(99); // quay trong 99 số

                tv_ketQua.setText("KẾT QUẢ: " + soQuay);
                tv_quaySo.setVisibility(View.GONE);
                tv_ketQua.setVisibility(View.VISIBLE);

                // lấy số nhập
                int soBanNhap = Integer.parseInt(ed_nhapSo.getText().toString());

                if(soQuay == soBanNhap) {
                    tv_trungThuong.setVisibility(View.VISIBLE);
                    tv_khongTrung.setVisibility(View.GONE);
                } else {
                    tv_khongTrung.setVisibility(View.VISIBLE);
                    tv_trungThuong.setVisibility(View.GONE);
                }
            }
        });
    }


}