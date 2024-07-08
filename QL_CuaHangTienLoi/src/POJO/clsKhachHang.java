/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class clsKhachHang {
    private int maKH;
    private String tenKH;
    private String soDT;

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public clsKhachHang(String tenKH, String soDT) {
        this.tenKH = tenKH;
        this.soDT = soDT;
    }

    public clsKhachHang() {
    }

    public clsKhachHang(int maKH, String tenKH, String soDT) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.soDT = soDT;
    }
    
}
