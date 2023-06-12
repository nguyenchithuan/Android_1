package edu.poly.vidulistviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_product;
    ProductAdapter adapter;
    ArrayList<Product> listProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        lv_product = findViewById(R.id.lv_product);

        // khởi tạo dữ liệu
        listProduct = new ArrayList<Product>();

        listProduct.add(new Product(1, "Điện thoạt", 200, R.drawable.anh1b));
        listProduct.add(new Product(2, "Tủ lạnh", 300, R.drawable.anh1b));
        listProduct.add(new Product(3, "Tivi", 400, R.drawable.anh1b));
        listProduct.add(new Product(4, "Xe máy", 200, R.drawable.anh1b));


        // khởi tạo Adapter
        adapter = new ProductAdapter(listProduct);

        //gắn adapter vào listview
        lv_product.setAdapter(adapter);
    }
}