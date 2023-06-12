package edu.poly.baitulamvelistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {
    List<Employee> list;

    public EmployeeAdapter(List<Employee> emp) {
        this.list = emp;
    }

    @Override
    public int getCount() { // lấy ra size của list
        return list.size();
    }

    @Override
    public Object getItem(int position) { // lấy ra đối tượng
        return list.get(position);
    }

    @Override
    public long getItemId(int position) { // lấy ra id
        return list.get(position).getId();
    }

    // đây là hàm quan trọng
    // getView: tạo ra layout cho mỗi mục hiển thị
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // nếu view truyền vào là null thì tạo ra cho nó một view mới
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.layout_employee_item, null);
            // tạo ra một view
        }

        // ánh xạ vào các view là các thẻ con trong view
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_luong = view.findViewById(R.id.tv_luong);
        ImageView img_employee = view.findViewById(R.id.img_employee);

        // lấy đối tượng trong list
        Employee e = list.get(position);

        // gán cho nó dữ liệu từ đối tượng vào các thẻ con của view
        tv_name.setText(e.getName());
        tv_luong.setText(e.getLuong() + "");
        img_employee.setImageResource(e.getImg());

        return view;
    }
}
