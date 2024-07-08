/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class clsHoaDon {
    private int maHD;
    private Date ngayMua;
    private int maNV;
    private int tongTien;
    private int maKH;

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public clsHoaDon(Date ngayMua, int maNV, int tongTien, int maKH) {
        this.ngayMua = ngayMua;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.maKH = maKH;
    }

    public clsHoaDon(int maHD, Date ngayMua, int maNV, int tongTien, int maKH) {
        this.maHD = maHD;
        this.ngayMua = ngayMua;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.maKH = maKH;
    }
    
    public clsHoaDon() {
    }
}
