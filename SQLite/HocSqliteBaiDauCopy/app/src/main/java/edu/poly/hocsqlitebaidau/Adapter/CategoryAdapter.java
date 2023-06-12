package edu.poly.hocsqlitebaidau.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.poly.hocsqlitebaidau.DTO.Cat;
import edu.poly.hocsqlitebaidau.R;

public class CategoryAdapter extends BaseAdapter { // gọi ra nó chính là 1 adapter nó chính là 1 mang
    ArrayList<Cat> listCat;

    public CategoryAdapter(ArrayList<Cat> listCat) {
        this.listCat = listCat;
    }

    @Override
    public int getCount() {
        return listCat.size();
    }

    @Override
    public Object getItem(int position) {
        return listCat.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCat.get(position).getId();
    }


    // tự đọng chạy khi tạo adapter
    @Override // listview khi chuyển bị hiển thị lên thì nói mới hoạt động
    public View getView(int position, View view, ViewGroup viewGroup) {
        // tạo 1 dòng view mới nếu ko co
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.row_list_view, null);
        }

        // Ánh xạ trên 1 dòng
        TextView tv_id = view.findViewById(R.id.tv_id);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_edit = view.findViewById(R.id.tv_edit);
        TextView tv_delete = view.findViewById(R.id.tv_delete);

        // gán dữ liệu vào TextView

        Cat objCat = listCat.get(position);

        // gán dữ liệu cho TextView
        tv_id.setText(objCat.getId() + "");
        tv_name.setText(objCat.getName());

        return view;
    }
}
