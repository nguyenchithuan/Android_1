package edu.poly.baitest1.DTO;

public class VatTu {
    private String tenVatTu;
    private double giaTien;

    public VatTu() {
    }

    public VatTu(String tenVatTu, double giaTien) {
        this.tenVatTu = tenVatTu;
        this.giaTien = giaTien;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String vatTu) {
        this.tenVatTu = vatTu;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
}
