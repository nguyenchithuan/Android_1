package edu.poly.bai2_labs2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed_hoten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_hoten = findViewById(R.id.ed_hoVaTen);
    }

    public void nutTinhToan_Onclick(View view) {
        // khi mình ấn vào sự kiện thì view sẽ nhận cái nút ý
        // nhưng đang ở kiểu view lên phải ép về button
        Intent intent = new Intent(MainActivity.this, MayTinhActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("hoten", ed_hoten.getText().toString());
        intent.putExtra("data", bundle);
        startActivity(intent);
    }
}