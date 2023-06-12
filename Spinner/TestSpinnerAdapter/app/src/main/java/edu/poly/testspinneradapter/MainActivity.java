package edu.poly.testspinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

        ArrayList<Lop> list = new ArrayList<>();

        Lop l1 = new Lop(1, "IT");
        Lop l2 = new Lop(2, "CNTT");
        Lop l3 = new Lop(3, "KHTN");
        Lop l4 = new Lop(4, "KHXH");

        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        Adapter adapter = new Adapter(list);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, spinner.getSelectedItemPosition() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == 3) {
                spinner.setSelection(i);
                break;
            }
        }
    }
}