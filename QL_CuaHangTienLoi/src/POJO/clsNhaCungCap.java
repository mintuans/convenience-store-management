/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class clsNhaCungCap {
    private int maNCC;
    private String tenNCC;
    private String sDT;
    private String diaChi;

    public clsNhaCungCap(String tenNCC, String sDT, String diaChi) {
        this.tenNCC = tenNCC;
        this.sDT = sDT;
        this.diaChi = diaChi;
    }

    public clsNhaCungCap(int maNCC, String tenNCC) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
    }

    public clsNhaCungCap(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public clsNhaCungCap(int maNCC, String tenNCC, String sDT, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sDT = sDT;
        this.diaChi = diaChi;
    }

    public clsNhaCungCap() {
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    @Override
    public String toString() {
        return tenNCC;
    }
}
