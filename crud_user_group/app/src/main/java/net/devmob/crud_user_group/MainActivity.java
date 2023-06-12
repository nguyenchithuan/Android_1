package net.devmob.crud_user_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import net.devmob.crud_user_group.Adapter.UserAdapter;

import net.devmob.crud_user_group.DAO.UserDAO;

public class MainActivity extends AppCompatActivity {
    UserDAO userDAO;
    UserAdapter userAdapter;

    Button btnGroup;
    Button btnAdd;
    ListView lvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //=================
        userDAO = new UserDAO(this);
        userDAO.open();

        userAdapter = new UserAdapter(userDAO.selectAll(), userDAO);


        // ánh xạ các view
        btnGroup = findViewById(R.id.btnGroup);
        btnAdd = findViewById(R.id.btnAdd);
        lvUser = findViewById(R.id.lvGroup);

        btnGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), TbGroupActivity.class));
            }
        });

        lvUser.setAdapter(userAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userAdapter.showDialogAdd(MainActivity.this);
            }
        });


    }
}