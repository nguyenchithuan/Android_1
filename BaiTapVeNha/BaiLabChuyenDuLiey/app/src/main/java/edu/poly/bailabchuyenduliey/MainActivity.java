package edu.poly.bailabchuyenduliey;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_userName;
    TextView tv_passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_userName = findViewById(R.id.tv_userName);
        tv_passWord = findViewById(R.id.tv_passWord);


    }


    ActivityResultLauncher activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            tv_userName.setText("User name: " + result.getData().getStringExtra("userName"));
            tv_passWord.setText("Pass word: " + result.getData().getStringExtra("passWord"));
        }
    });

    public void openActivityLogin(View view) {
        Intent intent = new Intent(getBaseContext(), LoginActivity.class);
        activityResultLauncher.launch(intent);
    }
}