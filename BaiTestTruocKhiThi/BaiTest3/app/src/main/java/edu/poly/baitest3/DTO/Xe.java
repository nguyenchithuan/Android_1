package edu.poly.baitest3.DTO;

public class Xe {
    private int id;
    private String tenXe;

    public Xe() {
    }

    public Xe(int id, String tenXe) {
        this.id = id;
        this.tenXe = tenXe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }
}
