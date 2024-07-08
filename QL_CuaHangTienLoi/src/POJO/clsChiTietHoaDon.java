/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class clsChiTietHoaDon {
    private int maHD;
    private int maHang;
    private int soLuong;
    private int donGia;

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
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

    public clsChiTietHoaDon(int maHD, int maHang, int soLuong, int donGia) {
        this.maHD = maHD;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }


    public clsChiTietHoaDon() {
    }
    
}
