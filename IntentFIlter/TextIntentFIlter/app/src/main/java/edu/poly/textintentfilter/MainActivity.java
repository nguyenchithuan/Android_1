package edu.poly.textintentfilter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        imageView = findViewById(R.id.img_share);
//        imageView.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opt_menu01, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { // bấm vào menu nào thì nó ra menu đó
        switch (item.getItemId()) {
            case R.id.m_add:
                Toast.makeText(this, "Bạn chọn thêm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_2:
                Toast.makeText(this, "Bạn chọn m_2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_3:
                Toast.makeText(this, "Bạn chọn m_3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}