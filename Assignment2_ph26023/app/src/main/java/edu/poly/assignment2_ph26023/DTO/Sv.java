package edu.poly.assignment2_ph26023.DTO;

public class Sv {
    private int stt;
    private String maLop;
    private String tenSv;
    private String ngaySinh;
    private String sdt;
    private String gioiTinh;

    public Sv() {
    }

    public Sv(int stt, String maLop, String tenSv, String ngaySinh, String sdt, String gioiTinh) {
        this.stt = stt;
        this.maLop = maLop;
        this.tenSv = tenSv;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
