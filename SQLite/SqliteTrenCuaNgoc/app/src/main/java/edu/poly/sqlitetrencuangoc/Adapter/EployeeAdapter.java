package edu.poly.sqlitetrencuangoc.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.poly.sqlitetrencuangoc.Model.Employee;
import edu.poly.sqlitetrencuangoc.R;

public class EployeeAdapter extends BaseAdapter {
    List<Employee> list;

    public EployeeAdapter(List<Employee> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.layout_row_item, null);
        }

        TextView tvId = view.findViewById(R.id.tvId);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvSalary = view.findViewById(R.id.tvSalary);

        Employee e = list.get(position);

        tvId.setText(e.getId());
        tvName.setText(e.getName());
        tvSalary.setText(e.getSalary() + "");

        return view;
    }
}
