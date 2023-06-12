package edu.poly.luutrufile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText ed_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_content = findViewById(R.id.ed_content);
    }

    public void SaveFile(View view){
        String noidung = ed_content.getText().toString(); // lấy nội dung người dùng vừa nhập
        String file_name = "vidu.txt";  // khai báo tên file sẽ lưu

        try {
            // mở luồng tạo file
            FileOutputStream fileOutputStream = openFileOutput(file_name, Context.MODE_PRIVATE);

            // ghi dữ liệu vào file, chuyển chuỗi nội dung thành mảng các byte dữ liệu và ghi file
            fileOutputStream.write(noidung.getBytes());

            // đóng luồng
            fileOutputStream.close();

            // nếu không có lỗi thì thông báo kết quả
            Toast.makeText(getBaseContext(), "Đã ghi vào file", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            // lỗi này là không đúng đường dẫn file
            e.printStackTrace();
        } catch (IOException e) {
            // lỗi này là lỗi không thể ghi dữ liệu vào file hoặc không mở được file do tiến trình khác đang mở file này.
            e.printStackTrace();
        }
    }

    public void ReadFile(View view){
        String file_name = "vidu.txt";  // chú ý phải đúng tên file bạn đã ghi nhé.
        //tạo đối tượng string buff để xây dựng chuỗi dữ liệu
        StringBuffer stringBuffer = new StringBuffer();

        try {

            // luồng dữ liệu file
            FileInputStream fileInputStream = openFileInput(file_name);
            // khai báo luồng đọc dữ liệu
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            // tạo biến đệm cho quá trình đọc
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            // Dùng vòng lặp để đọc từ dòng đầu tiên đến hết file
            while ( ( line = bufferedReader.readLine() ) != null     ){
                // nếu kết quả đọc 1 dòng cho vào biến line mà khác null (nghĩa là biến line nhận giá trị khác null) thì append vào chuỗi buffer
                stringBuffer.append(line); // nối vào chuỗi buffer
            }

            // kết thúc vòng lặp thì hoàn thành đọc file. Khi nào đọc hết file thì line sẽ là null
            // thông báo ra màn hình thôi
            Toast.makeText(getBaseContext(), stringBuffer.toString(),Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}