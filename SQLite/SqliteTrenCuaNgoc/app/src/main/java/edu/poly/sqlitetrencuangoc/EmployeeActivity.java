package edu.poly.sqlitetrencuangoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import edu.poly.sqlitetrencuangoc.Adapter.EployeeAdapter;
import edu.poly.sqlitetrencuangoc.Model.Employee;
import edu.poly.sqlitetrencuangoc.SQLite.EmployeeDao;

public class EmployeeActivity extends AppCompatActivity {
    EditText etId, etName, etSalary;
    EmployeeDao employeeDao; // duLieu chung;

    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etSalary = findViewById(R.id.etSalary);
        btnSave = findViewById(R.id.btnSave);

        readEmployee();
    }


    public void readEmployee() {
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("data");

        if(bundle == null) {
            return;
        }

        String id = bundle.getString("id");

        Employee e = new EmployeeDao(this).getById(id);

        etId.setText(e.getId());
        etName.setText(e.getName());
        etSalary.setText(e.getSalary() + "");

        btnSave.setText("Update");

    }

    public void saveOnclick(View view) {
        employeeDao = new EmployeeDao(this);
        Employee e = new Employee();
        e.setId(etId.getText().toString());
        e.setName(etName.getText().toString());
        e.setSalary(Double.parseDouble(etSalary.getText().toString()));

        if(btnSave.getText().toString().equalsIgnoreCase("save")) {
            employeeDao.inser(e);
            Toast.makeText(this, "Thêm một nhân viên!", Toast.LENGTH_SHORT).show();
        } else {
            employeeDao.update(e);
            Toast.makeText(this, "Thay đổi một nhân viên!", Toast.LENGTH_SHORT).show();
        }


    }

    public void listOnclick(View view) {

    }
}