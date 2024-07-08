/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.HoaDonDAO;
import POJO.clsHoaDon;
import POJO.clsThongKe;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import javax.swing.JTable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Admin
 */
public class frmThongKe extends javax.swing.JFrame {

    /**
     * Creates new form frmThongKe
     */
    public frmThongKe() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        String []TieuDe = {"Mã hóa đơn", "Ngày mua", "Tên nhân viên","Tên khách hàng", "Tổng tiền"};
        model.setColumnIdentifiers(TieuDe);
        
    }
    private void thongKeVaHienThi() {
        String ngayString = txtNgay.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        Date ngayMua = null;
        try {
            ngayMua = dateFormat.parse(ngayString);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ! Vui lòng nhập ngày theo định dạng yyyy-MM-dd.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<clsThongKe> dsHoaDon = HoaDonDAO.thongKeHoaDonTheoNgay(ngayMua);
        
        hienThiLenBang(dsHoaDon);
        int tongTien = tinhTongTien(dsHoaDon);
        String tongTienFormatted = formatTien(tongTien);
        txtTongTien.setText(tongTienFormatted);
    }
    public static String formatTien(int tongTien) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###"+ " VND");
        return decimalFormat.format(tongTien);
    }
    private void hienThiLenBang(ArrayList<clsThongKe> dsHoaDon) {
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();
        model.setRowCount(0);
        for (clsThongKe hoaDon : dsHoaDon) {
            Object[] row = {hoaDon.getMaHD(), hoaDon.getNgayMua(), hoaDon.getTenNhanVien(), hoaDon.getTenKhachHang(),hoaDon.getTongTien()};
            model.addRow(row);
        }
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
        btnThongKe = new javax.swing.JButton();
        txtNgay = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ngày");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 37, -1));

        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jPanel1.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        try {
            txtNgay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 185, -1));

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblThongKe);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 440, 322));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tổng tiền:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));
        jPanel1.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 110, 20));

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_logout.png"))); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 40, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Thống kê hóa đơn");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_print.png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        thongKeVaHienThi();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
           JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Lưu tệp Excel");

        // Đặt bộ lọc tệp Excel
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Tệp Excel (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            // Kiểm tra phần mở rộng của tệp
            String extension = "";

            int i = filePath.lastIndexOf('.');
            int p = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));

            if (i > p) {
                extension = filePath.substring(i + 1);
            }

            if (!extension.equalsIgnoreCase("xlsx")) {
                filePath += ".xlsx"; 
            }

            exportToExcel(tblThongKe, filePath);
        }
    }//GEN-LAST:event_btnPrintActionPerformed
    public void exportToExcel(JTable table, String filePath) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Thống kê hóa đơn");

            int rowCount = table.getRowCount();
            int columnCount = table.getColumnCount();

            XSSFRow headerRow = sheet.createRow(0);
            for (int j = 0; j < columnCount; j++) {
                headerRow.createCell(j).setCellValue(table.getColumnName(j));
            }

            for (int i = 0; i < rowCount; i++) {
                XSSFRow row = sheet.createRow(i + 1);
                for (int j = 0; j < columnCount; j++) {
                    row.createCell(j).setCellValue(String.valueOf(table.getValueAt(i, j)));
                }
            }

            // Tính tổng tiền
            int totalRowIndex = rowCount + 1;
            XSSFRow totalRow = sheet.createRow(totalRowIndex);
            totalRow.createCell(0).setCellValue("Tổng tiền hóa đơn trong 1 ngày:");
            totalRow.createCell(4).setCellValue(txtTongTien.getText()); 

            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Exported to Excel successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JFormattedTextField txtNgay;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
    private int tinhTongTien(ArrayList<clsThongKe> dsHoaDon) {
        int tongTien = 0;
        for (clsThongKe hoaDon : dsHoaDon) {
            tongTien += hoaDon.getTongTien();
        }
        return tongTien;
    }
}
