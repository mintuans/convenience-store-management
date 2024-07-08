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
public class clsNhapHang {
    
    public clsNhapHang(int maNhap, int maNV, int maLoai, Date ngayNhap, int tongTien) {
        this.maNhap = maNhap;
        this.maNV = maNV;
        this.maLoai = maLoai;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }

    public clsNhapHang() {
    }

    public int getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(int maNhap) {
        this.maNhap = maNhap;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    private int maNhap;
    private int maNV;
    private int maLoai;
    private Date ngayNhap;
    private int tongTien;
}
