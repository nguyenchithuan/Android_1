package edu.poly.sharedpreferencestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edUserName, edPassWord;
    private CheckBox checkBox;
    private Button btnDangNhap;

    private SharedPreferences prefer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUserName = findViewById(R.id.edUserName);
        edPassWord = findViewById(R.id.edPassWord);
        checkBox = findViewById(R.id.chk_ghi_nho);
        btnDangNhap = findViewById(R.id.btn_dang_nhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writePrefer();
            }
        });

        prefer = getSharedPreferences("dataPrefer", MODE_PRIVATE);
        readPrefer();
    }

    public void writePrefer() {
        SharedPreferences.Editor editor = prefer.edit();

        editor.putString("username", edUserName.getText().toString());
        editor.putString("password", edPassWord.getText().toString());
        editor.putBoolean("check", checkBox.isChecked());

        editor.commit();
    }


    public void readPrefer() {
        String userName = prefer.getString("username", null);
        String passWord = prefer.getString("password", null);
        Boolean check = prefer.getBoolean("check", false);

        checkBox.setChecked(check);

        if(userName == null || passWord == null) {
            return;
        }

        if(checkBox.isChecked()) {
            edUserName.setText(userName);
            edPassWord.setText(passWord);
        } else {
            edUserName.setText(userName);
        }
    }

}