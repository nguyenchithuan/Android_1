package edu.poly.assignment2_ph26023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.assignment2_ph26023.Adapter.LopAdapter;
import edu.poly.assignment2_ph26023.DAO.LopDao;
import edu.poly.assignment2_ph26023.DTO.Lop;

public class DanhSachLopActivity extends AppCompatActivity {
    ListView lvLop;
    ArrayList<Lop> list;
    LopDao dao;
    LopAdapter adapter;

    int indexListView = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);
        lvLop = findViewById(R.id.lvSv);

        dao = new LopDao(this);
        list = dao.selectAll();
        adapter = new LopAdapter(list);

        lvLop.setAdapter(adapter);

        lvLop.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removeLop(list.get(position).getStt());
                return false;
            }
        });

        lvLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                indexListView = position;
            }
        });
    }

    @Override
    protected void onResume() {
        dao = new LopDao(this);
        list = dao.selectAll();
        adapter = new LopAdapter(list);

        lvLop.setAdapter(adapter);
        super.onResume();
    }




    // --------- Item menu -----------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemThem) {
            dialogThem();
        }
        return super.onOptionsItemSelected(item);
    }
    //----------------------------------------



    //----------------------------them---------------------------
    public void dialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.them_lop);

        EditText etMaLop = dialog.findViewById(R.id.etMaLop);
        EditText etTenLop = dialog.findViewById(R.id.etTenLop);
        Button btnClearForm = dialog.findViewById(R.id.btnXoaFontLop);
        Button btnLuu = dialog.findViewById(R.id.btnLuuLop);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lop lop = new Lop();
                lop.setMaLop(etMaLop.getText().toString());
                lop.setTenLop(etTenLop.getText().toString());
                dao.insert(lop);
                onResume();
                Toast.makeText(DanhSachLopActivity.this, "Thêm lớp thành công!", Toast.LENGTH_SHORT).show();

                dialog.cancel();
            }
        });

        btnClearForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMaLop.setText("");
                etTenLop.setText("");
            }
        });


        dialog.show();
    }



    //------------------------update----------------------------
    public void updateLopOnclick(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.them_lop);

        TextView tvTieuDeLop = dialog.findViewById(R.id.tvTieuDeLop);
        EditText etMaLop = dialog.findViewById(R.id.etMaLop);
        EditText etTenLop = dialog.findViewById(R.id.etTenLop);
        Button btnClearForm = dialog.findViewById(R.id.btnXoaFontLop);
        Button btnLuu = dialog.findViewById(R.id.btnLuuLop);

        tvTieuDeLop.setText("Sửa Một Lớp");
        btnLuu.setText("Thay đổi");

        if(indexListView != -1) {
            Lop l = list.get(indexListView);
            etMaLop.setText(l.getMaLop());
            etTenLop.setText(l.getTenLop());


            btnLuu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Lop lop = new Lop();
                    lop.setStt(l.getStt());
                    lop.setMaLop(etMaLop.getText().toString());
                    lop.setTenLop(etTenLop.getText().toString());
                    dao.update(lop);
                    onResume();
                    Toast.makeText(DanhSachLopActivity.this, "Update lớp thành công!", Toast.LENGTH_SHORT).show();
                    indexListView = -1;
                    dialog.cancel();
                }
            });

            btnClearForm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    etMaLop.setText("");
                    etTenLop.setText("");
                }
            });

            dialog.show();
        }
    }


    public void removeLop(int stt) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có đồng ý muốn xóa không!");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Lop lop = new Lop();
                lop.setStt(stt);
                dao.delete(lop);
                Toast.makeText(DanhSachLopActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                onResume();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }
}