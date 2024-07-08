/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.clsNhanVien;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVienDAO {
    public static ArrayList<clsNhanVien> layDanhSachNhanVien()
    {
        ArrayList<clsNhanVien> dsNhanVien = new ArrayList<>();
        try
        {
            String sql = "select * from NhanVien";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsNhanVien nv = new clsNhanVien();
                nv.setMaNV(resultSet.getInt("MaNhanVien"));
                nv.setTenNV(resultSet.getString("TenNhanVien"));
                nv.setNgaySinh(resultSet.getDate("NgaySinh"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setSoDT(resultSet.getString("SoDienThoai"));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setLuong(resultSet.getInt("Luong"));
                dsNhanVien.add(nv);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNhanVien;
    }
    public static ArrayList<clsNhanVien> timKiemNhanVienTheoTen(String key)
    {
        ArrayList<clsNhanVien> dsNhanVien = new ArrayList<>();
        try
        {
            String sql = "select * from NhanVien where TenNhanVien LIKE '%"+key+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsNhanVien nv = new clsNhanVien();
                nv.setMaNV(resultSet.getInt("MaNhanVien"));
                nv.setTenNV(resultSet.getString("TenNhanVien"));
                nv.setNgaySinh(resultSet.getDate("NgaySinh"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setSoDT(resultSet.getString("SoDienThoai"));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setLuong(resultSet.getInt("Luong"));
                dsNhanVien.add(nv);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNhanVien;
    }
    public static boolean themNhanVien(clsNhanVien nv)
    {
        boolean kq = false;
        // Định dạng ngày trước khi thêm vào câu lệnh SQL
        String ngaySinh = dinhDangNgay(nv.getNgaySinh());
        String sql = String.format("INSERT INTO NhanVien (MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, SoDienThoai, DiaChi, Luong) VALUES ('%d', N'%s', '%s', N'%s', '%s', N'%s', '%d')", nv.getMaNV(), nv.getTenNV(), ngaySinh, nv.getGioiTinh(), nv.getSoDT(), nv.getDiaChi(), nv.getLuong());
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        int n = provider.excuteUpdate(sql);
        if(n == 1)
        {
            kq = true;
        }
        provider.Close();
        return kq;
    }
    public static boolean capNhatNhanVien(clsNhanVien nv)
    {
        boolean kq = false;
        String ngaySinh = dinhDangNgay(nv.getNgaySinh());
        String sql = String.format("UPDATE NhanVien SET TenNhanVien = N'%s', NgaySinh = CAST('%s' AS DATE), GioiTinh = N'%s', SoDienThoai = '%s', DiaChi = N'%s', Luong = %d WHERE MaNhanVien = %d", nv.getTenNV(), ngaySinh, nv.getGioiTinh(), nv.getSoDT(), nv.getDiaChi(), nv.getLuong(), nv.getMaNV());
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        int n = provider.excuteUpdate(sql);
        if(n == 1)
        {
            kq = true;
        }
        provider.Close();
        return kq;
    }
    public static boolean xoaNhanVien(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete from NhanVien where MaNhanVien = %d", ma);
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        int n = provider.excuteUpdate(sql);
        if(n == 1)
        {
            kq = true;
        }
        provider.Close();
        return kq;
    }
    public static clsNhanVien layNhanVien(int ma)
    {
        clsNhanVien nv = null;
        try
        {
            String sql = "select * from NhanVien where MaNhanVien ="+ma;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                nv = new clsNhanVien();
                nv.setMaNV(resultSet.getInt("MaNhanVien"));
                nv.setTenNV(resultSet.getString("TenNhanVien"));
                nv.setNgaySinh(resultSet.getDate("NgaySinh"));
                nv.setGioiTinh(resultSet.getString("GioiTinh"));
                nv.setSoDT(resultSet.getString("SoDienThoai"));
                nv.setDiaChi(resultSet.getString("DiaChi"));
                nv.setLuong(resultSet.getInt("Luong"));
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return nv;
    }
    public static String dinhDangNgay(Date ngay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(ngay);
    }
}
