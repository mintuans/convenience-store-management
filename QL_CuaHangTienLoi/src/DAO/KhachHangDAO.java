/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.clsKhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class KhachHangDAO {
    public static ArrayList<clsKhachHang> layDanhSachKhachHang()
    {
        ArrayList<clsKhachHang> dsNCC = new ArrayList<>();
        try
        {
            String sql = "select * from KhachHang";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsKhachHang hh = new clsKhachHang();
                hh.setMaKH(resultSet.getInt("MaKhachHang"));
                hh.setTenKH(resultSet.getString("TenKhachHang"));
                hh.setSoDT(resultSet.getString("SoDienThoai"));
                dsNCC.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNCC;
    }
    public static ArrayList<clsKhachHang> timKiemKhachHangTheoTen(String key)
    {
        ArrayList<clsKhachHang> dsNCC = new ArrayList<>();
        try
        {
            String sql = "select * from KhachHang where TenKhachHang LIKE '%"+key+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsKhachHang hh = new clsKhachHang();
                hh.setMaKH(resultSet.getInt("MaKhachHang"));
                hh.setTenKH(resultSet.getString("TenKhachHang"));
                hh.setSoDT(resultSet.getString("SoDienThoai"));
                dsNCC.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNCC;
    }
    public static boolean themKhachHang(clsKhachHang kh)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO KhachHang (TenKhachHang, SoDienThoai) VALUES (N'%s', '%s')",kh.getTenKH(), kh.getSoDT());
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
    public static boolean capNhatKhachHang(clsKhachHang kh)
    {
        boolean kq = false;
        String sql = String.format("UPDATE KhachHang SET TenKhachHang = N'%s', SoDienThoai = '%s' WHERE MaKhachHang = %d", kh.getTenKH(), kh.getSoDT(), kh.getMaKH());
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
    public static boolean xoaKhachHang(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete from KhachHang where MaKhachHang = %d", ma);
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
    public static clsKhachHang layKhachHang(int ma)
    {
        clsKhachHang kh = null;
        try
        {
            String sql = "select * from KhachHang where MaKhachHang ="+ma;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                kh = new clsKhachHang();
                kh.setMaKH(resultSet.getInt("MaKhachHang"));
                kh.setTenKH(resultSet.getString("TenKhachHang"));
                kh.setSoDT(resultSet.getString("SoDienThoai"));
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return kh;
    }
    public static clsKhachHang timKhachHangTheoSoDT(String soDT) {
        clsKhachHang kh = null;
        try {
            String sql = "select * from KhachHang where SoDienThoai = '" + soDT + "'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            if (resultSet.next()) {
                kh = new clsKhachHang();
                kh.setMaKH(resultSet.getInt("MaKhachHang"));
                kh.setTenKH(resultSet.getString("TenKhachHang"));
                kh.setSoDT(resultSet.getString("SoDienThoai"));
            }
            provider.Close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return kh;
    }
    
}
