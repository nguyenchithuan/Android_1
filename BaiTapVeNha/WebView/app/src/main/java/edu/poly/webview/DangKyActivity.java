package edu.poly.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DangKyActivity extends AppCompatActivity {
    EditText etName, etEmail, etPhone, etGioiThieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etGioiThieu = findViewById(R.id.etGioiThieu);
    }

    public void dangKyOnlick(View view) {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("name", etName.getText().toString());
        editor.putString("email", etEmail.getText().toString());
        editor.putString("phone", etPhone.getText().toString());
        editor.putString("gioiThieu", etGioiThieu.getText().toString());

        editor.commit();
        // ----------------dong------------------
        finish();
    }

}