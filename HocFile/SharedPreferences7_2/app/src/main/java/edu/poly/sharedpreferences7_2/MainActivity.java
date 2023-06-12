package edu.poly.sharedpreferences7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUserName, etPassWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // gắp sự kiện
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnEdit).setOnClickListener(this);

        etUserName = findViewById(R.id.etUserName);
        etPassWord = findViewById(R.id.etPassWord);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if(etUserName.getText().toString().isEmpty()) {
                    read();
                    Toast.makeText(this, "Đọc dữ liệu thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    write();
                    Toast.makeText(this, "Ghi dữ liệu thành công!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnEdit:
                finish();// hoàn thành chương trình
                break;
        }
    }

    public void write() {
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String user = etUserName.getText().toString();
        String pass = etPassWord.getText().toString();

        editor.putString("userName", user);
        editor.putString("passWord", pass);

        editor.commit();
    }



    public void read() {
        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        String user = sharedPreferences.getString("userName", null);
        String pass = sharedPreferences.getString("passWord", null);

        if(user != null) {
            etUserName.setText(user);
        }

        if(pass != null) {
            etPassWord.setText(pass);
        }

    }
}