package edu.poly.assignment2_ph26023.DTO;

public class Lop {
    private int stt;
    private String maLop;
    private String tenLop;

    public Lop() {
    }

    public Lop(int stt, String maLop, String tenLop) {
        this.stt = stt;
        this.maLop = maLop;
        this.tenLop = tenLop;
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

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
}
