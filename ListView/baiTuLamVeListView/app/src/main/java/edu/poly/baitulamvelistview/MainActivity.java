package edu.poly.baitulamvelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv_employee;
    EmployeeAdapter adapter;
    List<Employee> list;

    public MainActivity() {
        list = new ArrayList<Employee>();
        list.add(new Employee(1, R.drawable.ic_baseline_add_to_home_screen_24, "thuan", 320000000));
        list.add(new Employee(2, R.drawable.ic_baseline_alarm_add_24, "hai", 30001));
        list.add(new Employee(3, R.drawable.ic_baseline_add_to_home_screen_24, "lam", 1234));
        list.add(new Employee(4, R.drawable.ic_baseline_alarm_add_24, "trang", 5412));

        adapter = new EmployeeAdapter(list); // lấy dữ liệu cho lên listview



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tạo view sau khi tạo ra một layout view
        lv_employee = findViewById(R.id.lv_employee);
        // gắn adepter vào listview
        lv_employee.setAdapter(adapter);
    }
}