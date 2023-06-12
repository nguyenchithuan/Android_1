package edu.poly.baitestamsignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.baitestamsignment.Adapter.lopAdapter;
import edu.poly.baitestamsignment.DTO.Lop;
import edu.poly.baitestamsignment.Dao.LopDao;

public class DanhSachLopActivity extends AppCompatActivity {
    ListView lvLop;
    LopDao dao;
    ArrayList<Lop> list;
    lopAdapter adapter;

    EditText etMaLop;
    EditText etTenLop;

    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);
        lvLop = findViewById(R.id.lvLop);

        etMaLop = findViewById(R.id.etMaLop);
        etTenLop = findViewById(R.id.etTenLop);

        dao = new LopDao(this);

        list = dao.selectAll();
        adapter = new lopAdapter(list);
        lvLop.setAdapter(adapter);

        lvLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;

                Lop lop = list.get(position);
                etMaLop.setText(lop.getMaLop());
                etTenLop.setText(lop.getTenLop());
            }
        });

        lvLop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                vitri = position;
                delete(list.get(position).getMaLop());
                return false;
            }
        });
    }

    public void themLopOnclick(View view) {
        Lop lop = new Lop();
        lop.setMaLop(etMaLop.getText().toString());
        lop.setTenLop(etTenLop.getText().toString());
        dao.insert(lop);
        list.add(lop);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Them thanh cong!", Toast.LENGTH_SHORT).show();
    }

    public void updateLopOnclick(View view) {
        Lop lop = new Lop();
        lop.setMaLop(etMaLop.getText().toString());
        lop.setTenLop(etTenLop.getText().toString());
        dao.update(lop);
        list.set(vitri, lop);
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Update thanh cong!", Toast.LENGTH_SHORT).show();
    }

    public void delete(String maLop) {
        Lop lop = new Lop();
        lop.setMaLop(maLop);
        dao.delete(lop);
        list.remove(vitri);
        adapter.notifyDataSetChanged();

        Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();

    }
}