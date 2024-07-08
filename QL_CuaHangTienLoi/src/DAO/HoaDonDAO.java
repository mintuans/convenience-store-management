/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.clsChiTietHoaDon;
import POJO.clsHienThiChiTiet;
import POJO.clsHoaDon;
import POJO.clsThongKe;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.CallableStatement;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonDAO {
    public static clsHoaDon layThongTinHoaDon(int maHoaDon) {
        clsHoaDon hoaDon = null;
        try {
            String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = " + maHoaDon;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next()) {
                hoaDon = new clsHoaDon();
                hoaDon.setMaHD(resultSet.getInt("MaHoaDon"));
                hoaDon.setNgayMua(resultSet.getDate("NgayLap"));
                hoaDon.setTongTien(resultSet.getInt("TongTien"));
                hoaDon.setMaKH(resultSet.getInt("MaKhachHang"));
            }
            provider.Close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return hoaDon;
    }
    public static boolean themHoaDon(clsHoaDon hoaDon) {
        boolean success = false;
        try {
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            String ngaymua = dinhDangNgay(hoaDon.getNgayMua());
            String sql = String.format("INSERT INTO HoaDon (NgayMua, TongTien, MaKhachHang) VALUES ('%s', %d, %d)",
                                       ngaymua, hoaDon.getTongTien(), hoaDon.getMaKH());
            
            Statement statement = provider.getConn().createStatement();
            int rowsAffected = statement.executeUpdate(sql);
            
            if (rowsAffected > 0) {
                success = true;
            }
            
            provider.Close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }
    public static int layMaHoaDonMoi() {
        int maHoaDonMoi = -1; 
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            provider.Open();
            
            String sql = "SELECT MAX(MaHoaDon) AS MaHoaDonMoi FROM HoaDon";
            
            PreparedStatement ps = provider.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                maHoaDonMoi = rs.getInt("MaHoaDonMoi");
            }
            
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            provider.Close();
        }
        
        return maHoaDonMoi;
    }
    
    public static boolean themChiTietHoaDon(clsChiTietHoaDon chiTietHoaDon) {
        boolean isSuccess = false;
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            provider.Open();

            String sql = "INSERT INTO ChiTietHoaDon (MaHoaDon, MaHang, SoLuong, DonGia) VALUES (?, ?, ?, ?)";

            // Chuẩn bị và thực thi truy vấn
            PreparedStatement ps = provider.getConn().prepareStatement(sql);
            ps.setInt(1, chiTietHoaDon.getMaHD());
            ps.setInt(2, chiTietHoaDon.getMaHang());
            ps.setInt(3, chiTietHoaDon.getSoLuong());
            ps.setFloat(4, chiTietHoaDon.getDonGia());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
                // Cập nhật số lượng tồn của hàng hóa
                capNhatSoLuongTonHangHoa(chiTietHoaDon.getMaHang(), chiTietHoaDon.getSoLuong());
            }

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            provider.Close();
        }

        return isSuccess;
    }
    public static ArrayList<clsHoaDon> layDanhSachHoaDon() {
        ArrayList<clsHoaDon> danhSachHoaDon = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            provider.Open();
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement ps = provider.getConn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int maHoaDon = rs.getInt("MaHoaDon");
                Date ngayMua = rs.getDate("NgayMua");
                int maNhanVien = rs.getInt("MaNhanVien");
                int tongTien = rs.getInt("TongTien");
                int maKH = rs.getInt("MaKhachHang");
                
                clsHoaDon hoaDon = new clsHoaDon(maHoaDon, ngayMua, maNhanVien, tongTien, maKH);
                
                danhSachHoaDon.add(hoaDon);
            }
            rs.close();
            ps.close();
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return danhSachHoaDon;
    }
    public static ArrayList<clsChiTietHoaDon> layDanhSachChiTietHoaDon(int maHoaDon) {
        ArrayList<clsChiTietHoaDon> danhSachChiTiet = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            provider.Open();
            
            String sql = "SELECT MaHang, SoLuong, DonGia FROM ChiTietHoaDon WHERE MaHoaDon = ?";
            
            PreparedStatement ps = provider.getConn().prepareStatement(sql);
            ps.setInt(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                clsChiTietHoaDon chiTiet = new clsChiTietHoaDon();
                chiTiet.setMaHang(rs.getInt("MaHang"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGia(rs.getInt("DonGia"));
                danhSachChiTiet.add(chiTiet);
            }
            rs.close();
            ps.close();
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return danhSachChiTiet;
    }
    private static void capNhatSoLuongTonHangHoa(int maHangHoa, int soLuongBan) {
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            provider.Open();
            String sql = "UPDATE HangHoa SET SoLuongTonKho = SoLuongTonKho - ? WHERE MaHang = ?";
            
            PreparedStatement ps = provider.getConn().prepareStatement(sql);
            ps.setInt(1, soLuongBan);
            ps.setInt(2, maHangHoa);
            
            ps.executeUpdate();
            ps.close();
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int demSoLuongHoaDonTrongNgay(Date ngay) {
        int soLuong = 0;
        SQLServerDataProvider provider = new SQLServerDataProvider();
        String query = "SELECT COUNT(*) AS SoLuong FROM HoaDon WHERE NgayMua = ?";
        try (PreparedStatement stmt = provider.getConn().prepareStatement(query)) {
            stmt.setDate(1, (java.sql.Date) ngay);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                soLuong = rs.getInt("SoLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soLuong;
    }
    public static ArrayList<clsThongKe> thongKeHoaDonTheoNgay(Date ngayMua) {
        ArrayList<clsThongKe> dsHoaDon = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider();

        try {
            provider.Open();
            String ngayFormatted = dinhDangNgay(ngayMua);
            String sql = "{call sp_ThongKeHoaDonTheoNgay(?)}";
            
            CallableStatement cstmt = provider.getConn().prepareCall(sql);
            cstmt.setDate(1, java.sql.Date.valueOf(ngayFormatted));

            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int maHoaDon = rs.getInt("MaHoaDon");
                Date ngayLap = rs.getDate("NgayMua");
                String nhanVien = rs.getString("TenNhanVien");
                String khachHang = rs.getString("TenKhachHang");
                int tongTien = rs.getInt("TongTien");

                clsThongKe thongke = new clsThongKe(maHoaDon, ngayLap, nhanVien,khachHang, tongTien);
                dsHoaDon.add(thongke);
            }

            rs.close();
            cstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            provider.Close();
        }

        return dsHoaDon;
    }
    public static ArrayList<clsHienThiChiTiet> layChiTietHoaDon(int maHoaDon) {
        ArrayList<clsHienThiChiTiet> chiTietHoaDonList = new ArrayList<>();
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            provider.Open();
            String sql = "{ call sp_ChiTietHoaDon(?) }";
            CallableStatement stmt = provider.getConn().prepareCall(sql);
            stmt.setInt(1, maHoaDon);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clsHienThiChiTiet chiTiet = new clsHienThiChiTiet();
                chiTiet.setMaHoaDon(rs.getInt("MaHoaDon"));
                chiTiet.setTenHang(rs.getString("TenHang"));
                chiTiet.setSoLuong(rs.getInt("SoLuong"));
                chiTiet.setDonGia(rs.getInt("DonGia"));
                chiTiet.setThanhTien(rs.getInt("ThanhTien"));
                chiTietHoaDonList.add(chiTiet);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            provider.Close();
        }
        return chiTietHoaDonList;
    }
   
    public static String dinhDangNgay(Date ngay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(ngay);
    }
}
