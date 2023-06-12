package edu.poly.ph26023_thi21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.poly.ph26023_thi21.Adapter.LichAdapter;
import edu.poly.ph26023_thi21.DAO.LichDao;
import edu.poly.ph26023_thi21.DTO.Lich;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    LichDao dao;
    LichAdapter adapter;
    ArrayList<Lich> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDanhSach = findViewById(R.id.lvDanhSach);
        dao = new LichDao(this);
        list = dao.selectAll();
        adapter = new LichAdapter(list, dao);
        lvDanhSach.setAdapter(adapter);
    }

    public void themOnclick(View view) {

        Dialog dialog = new Dialog(this, R.style.Theme_Ph26023_thi21);

        dialog.setContentView(R.layout.activity_them);

        EditText etTieuDe = dialog.findViewById(R.id.etTieuDe);
        EditText etNoiDung = dialog.findViewById(R.id.etNoiDung);
        EditText etThoiGian = dialog.findViewById(R.id.etThoiGian);

        Button btnThem = dialog.findViewById(R.id.btnLuu);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lich lich = new Lich();
                lich.setTieuDe(etTieuDe.getText().toString());
                lich.setNoiDung(etNoiDung.getText().toString());
                lich.setThoiGian(etThoiGian.getText().toString());

                if(etTieuDe.getText().toString().isEmpty() == true || etNoiDung.getText().toString().isEmpty() == true || etThoiGian.getText().toString().isEmpty() == true) {
                    Toast.makeText(MainActivity.this, "Nhập null!", Toast.LENGTH_SHORT).show();
                } else {
                    dao.insert(lich);
                    list.add(lich);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            }
        });

        dialog.show();



    }
}