/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.text.DecimalFormat;
/**
 *
 * @author Admin
 */
public class clsFormatCol extends DefaultTableCellRenderer{
    private static final DecimalFormat formatter = new DecimalFormat("#,##0 "+ "VND");

    @Override
    public void setValue(Object value) {
        if (value != null) {
            value = formatter.format(value);
        }
        super.setValue(value);
    }
}
