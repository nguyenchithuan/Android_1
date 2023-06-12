package edu.poly.baitest5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.baitest5.Objects.Student;
import edu.poly.baitest5.adapter.StudentAdapter;
import edu.poly.baitest5.dao.StudentDAO;

public class MainActivity extends AppCompatActivity {
    private ListView lvSv;
    private ArrayList<Student> list;
    private StudentAdapter adapter;
    private StudentDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSv = findViewById(R.id.lv_sv);
        dao = new StudentDAO(this);
        list = dao.getAll();
        adapter = new StudentAdapter(this, list, dao);
        lvSv.setAdapter(adapter);

        lvSv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                themDuLieu();
            }
        });

    }

    private void themDuLieu() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_update_insert);

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        EditText ed_duLieu = dialog.findViewById(R.id.ed_insert_update);
        Button btn_send = dialog.findViewById(R.id.btn_insert_update);

        Student student = new Student();


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student.setName(ed_duLieu.getText().toString().trim());
                dao.inset(student);
                list = dao.getAll();
                adapter.setData(list);
                Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}