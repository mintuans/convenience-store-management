/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.HangHoaDAO;
import DAO.NhapHangDAO;
import POJO.clsChiTietNhapHang;
import POJO.clsFormatCol;
import POJO.clsHangHoa;
import POJO.clsNhapHang;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Admin
 */
public class frmNhapHang extends javax.swing.JFrame {

    /**
     * Creates new form frmNhapHang
     */
    public frmNhapHang() {
        initComponents();
        this.setLocationRelativeTo(null);
        TieuDe1();
        TieuDe2();
        TableColumnModel columnModel = tblChiTietNhapHang.getColumnModel();
        columnModel.getColumn(2).setCellRenderer(new clsFormatCol());
        tblChiTietNhapHang.setDefaultEditor(Object.class, null);
        tblHangHoa.setDefaultEditor(Object.class, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHangHoa = new javax.swing.JTable();
        txtFillter = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        btnNhap = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietNhapHang = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        txtChiTIet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Lọc dữ liệu theo số lượng:");

        tblHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHangHoa);

        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_filter.png"))); // NOI18N
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        btnNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhap.setText("Nhập hàng");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        jLabel2.setText("Số lượng nhập:");

        jLabel3.setText("Giá nhập: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFillter, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFilter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnNhap)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFillter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhap)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhập hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 12))); // NOI18N

        tblChiTietNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblChiTietNhapHang);

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_pay.png"))); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_load.png"))); // NOI18N
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefesh)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan)
                    .addComponent(btnRefesh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtChiTIet.setText("Thông tin chi tiết");
        txtChiTIet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChiTIetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtChiTIet)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtChiTIet)
                        .addGap(0, 164, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
        String soLuongTonNhapStr = txtFillter.getText().trim();

        if (soLuongTonNhapStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng tồn cần tìm kiếm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int soLuongTonNhap = Integer.parseInt(soLuongTonNhapStr);

            ArrayList<clsHangHoa> dsHangHoa = NhapHangDAO.timKiemHangHoaTheoSoLuongTon(soLuongTonNhap);

            DefaultTableModel model = (DefaultTableModel) tblHangHoa.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            for (clsHangHoa hh : dsHangHoa) {
                model.addRow(new Object[]{
                    hh.getMaHang(),
                    hh.getTenHangHoa(),
                    hh.getMaLoaiHang(),
                    hh.getDonViTinh(),
                    hh.getSoLuongTon()
                });
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng tồn là một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblHangHoa.getSelectedRow();
    
        if (selectedRow != -1) {
            int maHang = (int) tblHangHoa.getValueAt(selectedRow, 0);
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            int giaNhap = Integer.parseInt(txtGiaNhap.getText());

            float thanhTien = soLuong * giaNhap;

            DefaultTableModel model = (DefaultTableModel) tblChiTietNhapHang.getModel();
            model.addRow(new Object[]{maHang, soLuong, giaNhap, thanhTien});
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng hóa từ danh sách.");
        }
    }//GEN-LAST:event_btnNhapActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
    DefaultTableModel model = (DefaultTableModel) tblChiTietNhapHang.getModel();
    int rowCount = model.getRowCount();

    if (rowCount == 0) {
        JOptionPane.showMessageDialog(this, "Không có hàng hóa để thanh toán", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    
    int tongTienNhapHang = 0;
    for (int i = 0; i < rowCount; i++) {
        int donGia = (int) model.getValueAt(i, 2);
        int soLuong = (int) model.getValueAt(i, 1);
        tongTienNhapHang += donGia * soLuong;
    }
    
    // Thêm thông tin nhập hàng vào cơ sở dữ liệu
    clsNhapHang nhapHang = new clsNhapHang();
    nhapHang.setMaNV(1); 
    nhapHang.setNgayNhap(new Date()); 
    nhapHang.setTongTien(tongTienNhapHang); 

    if (!NhapHangDAO.themHoaDonNhap(nhapHang)) {
        JOptionPane.showMessageDialog(this, "Lỗi khi thêm thông tin nhập hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int maNhapHangMoi = NhapHangDAO.layMaNhapHangMoi();
    
    for (int i = 0; i < rowCount; i++) {
        int maHang = (int) model.getValueAt(i, 0);
        int soLuong = (int) model.getValueAt(i, 1);
        int giaNhap = (int) model.getValueAt(i, 2);

        clsChiTietNhapHang chiTietNhapHang = new clsChiTietNhapHang();
        chiTietNhapHang.setMaNhap(maNhapHangMoi);
        chiTietNhapHang.setMaHang(maHang);
        chiTietNhapHang.setSoLuong(soLuong);
        chiTietNhapHang.setDonGia(giaNhap);

        if (!NhapHangDAO.themChiTietNhapHang(chiTietNhapHang)) {
            JOptionPane.showMessageDialog(this, "Lỗi khi thêm chi tiết nhập hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    for (int i = 0; i < rowCount; i++) {
        int maHang = (int) model.getValueAt(i, 0);
        int soLuong = (int) model.getValueAt(i, 1);
        int giaNhap = (int) model.getValueAt(i, 2);

        if (!NhapHangDAO.capNhatSoLuongTonVaGiaNhapHangHoa(maHang, soLuong, giaNhap)) {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật số lượng tồn và giá nhập của hàng hóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    model.setRowCount(0);

    JOptionPane.showMessageDialog(this, "Thanh toán thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        // TODO add your handling code here:
        resetChiTietNhapHang();
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void txtChiTIetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChiTIetActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtChiTIetActionPerformed

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
            java.util.logging.Logger.getLogger(frmNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNhapHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblChiTietNhapHang;
    private javax.swing.JTable tblHangHoa;
    private javax.swing.JButton txtChiTIet;
    private javax.swing.JTextField txtFillter;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
    private void TieuDe1()
    {
        String []TieuDe = {"Mã hàng hóa", "Tên hàng hóa", "Loại hàng", "Đơn vị tính","Số lượng tồn"};
        DefaultTableModel dtm = (DefaultTableModel)tblHangHoa.getModel();
        dtm.setColumnIdentifiers(TieuDe);
        dtm.setRowCount(0);
        ArrayList<clsHangHoa> dsHH = NhapHangDAO.layDanhSachHangHoa();
        for(clsHangHoa hh : dsHH)
        {
            Vector<Object> vec = new Vector<Object>();
            vec.add(hh.getMaHang());
            vec.add(hh.getTenHangHoa());
            vec.add(hh.getMaLoaiHang());
            vec.add(hh.getDonViTinh());
            vec.add(hh.getSoLuongTon());
            dtm.addRow(vec);
        }
        tblHangHoa.setModel(dtm);
    }
    private void TieuDe2()
    {
        String []TieuDe = {"Mã hàng", "Số lượng", "Giá nhập", "Thành tiền"};
        DefaultTableModel dtm = (DefaultTableModel)tblChiTietNhapHang.getModel();
        dtm.setColumnIdentifiers(TieuDe);
        dtm.setRowCount(0);
    }
    private void resetChiTietNhapHang() {
        DefaultTableModel modelHoaDon = (DefaultTableModel) tblChiTietNhapHang.getModel();
        modelHoaDon.setRowCount(0);
    }
}