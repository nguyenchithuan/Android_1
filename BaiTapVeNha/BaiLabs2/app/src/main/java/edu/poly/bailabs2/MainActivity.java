package edu.poly.bailabs2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ánh xạ vào biến
        btnOpen = findViewById(R.id.btnOpen);


        // tạo sự kiện onclick
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // tạo intent để gọi activity
                // intent có vai trò giống nhữ shipper
                Intent intent = new Intent(getBaseContext(), MayTinhActivity.class);

                // Khai báo dữ liệu có thể lấy từ ô text hoặc từ hàm khác......
                String hoTen = "Nguyễn Chí Thuận";
                int tuoi = 30;

                // Đóng gói đữ liệu trước khi gửi đối tượng Bundle
                Bundle bundle = new Bundle(); // giống như 1 gói hàng
                bundle.putString("chuoiHoTen", hoTen);
                bundle.putInt("soTuoi", tuoi);

                // gắn bundle vào intent (giống như việc đưa gói hàng cho shipper)
                intent.putExtra("goiHang", bundle);

                startActivity(intent); // khởi động activity
            }
        });
    }
}