/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Saimon
 */
public class ButtonColumnCellRender extends DefaultTableCellRenderer{
    private String ButtonType;

    public ButtonColumnCellRender(String ButtonType) {
        this.ButtonType = ButtonType;
    }

        
    public String getButtonType() {
        return ButtonType;
    }

    public void setButtonType(String ButtonType) {
        this.ButtonType = ButtonType;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + ButtonType + ".png")));
        return label;
    }


}