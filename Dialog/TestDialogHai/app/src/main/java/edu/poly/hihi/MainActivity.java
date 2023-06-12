package edu.poly.hihi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv_click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_click = findViewById(R.id.tv_click);

        tv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogLogin();
            }
        });

    }

    public void dialogLogin() {
        Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dang_nhap);

        dialog.setCanceledOnTouchOutside(false);

        // các thảo tác của dialog chứ không phải của activity này
        EditText etTaiKhoan = dialog.findViewById(R.id.etTaiKhoan);
        EditText etMatKhau = dialog.findViewById(R.id.etMatKhau);
        Button btnDangNhap = dialog.findViewById(R.id.btnDangNhap);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etTaiKhoan.getText().toString().equalsIgnoreCase("admin") && etMatKhau.getText().toString().equalsIgnoreCase("123")) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });


        // hiển thị dialog
        dialog.show();
    }
}