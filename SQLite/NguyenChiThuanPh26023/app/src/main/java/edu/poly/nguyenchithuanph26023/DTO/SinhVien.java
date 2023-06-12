package edu.poly.nguyenchithuanph26023.DTO;

public class SinhVien {
    private int id;
    private String hoTen;
    private String sodt;
    private String ghiChu;

    public SinhVien() {
    }

    public SinhVien(int id, String hoTen, String sodt, String ghiChu) {
        this.id = id;
        this.hoTen = hoTen;
        this.sodt = sodt;
        this.ghiChu = ghiChu;
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

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
