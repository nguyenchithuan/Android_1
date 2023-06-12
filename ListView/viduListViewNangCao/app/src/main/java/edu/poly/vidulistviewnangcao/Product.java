package edu.poly.vidulistviewnangcao;

public class Product {
    int id;
    String name; // tên sản phẩm
    double price; // giá tiền
    int img_res; // ID của ảnh trong thư muc drawable
    // thuộc tính ảnh nhập giá trị số int

    public Product(int id, String name, double price, int img_res) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img_res = img_res;
    }

}
