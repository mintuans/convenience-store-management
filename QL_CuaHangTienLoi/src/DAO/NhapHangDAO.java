/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import POJO.clsChiTietNhapHang;
import POJO.clsHangHoa;
import POJO.clsNhapHang;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhapHangDAO {
    public static ArrayList<clsHangHoa> layDanhSachHangHoa()
    {
        ArrayList<clsHangHoa> dsHangHoa = new ArrayList<>();
        try
        {
            String sql = "select MaHang,TenHang,MaLoaiHang,DonViTinh,SoLuongTonKho from HangHoa";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            ResultSet resultSet = provider.excuteQuery(sql);
            while(resultSet.next())
            {
                clsHangHoa hh = new clsHangHoa();
                hh.setMaHang(resultSet.getInt("MaHang"));
                hh.setTenHangHoa(resultSet.getString("TenHang"));
                hh.setMaLoaiHang(resultSet.getInt("MaLoaiHang"));
                hh.setDonViTinh(resultSet.getString("DonViTinh"));
                hh.setSoLuongTon(resultSet.getInt("SoLuongTonKho"));
                dsHangHoa.add(hh);
            }
            provider.Close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return dsHangHoa;
    }
    public static ArrayList<clsHangHoa> timKiemHangHoaTheoSoLuongTon(int soLuongTon) {
        ArrayList<clsHangHoa> dsHangHoa = new ArrayList<>();
        try {
            // Tạo kết nối đến cơ sở dữ liệu
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();

            // Tạo truy vấn SQL để tìm kiếm hàng hóa theo số lượng tồn
            String sql = "SELECT * FROM HangHoa WHERE SoLuongTonKho < ?";

            // Chuẩn bị và thực thi truy vấn
            PreparedStatement ps = provider.getConn().prepareStatement(sql);
            ps.setInt(1, soLuongTon);

            ResultSet resultSet = ps.executeQuery();

            // Xử lý kết quả trả về
            while (resultSet.next()) {
                clsHangHoa hh = new clsHangHoa();
                hh.setMaHang(resultSet.getInt("MaHang"));
                hh.setTenHangHoa(resultSet.getString("TenHang"));
                hh.setMaLoaiHang(resultSet.getInt("MaLoaiHang"));
                hh.setDonViTinh(resultSet.getString("DonViTinh"));
                hh.setSoLuongTon(resultSet.getInt("SoLuongTonKho"));
                dsHangHoa.add(hh);
            }

            // Đóng kết nối và giải phóng tài nguyên
            resultSet.close();
            ps.close();
            provider.Close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsHangHoa;
    }
    public static boolean themHoaDonNhap(clsNhapHang hoaDonNhap) {
        boolean success = false;
        try {
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();
            String ngayNhap = dinhDangNgay(hoaDonNhap.getNgayNhap());
            String sql = String.format("INSERT INTO NhapHang (MaNhanVien, MaLoaiHang, NgayNhapHang, TongTienNhapHang) VALUES (%d, %d, '%s', %d)",
                                       hoaDonNhap.getMaNV(), hoaDonNhap.getMaNV(), ngayNhap, hoaDonNhap.getTongTien());

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

    public static boolean themChiTietNhapHang(clsChiTietNhapHang chiTietNhapHang) {
        boolean isSuccess = false; // Biến để kiểm tra xem việc thêm chi tiết nhập hàng thành công hay không
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            // Mở kết nối đến cơ sở dữ liệu
            provider.Open();

            // Tạo truy vấn SQL để thêm chi tiết nhập hàng
            String sql = "INSERT INTO ChiTietNhapHang (MaNhapHang, MaHang, SoLuong, DonGia) VALUES (?, ?, ?, ?)";

            // Chuẩn bị và thực thi truy vấn
            PreparedStatement ps = provider.getConn().prepareStatement(sql);
            ps.setInt(1, chiTietNhapHang.getMaNhap());
            ps.setInt(2, chiTietNhapHang.getMaHang());
            ps.setInt(3, chiTietNhapHang.getSoLuong());
            ps.setFloat(4, chiTietNhapHang.getDonGia());

            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem có hàng bị ảnh hưởng (đã thêm) không
            if (rowsAffected > 0) {
                isSuccess = true; // Nếu có, đặt biến isSuccess thành true
            }

            // Đóng kết nối
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            provider.Close();
        }

        return isSuccess;
    }
    public static int layMaNhapHangMoi() {
        int maNhapHangMoi = -1; // Giá trị mặc định nếu không tìm thấy mã nhập hàng mới
        SQLServerDataProvider provider = new SQLServerDataProvider();
        try {
            
            provider.Open();

            // Tạo truy vấn SQL để lấy mã nhập hàng mới nhất
            String sql = "SELECT MAX(MaNhapHang) AS MaNhapHangMoi FROM NhapHang";

            // Thực hiện truy vấn
            Statement statement = provider.getConn().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            // Xử lý kết quả trả về
            if (rs.next()) {
                maNhapHangMoi = rs.getInt("MaNhapHangMoi");
            }

            // Đóng kết nối và giải phóng tài nguyên
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            provider.Close();
        }

        return maNhapHangMoi;
    }
    public static boolean capNhatSoLuongTonVaGiaNhapHangHoa(int maHangHoa, int soLuongNhap, float giaNhap) {
        boolean isSuccess = false;

        try {
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.Open();

            // Lấy số lượng tồn hiện tại của hàng hóa
            String sqlSelect = "SELECT SoLuongTonKho FROM HangHoa WHERE MaHang = ?";
            PreparedStatement psSelect = provider.getConn().prepareStatement(sqlSelect);
            psSelect.setInt(1, maHangHoa);
            ResultSet rs = psSelect.executeQuery();

            int soLuongTonHienTai = 0;
            if (rs.next()) {
                soLuongTonHienTai = rs.getInt("SoLuongTonKho");
            }

            // Tính toán số lượng tồn mới
            int soLuongTonMoi = soLuongTonHienTai + soLuongNhap;

            // Cập nhật số lượng tồn mới và giá nhập mới của hàng hóa
            String sqlUpdate = "UPDATE HangHoa SET SoLuongTonKho = ?, GiaNhap = ? WHERE MaHang = ?";
            PreparedStatement psUpdate = provider.getConn().prepareStatement(sqlUpdate);
            psUpdate.setInt(1, soLuongTonMoi);
            psUpdate.setFloat(2, giaNhap);
            psUpdate.setInt(3, maHangHoa);

            int rowsAffected = psUpdate.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
            }

            // Đóng kết nối và giải phóng tài nguyên
            rs.close();
            psSelect.close();
            psUpdate.close();
            provider.Close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isSuccess;
    }


    public static String dinhDangNgay(Date ngay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(ngay);
    }
}
