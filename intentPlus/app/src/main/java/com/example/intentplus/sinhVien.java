package com.example.intentplus;

import java.io.Serializable;

public class sinhVien  implements Serializable {
    private String hoTen;
    private int ns;
    public sinhVien(){

    }

    public sinhVien(String hoTen, int ns) {
        this.hoTen = hoTen;
        this.ns = ns;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }
}
