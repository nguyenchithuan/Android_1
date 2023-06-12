package edu.poly.baikiemtratrenlop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_email, ed_passWord;
    Button btn_dangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ed_email = findViewById(R.id.ed_email);
        ed_passWord = findViewById(R.id.ed_passWord);
        btn_dangKy = findViewById(R.id.btn_dangKy);

        btn_dangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed_email.getText().toString().equalsIgnoreCase("admin@gmail.com") && ed_passWord.getText().toString().equalsIgnoreCase("123")) {


                    Intent intent = new Intent(getBaseContext(), InfoActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("email", ed_email.getText().toString());
                    bundle.putString("password", ed_passWord.getText().toString());

                    intent.putExtra("data", bundle);

                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}