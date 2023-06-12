package edu.poly.assignment2_ph26023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.poly.assignment2_ph26023.Adapter.SvAdapter;
import edu.poly.assignment2_ph26023.DAO.LopDao;
import edu.poly.assignment2_ph26023.DAO.SvDao;
import edu.poly.assignment2_ph26023.DTO.Lop;
import edu.poly.assignment2_ph26023.DTO.Sv;

public class DanhSachSvActivity extends AppCompatActivity {
    ListView lvSv;
    SvAdapter adapter;
    SvDao dao;
    ArrayList<Sv> list;
    int indexListView = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_sv);

        lvSv = findViewById(R.id.lvSv);

        dao = new SvDao(this);
        list = dao.selectAll();
        adapter = new SvAdapter(list);

        lvSv.setAdapter(adapter);

        lvSv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                indexListView = position;

                // lấy ra view ở vị trí position tương ứng và lấy ra sđt của list view ấy
                TextView tv = adapter.getView(position, view, parent).findViewById(R.id.tvSdtSv);
                String sdt = tv.getText().toString();

                // lấy ra view ở vị trí position tương ứng và gắn sự kiện cho gọi điện ý
                adapter.getView(position, view, parent).findViewById(R.id.tvGoiDien).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + sdt));
                        //C2: adapter.getSdt(); // lấy ra sdt mà khi ấn vào thì nhập được view tương ứng
                        startActivity(intent);
                    }
                });
            }
        });

        lvSv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                deleteSv(list.get(position).getStt());
                return false;
            }
        });

    }

    //---------------------------------itemMenu------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemThem) {
            themSv();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        dao = new SvDao(this);
        list = dao.selectAll();
        adapter = new SvAdapter(list);
        lvSv.setAdapter(adapter);
        super.onResume();
    }

    //----------------------------------------Them---------------------------------
    public void themSv() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.them_sv);

        EditText etMaLop = dialog.findViewById(R.id.etMaLop);
        EditText etTenSv = dialog.findViewById(R.id.etTenSv);
        EditText etNgaySinhSv = dialog.findViewById(R.id.etNgaySinhSv);
        EditText etSdtSv = dialog.findViewById(R.id.etSdtSv);
        RadioButton rdoNam = dialog.findViewById(R.id.rdoNam);
        RadioButton rdoNu = dialog.findViewById(R.id.rdoNu);
        Button btnThem = dialog.findViewById(R.id.btnThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sv sv = new Sv();
                sv.setMaLop(etMaLop.getText().toString());
                sv.setTenSv(etTenSv.getText().toString());
                sv.setNgaySinh(etNgaySinhSv.getText().toString());
                sv.setSdt(etSdtSv.getText().toString());
                if(rdoNam.isChecked()) {
                    sv.setGioiTinh("Nam");
                } else {
                    sv.setGioiTinh("Nữ");
                }

                Boolean kiemTra = false; // kiểm xem mã đã tồn tại chưa
                ArrayList<Lop> listLop = new LopDao(DanhSachSvActivity.this).selectAll();

                for (int i = 0; i < listLop.size(); i++) {
                    if(etMaLop.getText().toString().equalsIgnoreCase(listLop.get(i).getMaLop())) {
                        kiemTra = true;
                    }
                }

                if(kiemTra == false) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(DanhSachSvActivity.this);
                    builder.setTitle("Thông báo");
                    builder.setMessage("Không tồn tại mã lớp!");
                    builder.show();
                } else {
                    dao.insert(sv);
                    Toast.makeText(DanhSachSvActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    onResume();
                    dialog.cancel();
                }

            }

        });


        dialog.show();
    }


    //-------------------------------------------update---------------------------------------------
    public void updateSvOnclick(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.them_sv);

        TextView tvSinhVien = dialog.findViewById(R.id.tvSinhVien);
        EditText etMaLop = dialog.findViewById(R.id.etMaLop);
        EditText etTenSv = dialog.findViewById(R.id.etTenSv);
        EditText etNgaySinhSv = dialog.findViewById(R.id.etNgaySinhSv);
        EditText etSdtSv = dialog.findViewById(R.id.etSdtSv);
        RadioButton rdoNam = dialog.findViewById(R.id.rdoNam);
        RadioButton rdoNu = dialog.findViewById(R.id.rdoNu);
        Button btnThem = dialog.findViewById(R.id.btnThem);

        tvSinhVien.setText("UPDATE SINH VIEN");
        btnThem.setText("Thay đổi");

        if(indexListView != -1) {

            Sv sinhVien = list.get(indexListView);
            etMaLop.setText(sinhVien.getMaLop());
            etTenSv.setText(sinhVien.getTenSv());
            etNgaySinhSv.setText(sinhVien.getNgaySinh());
            etSdtSv.setText(sinhVien.getSdt());
            if(sinhVien.getGioiTinh().equalsIgnoreCase("Nam")) {
                rdoNam.setChecked(true);
            } else {
                rdoNu.setChecked(true);
            }

            btnThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sv sv = new Sv();
                    sv.setStt(sinhVien.getStt());
                    sv.setMaLop(etMaLop.getText().toString());
                    sv.setTenSv(etTenSv.getText().toString());
                    sv.setNgaySinh(etNgaySinhSv.getText().toString());
                    sv.setSdt(etSdtSv.getText().toString());
                    if(rdoNam.isChecked()) {
                        sv.setGioiTinh("Nam");
                    } else {
                        sv.setGioiTinh("Nữ");
                    }

                    Boolean kiemTra = false; // kiểm xem mã đã tồn tại chưa
                    ArrayList<Lop> listLop = new LopDao(DanhSachSvActivity.this).selectAll();

                    for (int i = 0; i < listLop.size(); i++) {
                        if(etMaLop.getText().toString().equalsIgnoreCase(listLop.get(i).getMaLop())) {
                            kiemTra = true;
                        }
                    }

                    if(kiemTra == false) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(DanhSachSvActivity.this);
                        builder.setTitle("Thông báo");
                        builder.setMessage("Không tồn tại mã lớp!");
                        builder.show();
                    } else {
                        dao.update(sv);
                        Toast.makeText(DanhSachSvActivity.this, "Update thành công!", Toast.LENGTH_SHORT).show();
                        onResume();
                        indexListView = -1;
                        dialog.cancel();
                    }

                }

            });

            dialog.show();

        }
    }



    //-----------------------------------------delete--------------------------------------------
    public void deleteSv(int stt) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Bạn có muốn xóa không ?");

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Sv sv = new Sv();
                sv.setStt(stt);
                dao.delete(sv);
                Toast.makeText(DanhSachSvActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                onResume();
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }



}