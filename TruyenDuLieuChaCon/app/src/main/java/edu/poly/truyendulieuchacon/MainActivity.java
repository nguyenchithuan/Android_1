package edu.poly.truyendulieuchacon;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String TAG = "zzzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ActivityResultLauncher toolActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Log.d(TAG, "onActivityResult: " + result.toString());  // dòng này là in toàn bộ dữ liệu ra để xem
            Log.d(TAG, "onActivityResult: " + result.getResultCode());  // dòng này để xem cái code mà bên activityCon đánh dấu trả lại là gì
            Log.d(TAG, "onActivityResult: hoTen = " + result.getData().getStringExtra("hoTen"));  // dòng này là lấy dữ liệu từ ActivityCon trả lại thông qua Intent.
        }
    });


    public void OpenActivityCon(View view) {
        Intent intent = new Intent(this, ConActivity.class);
        toolActivityResultLauncher.launch(intent);
        Log.d(TAG, "OpenAct2: " );
    }
}