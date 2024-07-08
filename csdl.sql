CREATE DATABASE QL_CuaHangTienLoi
go 
use QL_CuaHangTienLoi

go

CREATE TABLE NhanVien (
	MaNhanVien INT PRIMARY KEY,
	TenNhanVien NVARCHAR(255),
	NgaySinh DATE,
	GioiTinh NVARCHAR(10),
	SoDienThoai VARCHAR(20),
	DiaChi NVARCHAR(255),
	Luong INT
);
go

CREATE TABLE TaiKhoan (
	MaTaiKhoan int IDENTITY(1,1) PRIMARY KEY,
	TenTaiKhoan VARCHAR(50),
	MatKhau VARCHAR(50),
	LoaiTaiKhoan NVARCHAR(20),
	MaNV int,
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNhanVien)
);
go
CREATE TABLE LoaiHang (
	MaLoaiHang INT IDENTITY(1,1) PRIMARY KEY,
	TenLoaiHang NVARCHAR(255)
);
go
CREATE TABLE NhaCungCap (
    MaNhaCungCap INT IDENTITY(1,1) PRIMARY KEY,
    TenNhaCungCap NVARCHAR(255),
    SoDienThoai VARCHAR(20),
    DiaChi NVARCHAR(255)
);
go
CREATE TABLE HangHoa (
	MaHang INT IDENTITY(1,1) PRIMARY KEY,
	MaNhaCungCap INT,
	TenHang NVARCHAR(255),
	MaLoaiHang INT,
	DonViTinh NVARCHAR(50),
	DonGia INT,
	SoLuongTonKho INT default 0,
	GiaNhap INT default 0,
	HinhAnh Varchar(50),
	FOREIGN KEY (MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap),
	FOREIGN KEY (MaLoaiHang) REFERENCES LoaiHang(MaLoaiHang)
);
CREATE TABLE KhachHang(
	MaKhachHang int IDENTITY(1,1) PRIMARY KEY,
	TenKhachHang nvarchar(50),
	SoDienThoai char(20)
);
go
CREATE TABLE HoaDon (
	MaHoaDon INT IDENTITY(1,1) PRIMARY KEY,
	NgayMua DATE,
	MaNhanVien INT default 1,
	TongTien float,
	MaKhachHang int,
	FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
	FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);
go
CREATE TABLE ChiTietHoaDon (
	MaHoaDon INT,
	MaHang INT,
	SoLuong INT,
	DonGia INT,
	CONSTRAINT PK_ChiTietHD PRIMARY KEY(MaHoaDon, MaHang),
	FOREIGN KEY (MaHoaDon) REFERENCES HoaDon(MaHoaDon),
	FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);
go
CREATE TABLE NhapHang (
	MaNhapHang INT IDENTITY(1,1) PRIMARY KEY,
	MaNhanVien INT default 1,
	MaLoaiHang INT,
	NgayNhapHang DATE,
	TongTienNhapHang INT,
	FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
	FOREIGN KEY (MaLoaiHang) REFERENCES LoaiHang(MaLoaiHang)
);
go
CREATE TABLE ChiTietNhapHang (
	MaNhapHang INT,
	MaHang INT,
	SoLuong INT,
	DonGia INT,
	CONSTRAINT PK_ChiTietNH PRIMARY KEY(MaNhapHang, MaHang),
	FOREIGN KEY (MaNhapHang) REFERENCES NhapHang(MaNhapHang),
	FOREIGN KEY (MaHang) REFERENCES HangHoa(MaHang)
);
GO
INSERT INTO LoaiHang (TenLoaiHang)
VALUES
(N'Thực phẩm'),
(N'Bánh kẹo'),
(N'Quần áo'),
(N'Đồ gia dụng'),
(N'Sách vở'),
(N'Mỹ phẩm'),
(N'Đồ chơi');
GO

INSERT INTO NhaCungCap (TenNhaCungCap, SoDienThoai, DiaChi)
VALUES
(N'Công ty TNHH Tấn Phát', '0123456789', N'123 Đường Lê Trọng Tấn, TP.HCM'),
(N'Kho cung cấp sản phẩm Bình Tân', '0673522783', N'23 Đường Hiệp Bình Chánh, Thủ Đức'),
(N'Nhà máy sản xuất thủ công', '0223746589', N'12/4 Đường Hoàng Mai, Hà Nội'),
(N'Công ty MTV Hòa Bình', '0987654321', N'456 Đường Bùi Viện, TP.HCM');
GO

INSERT INTO HangHoa (MaNhaCungCap, TenHang, MaLoaiHang, DonViTinh, DonGia, SoLuongTonKho, GiaNhap, HinhAnh)
VALUES
(1, N'Gạo nếp', 1, N'Kg', 20000, 100, 15000, '/images/images2.jpg'),
(2, N'Bánh Donut', 2, N'Cái', 25000, 50, 21000, '/images/images3.jpg'),
(3, N'Áo sơ mi nam', 3, N'Cái', 300000, 80, 250000, '/images/images4.jpg'),
(2, N'Bánh ngọt', 2, N'Cái', 20000, 30, 17000, '/images/images5.jpg'),
(2, N'Bánh mì sandwich', 2, N'Cái', 15000, 25, 12000, '/images/images6.jpg'),
(2, N'Kẹo socola', 2, N'Cái', 10000, 50, 8000, '/images/images7.jpg'),
(2, N'Kẹo Kitkat', 2, N'Cái', 15000, 20, 14000, '/images/images8.jpg'),
(3, N'Áo thun nam', 3, N'Cái', 150000, 70, 120000, '/images/images9.jpg'),
(3, N'Váy đầm nữ', 3, N'Cái', 200000, 60, 190000, '/images/images10.jpg'),
(3, N'Quần jean nam', 3, N'Cái', 250000, 50, 230000, '/images/images11.jpg'),
(3, N'Áo khoác dù', 3, N'Cái', 300000, 40, 290000, '/images/images12.jpg'),
(4, N'Nồi cơm điện', 4, N'Cái', 500000, 35, 450000, '/images/images13.jpg'),
(4, N'Bình đun siêu tốc', 4, N'Cái', 300000, 40, 290000, '/images/images14.jpg'),
(4, N'Chảo chống dính', 4, N'Cái', 200000, 60, 190000, '/images/images15.jpg'),
(4, N'Bộ dụng cụ làm bánh', 4, N'Bộ', 800000, 25, 790000, '/images/images16.jpg'),
(4, N'Sách giáo khoa', 5, N'Cuốn', 50000, 100, 30000, '/images/images17.jpg'),
(4, N'Truyện tranh', 5, N'Cuốn', 100000, 80, 90000, '/images/images18.jpg'),
(4, N'Sách tiểu thuyết', 5, N'Cuốn', 150000, 60, 120000, '/images/images19.jpg'),
(4, N'Sách học ngoại ngữ', 5, N'Cuốn', 200000, 40, 150000, '/images/images20.jpg'),
(2, N'Kem dưỡng da', 6, N'Hũ', 200000, 50, 180000, '/images/images21.jpg'),
(2, N'Sữa rửa mặt', 6, N'Chai', 100000, 70, 80000, '/images/images22.jpg'),
(2, N'Mascara', 6, N'Ống', 150000, 60, 130000, '/images/images23.jpg'),
(2, N'Son môi', 6, N'Thỏi', 50000, 80, 40000, '/images/images24.jpg'),
(3, N'Xe đạp trẻ em', 7, N'Chiếc', 1000000, 30, 800000, '/images/images25.jpg'),
(3, N'Búp bê Barbie', 7, N'Chiếc', 500000, 40, 480000, '/images/images26.jpg'),
(3, N'Xe ô tô điều khiển từ xa', 7, N'Chiếc', 2000000, 20, 1800000, '/images/images27.jpg'),
(2, N'Xúc xích Đức', 2, N'Gói', 22000, 30, 15000, '/images/images28.jpg'),
(3, N'Nồi chiên không dầu', 4, N'Cái', 820000, 15, 500000, '/images/images29.jpg'),
(3, N'Trứng gà', 1, N'Hộp', 25000, 40, 15000, '/images/images30.jpg'),
(3, N'Bông cải xanh', 1, N'Kg', 42000, 20, 400000, '/images/images31.jpg'),
(3, N'Bóng bay', 7, N'Chiếc', 50000, 50, 45000, '/images/images32.jpg');
GO


INSERT INTO NhanVien (MaNhanVien,TenNhanVien, NgaySinh, GioiTinh, SoDienThoai, DiaChi, Luong)
VALUES
(1,N'Nguyễn Văn An', '1990-01-01', N'Nam', '0987654321', N'Hà Nội', 15000000),
(2,N'Trần Thị Lan', '1985-05-10', N'Nữ', '0123456789', N'Hồ Chí Minh', 12000000),
(3,N'Lê Minh Tuấn', '1992-07-15', N'Nam', '0912345678', N'Đà Nẵng', 13000000),
(4,N'Phạm Thị Hằng', '1988-03-20', N'Nữ', '0987123456', N'Hải Phòng', 14000000),
(5,N'Hoàng Văn Nam', '1995-11-30', N'Nam', '0901234567', N'Cần Thơ', 16000000);

INSERT INTO TaiKhoan (TenTaiKhoan, MatKhau, LoaiTaiKhoan, MaNV)
VALUES
('admin', '123', 'admin',1),
('user1', '123', 'user',2),
('user2', '123', 'user',3),
('user3', '123', 'user',4),
('user4', '123', 'user',5)

go
CREATE PROCEDURE sp_ThongKeHoaDonTheoNgay
    @NgayMua DATE
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        hd.MaHoaDon,
        hd.NgayMua,
        nv.TenNhanVien,
        kh.TenKhachHang,
        hd.TongTien
    FROM 
        HoaDon hd
    JOIN 
        NhanVien nv ON hd.MaNhanVien = nv.MaNhanVien
    JOIN 
        KhachHang kh ON hd.MaKhachHang = kh.MaKhachHang
    WHERE 
        hd.NgayMua = @NgayMua;
END
GO

exec sp_ThongKeHoaDonTheoNgay '2024-05-24'
go
CREATE PROCEDURE sp_ChiTietHoaDon
    @MaHoaDon INT
AS
BEGIN
    SELECT 
        hd.MaHoaDon,
        hh.TenHang,
        cthd.SoLuong,
        cthd.DonGia,
        (cthd.SoLuong * cthd.DonGia) AS ThanhTien
    FROM 
        ChiTietHoaDon cthd
    INNER JOIN 
        HoaDon hd ON cthd.MaHoaDon = hd.MaHoaDon
    INNER JOIN 
        HangHoa hh ON cthd.MaHang = hh.MaHang
    WHERE 
        hd.MaHoaDon = @MaHoaDon;
END
GO
exec sp_ChiTietHoaDon @MaHoaDon = 4;
go

select * from HangHoa

select * from HoaDon
select MaHang, SoLuong, DonGia from ChiTietHoaDon where MaHoaDon = 1

select * from NhaCungCap
select * from HangHoa where TenHang LIKE N'%gạo%'

select * from KhachHang

