package edu.poly.bonhongoai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SaveFileSDCard(View view){
        String data = "Xin chao, noi dung ghi sdcard"; // nội dung cần ghi vào file, bạn có thể lấy từ EditText
        //---------- Ghi file
        // khai báo đường dẫn tới file ở thẻ SDcard
        String sdcard_file = Environment.getExternalStorageDirectory().getAbsolutePath() + "/hello.txt";


        try {
            // tạo đối tượng outputstream
            FileOutputStream fileOutputStream = new FileOutputStream(sdcard_file);

            // tạo luồng ghi
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);

            writer.write(data);
            writer.close(); // đóng luồng ghi
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void ReadFileSDCard(View view){

        String sdcard_file = Environment.getExternalStorageDirectory().getAbsolutePath() + "/hello.txt";

        // Đọc thẻ nhớ
        File file_to_read = new File(sdcard_file);
        try {
            // dùng đối tượng scanner để đọc file
            Scanner scanner = new Scanner(file_to_read);

            String tmp_data = "";

            while (scanner.hasNext()){
                tmp_data += scanner.nextLine();  // đọc giống trong java thuần
            }

            scanner.close(); // đọc xong thì đóng luồng và thông báo nội dung ra màn hình

            Toast.makeText(getBaseContext(),tmp_data,Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}