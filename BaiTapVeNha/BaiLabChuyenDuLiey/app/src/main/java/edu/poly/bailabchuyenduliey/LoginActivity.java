package edu.poly.bailabchuyenduliey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText et_userName;
    EditText et_passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_userName = findViewById(R.id.et_userName);
        et_passWord = findViewById(R.id.et_passWord);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("userName", et_userName.getText().toString());
        intent.putExtra("passWord", et_passWord.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        super.onBackPressed();
    }

    public void loginOnclick(View view) {
        onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}