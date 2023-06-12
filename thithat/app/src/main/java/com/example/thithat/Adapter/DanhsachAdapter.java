package com.example.thithat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thithat.R;

import java.util.ArrayList;

public class DanhsachAdapter extends BaseAdapter {
    Context context;
    ArrayList<Danhsanh> arrayList;

    public DanhsachAdapter(Context context, ArrayList<Danhsanh> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override

    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.row,null,false);
        TextView name= view.findViewById(R.id.tvname);
        TextView nghe= view.findViewById(R.id.tvnghe);
        Danhsanh danhsanh = arrayList.get(position);
        name.setText(danhsanh.getName());
        nghe.setText(danhsanh.getNghe());



        return view;
    }
}
