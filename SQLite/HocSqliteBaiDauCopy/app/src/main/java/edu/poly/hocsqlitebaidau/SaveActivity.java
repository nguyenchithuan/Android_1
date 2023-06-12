package edu.poly.hocsqlitebaidau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.poly.hocsqlitebaidau.DAO.CatDAO;
import edu.poly.hocsqlitebaidau.DTO.Cat;

public class SaveActivity extends AppCompatActivity {
    EditText etId, etTen;
    Button btnSave;

    CatDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        // ánh xạ các view
        etId = findViewById(R.id.etId);
        etTen = findViewById(R.id.etTen);
        btnSave = findViewById(R.id.btnSave);

        dao = new CatDAO(this);

        writeForm();
    }


    // viết dữ liệu vào form
    public void writeForm() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle == null) {
            return;
        }
        int id = bundle.getInt("id");

        Cat c = dao.selectOne(id);

        etId.setText(c.getId() + "");
        etTen.setText(c.getName());


        btnSave.setText("Update");
    }

    public void saveOnclick(View view) {
        dao = new CatDAO(this);
        Cat c = new Cat();
        c.setId(Integer.parseInt(etId.getText().toString()));
        c.setName(etTen.getText().toString());

        if(btnSave.getText().toString().equalsIgnoreCase("save")) {
            dao.insertRow(c);
            Toast.makeText(this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
        } else {
            dao.updateRow(c);
            Toast.makeText(this, "Update thành Công!", Toast.LENGTH_SHORT).show();
        }
    }
}