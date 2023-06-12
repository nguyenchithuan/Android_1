package edu.poly.radio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rdogroupGioiTinh;
    RadioButton rdoNam, rdoNu, rdoKhac;
    Button btn_nhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdogroupGioiTinh = findViewById(R.id.rdogroupGioiTinh);
        rdoNam = findViewById(R.id.rdoNam);
        rdoNu = findViewById(R.id.rdoNu);
        rdoKhac = findViewById(R.id.rdoKhac);
        btn_nhap = findViewById(R.id.btn_nhap);

        rdogroupGioiTinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId: tra ve id cua radioButton
                switch (checkedId) {
                    case R.id.rdoNam:
                        Toast.makeText(MainActivity.this, "Nam", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoNu:
                        Toast.makeText(MainActivity.this, "Nữ", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdoKhac:
                        Toast.makeText(MainActivity.this, "Khác", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });



        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdoNam.isChecked()) { // không dùng được isSelected, với setSelected
                    // chỉ dùng được isChecked và setChecked
                    Toast.makeText(MainActivity.this, "Nam", Toast.LENGTH_SHORT).show();

                } else if(rdoNu.isChecked()) {
                    Toast.makeText(MainActivity.this, "Nữ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Khác", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}