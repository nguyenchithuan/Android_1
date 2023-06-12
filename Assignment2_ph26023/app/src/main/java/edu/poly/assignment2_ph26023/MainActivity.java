package edu.poly.assignment2_ph26023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUserName, etPassWord;
    CheckBox chkThongTin;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //Ẩn tên ứng dụng
        getSupportActionBar().hide(); // Ẩn luôn thanh tiêu đề

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //bật chế độ toàn màn hình

        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.etUserName);
        etPassWord = findViewById(R.id.etPassWord);
        chkThongTin = findViewById(R.id.chkThongTin);

        pref = getSharedPreferences("data", MODE_PRIVATE);

        read();

        Intent intent = new Intent(getBaseContext(), ChaoMoiNguoiActivity.class);
        startActivity(intent);
    }


    public void dangKyOnclick(View view) {
        if(etUserName.getText().toString().equalsIgnoreCase("admin") &&
            etPassWord.getText().toString().equalsIgnoreCase("123")) {
            write();
            Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(), HeThongActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
        }
    }

    public void write() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("userName", etUserName.getText().toString());
        editor.putString("passWord", etPassWord.getText().toString());
        editor.putBoolean("kiemTra", chkThongTin.isChecked());
        editor.commit();
    }

    public void read() {
        String userName = pref.getString("userName", null);
        String passWord = pref.getString("passWord", null);
        Boolean kiemTraCheck = pref.getBoolean("kiemTra", false);

        chkThongTin.setChecked(kiemTraCheck);

        if(userName != null) {
            if(chkThongTin.isChecked()) {
                etUserName.setText(userName);
                etPassWord.setText(passWord);
            } else {
                etUserName.setText(userName);
            }
        }
    }
}