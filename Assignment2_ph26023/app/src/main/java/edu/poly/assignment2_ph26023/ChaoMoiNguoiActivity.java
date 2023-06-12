package edu.poly.assignment2_ph26023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.Toast;

public class ChaoMoiNguoiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //Ẩn tên ứng dụng
        getSupportActionBar().hide(); // Ẩn luôn thanh tiêu đề

        setContentView(R.layout.activity_chao_moi_nguoi);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Công việc sẽ thực hiện sau 5s = 5000ms
                Toast.makeText(ChaoMoiNguoiActivity.this, "Hết 5s, stop", Toast.LENGTH_LONG).show();
                finish();
            }

        }, 5000);
        // Bạn có thể áp dụng để làm màn hình chào....
    }
}