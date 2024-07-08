/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.clsNhaCungCap;
import POJO.clsTaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DangNhapDAO {
    public static boolean DangNhap(String user, String pass) {
        boolean kq = false;
        String sql = "SELECT TenTaiKhoan, MatKhau FROM TaiKhoan WHERE TenTaiKhoan = '" + user + "' AND MatKhau = '" + pass + "'";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        try {
            ResultSet resultSet = provider.excuteQuery(sql);
            if (resultSet.next()) {
                kq = true; // Tìm thấy tài khoản khớp với tên và mật khẩu
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý lỗi
        } finally {
            provider.Close(); // Đảm bảo đóng kết nối sau khi sử dụng
        }
        return kq;
    }
    public static String layTenNhanVien(String user, String pass) {
        String tenNhanVien = null;
        String sql = "SELECT NV.TenNhanVien " +
                     "FROM NhanVien NV " +
                     "INNER JOIN TaiKhoan TK ON NV.MaNhanVien = TK.MaNV " +
                     "WHERE TK.TenTaiKhoan = ? AND TK.MatKhau = ?";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();

        try {
            PreparedStatement preparedStatement = provider.getConn().prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tenNhanVien = resultSet.getString("TenNhanVien");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý lỗi
        } finally {
            provider.Close(); // Đóng kết nối
        }

        return tenNhanVien;
    }
    public static String layQuyenNhanVien(String user, String pass) {
        String quyenNhanVien = null;
        String sql = "SELECT TK.LoaiTaiKhoan " +
                     "FROM TaiKhoan TK " +
                     "WHERE TK.TenTaiKhoan = ? AND TK.MatKhau = ?";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();

        try {
            PreparedStatement preparedStatement = provider.getConn().prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                quyenNhanVien = resultSet.getString("LoaiTaiKhoan");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý lỗi
        } finally {
            provider.Close(); // Đóng kết nối
        }

        return quyenNhanVien;
    }
    public static boolean themTaiKhoan(clsTaiKhoan hh)
    {
        boolean kq = false;
        String sql = String.format("insert into TaiKhoan(TenTaiKhoan, MatKhau, LoaiTaiKhoan, MaNV) values('%s','%s', '%s','%d');", hh.getTenTaiKhoan(), hh.getMatKhau(), hh.getLoaiTaiKhoan(), hh.getMaNhanVien());
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
    public static clsTaiKhoan layThongTinTaiKhoan(String tenTaiKhoan) {
        clsTaiKhoan taiKhoan = null;
        String sql = "SELECT * FROM TaiKhoan WHERE TenTaiKhoan = ?";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        try {
            PreparedStatement preparedStatement = provider.getConn().prepareStatement(sql);
            preparedStatement.setString(1, tenTaiKhoan);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                taiKhoan = new clsTaiKhoan();
                taiKhoan.setTenTaiKhoan(resultSet.getString("TenTaiKhoan"));
                taiKhoan.setMatKhau(resultSet.getString("MatKhau"));
                taiKhoan.setLoaiTaiKhoan(resultSet.getString("LoaiTaiKhoan"));
                taiKhoan.setMaNhanVien(resultSet.getInt("MaNV"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Xử lý lỗi
        } finally {
            provider.Close(); // Đóng kết nối
        }
        return taiKhoan;
    }
    public static ArrayList<clsTaiKhoan> layDanhSachTaiKhoan()
    {
        ArrayList<clsTaiKhoan> dsNCC = new ArrayList<>();
        try
        {
            String sql = "select * from TaiKhoan";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsTaiKhoan hh = new clsTaiKhoan();
                hh.setTenTaiKhoan(resultSet.getString("TenTaiKhoan"));
                hh.setMatKhau(resultSet.getString("MatKhau"));
                hh.setLoaiTaiKhoan(resultSet.getString("LoaiTaiKhoan"));
                hh.setMaNhanVien(resultSet.getInt("MaNV"));
                dsNCC.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNCC;
    }
    public static ArrayList<clsTaiKhoan> timKiemTaiKhoanTheoTen(String key)
    {
        ArrayList<clsTaiKhoan> dsNCC = new ArrayList<>();
        try
        {
            String sql = "select * from TaiKhoan where TenTaiKhoan LIKE '%"+key+"%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsTaiKhoan hh = new clsTaiKhoan();
                hh.setTenTaiKhoan(resultSet.getString("TenTaiKhoan"));
                hh.setMatKhau(resultSet.getString("MatKhau"));
                hh.setLoaiTaiKhoan(resultSet.getString("LoaiTaiKhoan"));
                hh.setMaNhanVien(resultSet.getInt("MaNV"));
                dsNCC.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsNCC;
    }
    public static boolean ktNhanVien(clsTaiKhoan tk)
    {
        boolean kq = false;
        if (!daCoTaiKhoan(tk.getMaNhanVien())) 
        {
            JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!");
        }
        return kq;
    }
    public static boolean themTaiKhoanNV(clsTaiKhoan tk)
    {
        boolean kq = false;
        
        SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
        try
        {
            String sql = String.format("INSERT INTO TaiKhoan (TenTaiKhoan, MatKhau, LoaiTaiKhoan, MaNV) VALUES ('%s', '%s', '%s', %d)",tk.getTenTaiKhoan(), tk.getMatKhau(), tk.getLoaiTaiKhoan(), tk.getMaNhanVien());
            
            int n = provider.excuteUpdate(sql);
            if(n == 1)
            {
                kq = true;
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            provider.Close();
        }
        
        return kq;
    }
    public static boolean capNhatTaiKhoan(clsTaiKhoan tk)
    {
        boolean kq = false;
        String sql = String.format("UPDATE TaiKhoan SET TenTaiKhoan = '%s', MatKhau = '%s', LoaiTaiKhoan = '%s' WHERE MaNV = %d", tk.getTenTaiKhoan(), tk.getMatKhau(), tk.getLoaiTaiKhoan(), tk.getMaNhanVien());
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
    public static boolean xoaTaiKhoan(int ma)
    {
        boolean kq = false;
        String sql = String.format("delete from TaiKhoan where MaNhanVien = %d", ma);
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
    public static clsTaiKhoan laytaiKhoan(int ma)
    {
        clsTaiKhoan hh = null;
        try
        {
            String sql = "select * from TaiKhoan where MaNV ="+ma;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                hh = new clsTaiKhoan();
                hh.setTenTaiKhoan(resultSet.getString("TenTaiKhoan"));
                hh.setMatKhau(resultSet.getString("MatKhau"));
                hh.setLoaiTaiKhoan(resultSet.getString("LoaiTaiKhoan"));
                hh.setMaNhanVien(resultSet.getInt("MaNV"));
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return hh;
    }
    public static boolean daCoTaiKhoan(int maNhanVien) {
        boolean daCo = false;
        String sql = "SELECT COUNT(*) AS count FROM TaiKhoan WHERE MaNV = ?";
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.Open();
        try {
            PreparedStatement preparedStatement = provider.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, maNhanVien);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                if (count > 0) {
                    daCo = true; // Nhân viên đã có tài khoản
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Xử lý lỗi SQL ở đây
            // Ví dụ: hiển thị thông báo lỗi cho người dùng
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi kiểm tra tài khoản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {
            provider.Close();
        }
        return daCo;
    }

}
