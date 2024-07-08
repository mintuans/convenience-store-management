/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class clsChiTietNhapHang {
     private int maNhap;
     private int maHang;
     private int soLuong;
     private int donGia;

    public clsChiTietNhapHang(int maNhap, int maHang, int soLuong, int donGia) {
        this.maNhap = maNhap;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public clsChiTietNhapHang() {
    }

    public int getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(int maNhap) {
        this.maNhap = maNhap;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
     
}
