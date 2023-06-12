package edu.poly.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences; // khai báo thuộc tính cấp class để sử dụng chung trong các hàm

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // khởi tạo biến
        sharedPreferences = getSharedPreferences("user_count", MODE_PRIVATE);
    }

    public void writePrefOnclick(View view) {
        // khởi tạo biến editor để thực hiện thao tác ghi vào sharedpref
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("hoTen", "Nguyễn văn a");
        editor.putString("email", "hai@gmail.com");


        //commit để gửi dữ liệu xuống file
        editor.commit();
    }

    public void readPrefOnclick(View view) {
        // đọc dữ liệu từ shared pref
        String hoTen = sharedPreferences.getString("hoTen", null);
        String email = sharedPreferences.getString("email",  null);
        Toast.makeText(getBaseContext(), "Họ tên: " + hoTen + ", Email: " + email, Toast.LENGTH_SHORT).show();
    }
}