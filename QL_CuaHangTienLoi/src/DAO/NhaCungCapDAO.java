/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.clsNhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhaCungCapDAO {
    public static ArrayList<clsNhaCungCap> layNhaCungCap()
    {
        ArrayList<clsNhaCungCap> dsNCC = new ArrayList<>();
        try
        {
            String sql = "select * from NhaCungCap";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsNhaCungCap hh = new clsNhaCungCap();
                hh.setMaNCC(resultSet.getInt("MaNhaCungCap"));
                hh.setTenNCC(resultSet.getString("TenNhaCungCap"));
                dsNCC.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNCC;
    }
    public static ArrayList<clsNhaCungCap> layDanhSachNhaCungCap()
    {
        ArrayList<clsNhaCungCap> dsNCC = new ArrayList<>();
        try
        {
            String sql = "select * from NhaCungCap";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsNhaCungCap hh = new clsNhaCungCap();
                hh.setMaNCC(resultSet.getInt("MaNhaCungCap"));
                hh.setTenNCC(resultSet.getString("TenNhaCungCap"));
                hh.setsDT(resultSet.getString("SoDienThoai"));
                hh.setDiaChi(resultSet.getString("DiaChi"));
                dsNCC.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNCC;
    }
    public static ArrayList<clsNhaCungCap> timKiemNCCTheoTen(String key)
    {
        ArrayList<clsNhaCungCap> dsNCC = new ArrayList<>();
        try
        {
            String sql = "select * from NhaCungCap where TenNhaCungCap LIKE '%"+key+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsNhaCungCap hh = new clsNhaCungCap();
                hh.setMaNCC(resultSet.getInt("MaNhaCungCap"));
                hh.setTenNCC(resultSet.getString("TenNhaCungCap"));
                hh.setsDT(resultSet.getString("SoDienThoai"));
                hh.setDiaChi(resultSet.getString("DiaChi"));
                dsNCC.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNCC;
    }
    public static boolean themNhaCungCap(clsNhaCungCap ncc)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO NhaCungCap (TenNhaCungCap, SoDienThoai, DiaChi) VALUES (N'%s', '%s', N'%s')",ncc.getTenNCC(), ncc.getsDT(), ncc.getDiaChi());
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
    public static boolean capNhatNhaCungCap(clsNhaCungCap ncc)
    {
        boolean kq = false;
        String sql = String.format("UPDATE NhaCungCap SET TenNhaCungCap = N'%s', SoDienThoai = '%s', DiaChi = N'%s' WHERE MaNhaCungCap = %d", ncc.getTenNCC(), ncc.getsDT(), ncc.getDiaChi(), ncc.getMaNCC());
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
    public static boolean xoaNhaCungCap(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete from NhaCungCap where MaNhaCungCap = %d", ma);
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
    public static clsNhaCungCap layNhaCungCap(int ma)
    {
        clsNhaCungCap ncc = null;
        try
        {
            String sql = "select * from NhaCungCap where MaNhaCungCap ="+ma;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                ncc = new clsNhaCungCap();
                ncc.setMaNCC(resultSet.getInt("MaNhaCungCap"));
                ncc.setTenNCC(resultSet.getString("TenNhaCungCap"));
                ncc.setsDT(resultSet.getString("SoDienThoai"));
                ncc.setDiaChi(resultSet.getString("DiaChi"));
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return ncc;
    }
}
