package net.devmob.crud_user_group;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import net.devmob.crud_user_group.Adapter.GroupUserAdapter;
import net.devmob.crud_user_group.DAO.GroupUserDAO;
import net.devmob.crud_user_group.DTO.GroupUser;

public class TbGroupActivity extends AppCompatActivity {
    GroupUserDAO groupUserDAO;
    GroupUserAdapter groupUserAdapter;
    Button btnAdd;
    ListView lvGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);


        btnAdd = findViewById(R.id.btnAdd);
        lvGroup = findViewById(R.id.lvGroup);


        groupUserDAO = new GroupUserDAO(this);
        groupUserDAO.open();

        groupUserAdapter = new GroupUserAdapter(groupUserDAO.selectAll(), groupUserDAO);


        lvGroup.setAdapter(groupUserAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                groupUserAdapter.showDialogAdd(TbGroupActivity.this);
            }
        });

    }


}