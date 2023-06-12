package edu.poly.truyendulieuchacon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class ConActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true); // dòng này có thể bỏ qua
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onBackPressed() {

        Intent i = getIntent();
        i.putExtra("hoTen" ,"Dev Mobile Chấm NÉT");  // khai báo biến kiểu intent để gửi dữ liệu sang activity cha

        setResult(Activity.RESULT_OK,i); // lệnh này là để gửi dữ liệu, tham số thứ nhất là biến cờ trả lại trạng thái
        super.onBackPressed(); // cái này phải để dưới cuối
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            this.onBackPressed();

        return super.onOptionsItemSelected(item);
    }

}