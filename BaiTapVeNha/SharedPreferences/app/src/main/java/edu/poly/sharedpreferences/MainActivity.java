package edu.poly.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUserName, etPassWord;
    CheckBox chkGhiNho;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.etUserName);
        etPassWord = findViewById(R.id.etPassWord);
        chkGhiNho = findViewById(R.id.chkGhiNho);

        pref = getSharedPreferences("data", MODE_PRIVATE);

        readPref();
    }

    public void dangKyOnlick(View view) {
        if(etUserName.getText().toString().equalsIgnoreCase("admin") &&
           etPassWord.getText().toString().equalsIgnoreCase("123")) {

            writePref();
        } else {
            Toast.makeText(this, "Không đúng tài khoản!", Toast.LENGTH_SHORT).show();
        }
    }

    public void writePref() {
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("userName", etUserName.getText().toString());
        editor.putString("passWord", etPassWord.getText().toString());
        editor.putBoolean("check", chkGhiNho.isChecked());
        editor.commit();
    }

    public void readPref() {
        String userName = pref.getString("userName", null);
        String passWord = pref.getString("passWord", null);
        Boolean check = pref.getBoolean("check", false);

        chkGhiNho.setChecked(check);

        if(userName == null || passWord == null) {
            return;
        }
        if(chkGhiNho.isChecked()) {
            etUserName.setText(userName);
            etPassWord.setText(passWord);
        } else {
            etUserName.setText(userName);
        }
    }
}