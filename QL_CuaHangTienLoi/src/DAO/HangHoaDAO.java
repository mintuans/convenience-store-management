/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import POJO.clsHangHoa;
import POJO.clsLoaiHang;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class HangHoaDAO {
    
    public static ArrayList<clsLoaiHang> layLoaiHang()
    {
        ArrayList<clsLoaiHang> dsHangHoa = new ArrayList<>();
        try
        {
            String sql = "select * from LoaiHang";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsLoaiHang hh = new clsLoaiHang();
                hh.setMa(resultSet.getInt("MaLoaiHang"));
                hh.setTen(resultSet.getString("TenLoaiHang"));
                dsHangHoa.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsHangHoa;
    }
    public static ArrayList<clsLoaiHang> layDanhSachLoaiHang()
    {
        ArrayList<clsLoaiHang> dsLoaiHang = new ArrayList<>();
        try
        {
            String sql = "select * from LoaiHang";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsLoaiHang hh = new clsLoaiHang();
                hh.setMa(resultSet.getInt("MaLoaiHang"));
                hh.setTen(resultSet.getString("TenLoaiHang"));
                dsLoaiHang.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsLoaiHang;
    }
    public static boolean themLoaiHangHoa(clsLoaiHang hh)
    {
        boolean kq = false;
        String sql = String.format("insert into LoaiHang(TenLoaiHang) values(N'%s');", hh.getTen());
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
    public static boolean xoaLoaiHangHoa(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete from LoaiHang where MaLoaiHang = %d", ma);
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
    public static ArrayList<clsHangHoa> layDanhSachHangHoa()
    {
        ArrayList<clsHangHoa> dsHangHoa = new ArrayList<>();
        try
        {
            String sql = "select * from HangHoa";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsHangHoa hh = new clsHangHoa();
                hh.setMaHang(resultSet.getInt("MaHang"));
                hh.setMaNCC(resultSet.getInt("MaNhaCungCap"));
                hh.setTenHangHoa(resultSet.getString("TenHang"));
                hh.setMaLoaiHang(resultSet.getInt("MaLoaiHang"));
                hh.setDonViTinh(resultSet.getString("DonViTinh"));
                hh.setDonGia(resultSet.getInt("DonGia"));
                hh.setSoLuongTon(resultSet.getInt("SoLuongTonKho"));
                hh.setGiaNhap(resultSet.getInt("GiaNhap"));
                hh.setHinhAnh(resultSet.getString("HinhAnh"));
                dsHangHoa.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsHangHoa;
    }
    public static ArrayList<clsHangHoa> timKiemHangHoaTheoTen(String key)
    {
        ArrayList<clsHangHoa> dsHangHoa = new ArrayList<>();
        try
        {
            // Corrected SQL query
            String sql = "SELECT * FROM HangHoa WHERE TenHang LIKE N'%" + key + "%';";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsHangHoa hh = new clsHangHoa();
                hh.setMaHang(resultSet.getInt("MaHang"));
                hh.setMaNCC(resultSet.getInt("MaNhaCungCap"));
                hh.setTenHangHoa(resultSet.getString("TenHang"));
                hh.setMaLoaiHang(resultSet.getInt("MaLoaiHang"));
                hh.setDonViTinh(resultSet.getString("DonViTinh"));
                hh.setDonGia(resultSet.getInt("DonGia"));
                hh.setSoLuongTon(resultSet.getInt("SoLuongTonKho"));
                hh.setGiaNhap(resultSet.getInt("GiaNhap"));
                hh.setHinhAnh(resultSet.getString("HinhAnh"));
                dsHangHoa.add(hh);
            }
            provider.Close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsHangHoa;
    }

    public static boolean themHangHoa(clsHangHoa hh)
    {
        boolean kq = false;
        String sql = String.format("insert into HangHoa(MaNhaCungCap, TenHang, MaLoaiHang, DonViTinh, DonGia, HinhAnh) values('%d',N'%s','%d', N'%s', '%d', '%s');",hh.getMaNCC(), hh.getTenHangHoa(), hh.getMaLoaiHang(), hh.getDonViTinh(), hh.getDonGia(), hh.getHinhAnh());
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
    public static boolean capNhatHangHoa(clsHangHoa hh) {
        boolean kq = false;
        String sql = String.format(
            "UPDATE HangHoa SET MaNhaCungCap = %d, TenHang = N'%s', MaLoaiHang = %d, DonViTinh = N'%s', DonGia = %d, SoLuongTonKho = %d, GiaNhap = %d, HinhAnh = '%s' WHERE MaHang = %d",
            hh.getMaNCC(),
            hh.getTenHangHoa(), 
            hh.getMaLoaiHang(), 
            hh.getDonViTinh(), 
            hh.getDonGia(), 
            hh.getSoLuongTon(), 
            hh.getGiaNhap(), 
            hh.getHinhAnh(), 
            hh.getMaHang()
        );
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        int n = provider.excuteUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        provider.Close();
        return kq;
    }

    public static boolean xoaHangHoa(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete from HangHoa where MaHang = %d", ma);
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
    public static clsHangHoa layHangHoa(int ma)
    {
        clsHangHoa hh = null;
        try
        {
            String sql = "select * from HangHoa where MaHang ="+ma;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                hh = new clsHangHoa();
                hh.setMaHang(resultSet.getInt("MaHang"));
                hh.setMaNCC(resultSet.getInt("MaNhaCungCap"));
                hh.setTenHangHoa(resultSet.getString("TenHang"));
                hh.setMaLoaiHang(resultSet.getInt("MaLoaiHang"));
                hh.setDonViTinh(resultSet.getString("DonViTinh"));
                hh.setDonGia(resultSet.getInt("DonGia"));
                hh.setSoLuongTon(resultSet.getInt("SoLuongTonKho"));
                hh.setGiaNhap(resultSet.getInt("GiaNhap"));
                hh.setHinhAnh(resultSet.getString("HinhAnh"));
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return hh;
    }
    public static clsLoaiHang layLoaiHangTheoTen(String tenLoaiHang) {
        ArrayList<clsLoaiHang> danhSachLoaiHang = layLoaiHang();

        for (clsLoaiHang loaiHang : danhSachLoaiHang) {
            if (loaiHang.getTen().equalsIgnoreCase(tenLoaiHang)) {
                return loaiHang;
            }
        }

        return null; 
    }
}
