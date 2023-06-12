package edu.poly.ghifilecache;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText ed_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_content = findViewById(R.id.ed_content);
    }


    public void SaveCache(View view) {
        String file_name = "vd_cache.txt";
        String noi_dung = ed_content.getText().toString();
        // ed_content là EditText xem ở bài viết đọc ghi file ở link trên nhé

        try {
            // lấy đường dẫn thư mục cache
            File pathCacheDir = getCacheDir();
            // tạo file cache
            File objFile = new File(pathCacheDir, file_name);
            objFile.createNewFile(); // tạo mới file trống trong thư mục cache

            //----- tiến hành ghi vào file cache
            FileOutputStream fileOutputStream = new FileOutputStream(objFile.getAbsolutePath());
            fileOutputStream.write(noi_dung.getBytes());
            fileOutputStream.close();

            Toast.makeText(getBaseContext(), "Đã ghi vào cache", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public void ReadCache(View view){
            String file_name = "vd_cache.txt";

            try {
                File pathCacheDir = getCacheDir();
                File objFile = new File(pathCacheDir,file_name);
                // tiến hành đọc file
                Scanner scanner = new Scanner(objFile);
                String tmp_data = "";
                while (scanner.hasNext()){
                    tmp_data += scanner.nextLine();
                }
                scanner.close();

                Toast.makeText(getBaseContext(),"Nội dung cache: " + tmp_data, Toast.LENGTH_SHORT).show();

            }catch (IOException e){
                e.printStackTrace();
            }


        }


    }
