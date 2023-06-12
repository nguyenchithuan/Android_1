package net.devmob.crud_user_group.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.devmob.crud_user_group.DTO.GroupUser;
import net.devmob.crud_user_group.R;

import java.util.ArrayList;

public class SpinGroupUserAdapter extends BaseAdapter {
    ArrayList<GroupUser> listGroupUser;

    public SpinGroupUserAdapter(ArrayList<GroupUser> listGroupUser) {
        this.listGroupUser = listGroupUser;
    }

    @Override
    public int getCount() {
        return listGroupUser.size();
    }

    @Override
    public Object getItem(int i) {
        GroupUser objGroup = listGroupUser.get(i);
        return objGroup;
    }

    @Override
    public long getItemId(int i) {
        GroupUser objGroup = listGroupUser.get(i);
        return objGroup.getId_group();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        // khởi tạo cho itemView
        if(view == null){
            itemView = View.inflate(viewGroup.getContext(), R.layout.item_spin_group_user, null);
        }else
            itemView = view;

        //--- lấy thông tin bản ghi dữ liệu
        final GroupUser objGroup = listGroupUser.get(i);
        final int _index = i;

        // ánh xạ các view vào biến
        TextView tv_id = itemView.findViewById(R.id.tv_id);
        TextView tv_name = itemView.findViewById(R.id.tv_name);

        //----------- set text
        tv_id.setText( objGroup.getId_group() + "");
        tv_name.setText( objGroup.getName());

        return  itemView;
    }
}
