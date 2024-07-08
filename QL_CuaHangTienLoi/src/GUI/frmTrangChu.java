/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import POJO.clsTaiKhoan;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class frmTrangChu extends javax.swing.JFrame {

    private String tenNV;
    private String quyenNV;
    /**
     * Creates new form frmTrangChu
     */
    public frmTrangChu(String tenNhanVien, String quyenNhanVien) {
        initComponents();
        btnThoat.setOpaque(false);
        btnThoat.setContentAreaFilled(false);
        
        this.tenNV = tenNhanVien;
        this.quyenNV = quyenNhanVien;
        lblTenNhanVien.setText(tenNhanVien);
        kiemTraQuyen();
        frmBanHang banhang = new frmBanHang();
        plMenu.removeAll();
        plMenu.add(banhang.getContentPane());
        plMenu.revalidate();
        plMenu.repaint();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        plMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnBanHang = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnHangHoa = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnNhapHang = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnNhaCungCap1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 231, 238));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Cửa hàng tiện lợi");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 14, 304, -1));

        lblTenNhanVien.setBackground(new java.awt.Color(204, 255, 255));
        lblTenNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTenNhanVien.setForeground(new java.awt.Color(255, 0, 51));
        jPanel2.add(lblTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 170, 21));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_user.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_marketplace.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 50, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_open.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 0, -1, -1));

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_logout.png"))); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel2.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 80));

        javax.swing.GroupLayout plMenuLayout = new javax.swing.GroupLayout(plMenu);
        plMenu.setLayout(plMenuLayout);
        plMenuLayout.setHorizontalGroup(
            plMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1070, Short.MAX_VALUE)
        );
        plMenuLayout.setVerticalGroup(
            plMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(plMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 1070, 550));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBanHang.setBackground(new java.awt.Color(255, 255, 204));
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_sale.png"))); // NOI18N
        btnBanHang.setText("Bán hàng");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
            }
        });
        jPanel3.add(btnBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 6, 160, 55));

        btnHoaDon.setBackground(new java.awt.Color(255, 255, 204));
        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_bill.png"))); // NOI18N
        btnHoaDon.setText("Hóa đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });
        jPanel3.add(btnHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 73, 160, 55));

        btnHangHoa.setBackground(new java.awt.Color(255, 255, 204));
        btnHangHoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_hanghoa.png"))); // NOI18N
        btnHangHoa.setText("Hàng hóa");
        btnHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHoaActionPerformed(evt);
            }
        });
        jPanel3.add(btnHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 140, 160, 55));

        btnNhanVien.setBackground(new java.awt.Color(255, 255, 204));
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_nhanvien.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        jPanel3.add(btnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 207, 160, 55));

        btnNhapHang.setBackground(new java.awt.Color(255, 255, 204));
        btnNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_nhaphang.png"))); // NOI18N
        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });
        jPanel3.add(btnNhapHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 274, -1, 55));

        btnDangXuat.setBackground(new java.awt.Color(255, 0, 51));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jPanel3.add(btnDangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 481, 140, 55));

        btnThongKe.setBackground(new java.awt.Color(255, 255, 204));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_thongke.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jPanel3.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 408, 160, 55));

        btnNhaCungCap1.setBackground(new java.awt.Color(255, 255, 204));
        btnNhaCungCap1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhaCungCap1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_nhacungcap.png"))); // NOI18N
        btnNhaCungCap1.setText("Nhà cung cấp");
        btnNhaCungCap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaCungCap1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnNhaCungCap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 341, -1, 55));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 210, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoaActionPerformed
        // TODO add your handling code here:
        frmHangHoa hanghoa = new frmHangHoa();
        plMenu.removeAll();
        plMenu.add(hanghoa.getContentPane());
        plMenu.revalidate();
        plMenu.repaint();
    }//GEN-LAST:event_btnHangHoaActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        frmNhanVien nhanvien = new frmNhanVien();
        plMenu.removeAll();
        plMenu.add(nhanvien.getContentPane());
        plMenu.revalidate();
        plMenu.repaint();
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
        frmHoaDon hoadon = new frmHoaDon();
         plMenu.removeAll();
         plMenu.add(hoadon.getContentPane());
         plMenu.revalidate();
         plMenu.repaint();
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        frmNhapHang nhaphang = new frmNhapHang();
        plMenu.removeAll();
        plMenu.add(nhaphang.getContentPane());
        plMenu.revalidate();
        plMenu.repaint();
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        // TODO add your handling code here:
        frmBanHang banhang = new frmBanHang();
        plMenu.removeAll();
        plMenu.add(banhang.getContentPane());
        plMenu.revalidate();
        plMenu.repaint();
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            frmDangNhap dn = new frmDangNhap();
            dn.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát khỏi chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        frmThongKe ncc  = new frmThongKe();
        ncc.setVisible(true);
//        plMenu.removeAll();
//        plMenu.add(ncc.getContentPane());
//        plMenu.revalidate();
//        plMenu.repaint();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnNhaCungCap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaCungCap1ActionPerformed
        // TODO add your handling code here:
        frmNhaCungCap ncc  = new frmNhaCungCap();
        plMenu.removeAll();
        plMenu.add(ncc.getContentPane());
        plMenu.revalidate();
        plMenu.repaint();
    }//GEN-LAST:event_btnNhaCungCap1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTrangChu("Admin", "admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHangHoa;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnNhaCungCap1;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JPanel plMenu;
    // End of variables declaration//GEN-END:variables
    private void kiemTraQuyen() {
        if (quyenNV.equals("admin")) {
            // Hiển thị tất cả các chức năng cho quản trị viên
            btnHangHoa.setVisible(true);
            btnNhanVien.setVisible(true);
            btnNhapHang.setVisible(true);
            btnHoaDon.setVisible(true);
            btnBanHang.setVisible(true);
            btnNhaCungCap1.setVisible(true);
            btnThongKe.setVisible(true);
        } else {
            // Ẩn các chức năng không phù hợp cho người dùng thông thường
            btnHangHoa.setVisible(false);
            btnNhanVien.setVisible(false);
            btnNhapHang.setVisible(false);
            btnHoaDon.setVisible(true); 
            btnBanHang.setVisible(true); 
            btnThongKe.setVisible(false);
            btnNhaCungCap1.setVisible(false);
        }
    }
}