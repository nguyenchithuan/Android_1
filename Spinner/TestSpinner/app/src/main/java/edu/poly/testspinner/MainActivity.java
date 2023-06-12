package edu.poly.testspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String [] list_prov = {"Hà Nội", "Hải Phòng", "Hồ Chí Minh"};
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list_prov);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                spinner.setSelection(1);
//                spinner.getSelectedItem();
//                spinner.getSelectedItemPosition();

                for (int i = 0; i < spinner.getCount(); i++) {
                    spinner.setSelection(i);
                    if("Hồ Chí Minh".equalsIgnoreCase(spinner.getSelectedItem() + "")) {
                        Toast.makeText(MainActivity.this, spinner.getSelectedItem() + "", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}