/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Admin
 */
public class clsLoaiHang {
    private int ma;
    private String ten;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public clsLoaiHang(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public clsLoaiHang(String ten) {
        this.ten = ten;
    }

    public clsLoaiHang() {
    }

    @Override
    public String toString() {
        return ten;
    }
}