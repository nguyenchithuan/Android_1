package edu.poly.sqlitetrencuangoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import edu.poly.sqlitetrencuangoc.Adapter.EployeeAdapter;
import edu.poly.sqlitetrencuangoc.Model.Employee;
import edu.poly.sqlitetrencuangoc.SQLite.EmployeeDao;

public class MainActivity extends AppCompatActivity {
    ListView lvEmployee;
    EployeeAdapter adapter;
    EmployeeDao dao;
    List<Employee> list;

    int position = -1;

    String employeeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEmployee = findViewById(R.id.lvEmployee);

        dao = new EmployeeDao(this);

        list = dao.getAll();

        adapter = new EployeeAdapter(list);

        lvEmployee.setAdapter(adapter);


        lvEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                position = i;
                employeeId = list.get(i).getId();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        list = new EmployeeDao(this).getAll();
        adapter = new EployeeAdapter(list);

        lvEmployee.setAdapter(adapter);
    }

    public void insertOnclick(View view) {
        Intent intent = new Intent(this, EmployeeActivity.class);
        startActivity(intent);
    }

    public void updateOnclick(View view) {

        if(position == -1) {
            return;
        }

        Intent intent = new Intent(this, EmployeeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", employeeId);
        intent.putExtra("data", bundle);


        startActivity(intent);

        position = -1;
    }

    public void deleteOnclick(View view) {
        if(position == -1) {
            return;
        }

        Employee e = list.get(position);
        dao.delete(e);
        onResume();

        position = -1;
    }

}