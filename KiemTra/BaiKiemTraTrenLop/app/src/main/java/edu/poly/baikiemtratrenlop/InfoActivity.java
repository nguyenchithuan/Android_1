package edu.poly.baikiemtratrenlop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");

        String email = bundle.getString("email");
        String password = bundle.getString("password");

        TextView tv_hienTextView = findViewById(R.id.tv_hienThi);

        TextView tv_goi = findViewById(R.id.tv_goiDien);
        tv_hienTextView.setText("Email: " + email + "\nPassword: " + password);

        Button goi = findViewById(R.id.btn_goiDien);

        goi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tv_goi.getText().toString()));
                startActivity(intent1);
            }
        });

    }
}