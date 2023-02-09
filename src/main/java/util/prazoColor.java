/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.emprestimo;
import view.emprestimoView;
//import view.emprestimoView;

/**
 *
 * @author Saimon
 */
public class prazoColor extends DefaultTableCellRenderer{

    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        //vai devolver uma label para o nosso grid
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        label.setHorizontalAlignment(CENTER);

        tableModelEmprestimo emprestimosModel = (tableModelEmprestimo) table.getModel();
        emprestimo emprestimo = emprestimosModel.getEmprestimos().get(row);

        if (emprestimo.getDataDevolucao().after(new Date())) {
            label.setBackground(Color.green);
        } else {
            label.setBackground(Color.red);
        }
        return label;
    }
}
