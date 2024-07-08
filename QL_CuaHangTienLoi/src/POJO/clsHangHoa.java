/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.text.DecimalFormat;

/**
 *
 * @author Admin
 */
public class clsHangHoa {
    private int maHang;
    private int maNCC;
    private String tenHangHoa;
    private int maLoaiHang;
    private String donViTinh;
    private int donGia;
    private int soLuongTon;
    private int giaNhap;
    private String hinhAnh;

    public clsHangHoa(int maHang, int maNCC, String tenHangHoa, int maLoaiHang, String donViTinh, int donGia, String hinhAnh) {
        this.maHang = maHang;
        this.maNCC = maNCC;
        this.tenHangHoa = tenHangHoa;
        this.maLoaiHang = maLoaiHang;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
    }

    public clsHangHoa(int maHang, int maNCC, String tenHangHoa, int maLoaiHang, String donViTinh, int donGia, int soLuongTon, int giaNhap, String hinhAnh) {
        this.maHang = maHang;
        this.maNCC = maNCC;
        this.tenHangHoa = tenHangHoa;
        this.maLoaiHang = maLoaiHang;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.hinhAnh = hinhAnh;
    }

    public clsHangHoa(int maNCC, String tenHangHoa, int maLoaiHang, String donViTinh, int donGia, String hinhAnh) {
        this.maNCC = maNCC;
        this.tenHangHoa = tenHangHoa;
        this.maLoaiHang = maLoaiHang;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
    }
    


    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }
    
    

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public int getMaLoaiHang() {
        return maLoaiHang;
    }

    public void setMaLoaiHang(int maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(int giaNhap) {
        this.giaNhap = giaNhap;
    }

    public clsHangHoa() {
    }

    

    public clsHangHoa(String tenHangHoa, int maLoaiHang, String donViTinh, int donGia, int soLuongTon, int giaNhap, String hinhAnh) {
        this.tenHangHoa = tenHangHoa;
        this.maLoaiHang = maLoaiHang;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.hinhAnh = hinhAnh;
    }
    
}
