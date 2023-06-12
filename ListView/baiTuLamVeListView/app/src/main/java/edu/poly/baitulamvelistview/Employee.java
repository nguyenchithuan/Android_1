package edu.poly.baitulamvelistview;

public class Employee { // class để quản lý thuộc tính show trên listView
    private int id;
    private int img;
    private String name;
    private double luong;

    public Employee() {
    }

    public Employee(int id, int img, String name, double luong) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.luong = luong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
}
