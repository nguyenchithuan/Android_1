package edu.poly.baitestamsignment.DTO;

public class Sv {
    private int id;
    private String hoTen;
    private String sdt;
    private String maLop;

    public Sv() {
    }

    public Sv(int id, String hoTen, String sdt, String maLop) {
        this.id = id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.maLop = maLop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}
