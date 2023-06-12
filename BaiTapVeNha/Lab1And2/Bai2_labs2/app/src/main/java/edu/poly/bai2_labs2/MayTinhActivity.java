package edu.poly.bai2_labs2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MayTinhActivity extends AppCompatActivity {
    private double so_a;
    private double so_b;
    private String phepTinh = "";
    private TextView tv_tinhToan;
    private String hienThi = "";
    int a = 0; // giới hạn chỉ được nhập 1 lần a
    int b = 0; // giới hạn chỉ được nhập 1 lần b
    int i = 0; // phải nhập phép toán thì mới được nhập số b
    int k = 0; // kiểm tra xem ấn nút = bao nhiêu lần


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh);
        tv_tinhToan = findViewById(R.id.tv_tinhToan);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        String hoten = bundle.getString("hoten");
        Toast.makeText(this, "Hoten: " + hoten, Toast.LENGTH_SHORT).show();
    }

    // chọn các phép toán thì hàm này sẽ được chạy
    public void phepToan_onclick(View view) {
        Button button = (Button) view; // lấy ra nut mà mình đang ấn hiện tai
        if(phepTinh.length() == 0) { // kiểm tra xem hàm đã có nut nào hày chưa
            phepTinh = button.getText().toString();
            hienThi = hienThi + " " + phepTinh + " ";
            tv_tinhToan.setText(hienThi);
            i = 1;
        }
    }

    // chọn các số thì hàm này sẽ được chạy
    public void nunber_onclick(View view) {
        Button button = (Button) view;
        if(phepTinh.length() == 0 && a == 0) {
            so_a = Double.parseDouble(button.getText().toString());
            hienThi = hienThi + so_a;
            a = 1; // khi nhận 1 giá trị a thì lần sau sẽ không được nhập nữa
        } else if(b == 0 && (a != 1 || i == 1)){
            so_b = Double.parseDouble(button.getText().toString());
            hienThi = hienThi + so_b;
            b = 1; // khi nhận 1 giá trị b thì lần sau sẽ không được nhập nữa
        }
        tv_tinhToan.setText(hienThi);
    }


    // chọn đấu = thì hàm này sẽ được chạy
    public void ketQua_onclick(View view) {
        if(b == 1) {
            if(k == 0 );
            hienThi = hienThi + " = ";
            Double kq;

            switch (phepTinh) {
                case "-":
                    kq = so_a - so_b;
                    hienThi = hienThi + kq;
                    break;
                case "+":
                    kq = so_a + so_b;
                    hienThi = hienThi + kq;
                    break;
                case "*":
                    kq = so_a * so_b;
                    hienThi = hienThi + kq;
                    break;
                case "/":
                    kq = so_a / so_b;
                    hienThi = hienThi + kq;
                    break;
            }
            tv_tinhToan.setText(hienThi);
        }
    }

    // chọc C thi hạm này sẽ được chạy
    public void reset_onclick(View view) {
        a = 0;
        b = 0;
        i = 0;
        k = 0;
        phepTinh = "";
        hienThi = "";
        tv_tinhToan.setText(hienThi);
    }
}