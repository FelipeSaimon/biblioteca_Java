/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saimon
 */
public class TableModelCliente extends AbstractTableModel{

    String[] columns = {"Nome", "Email", "Telefone", "Editar", "Excluir"};
    List<cliente> clientes = new ArrayList();
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override // <-- Significa sobreescrita
    public String getColumnName(int columnIndex){
        return columns[columnIndex]; // <--Irá sobreescrever os nomes das colunas no model
    }
    
    //celula para editar um cliente
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == 3;
    }


    
    @Override
    public Class<?> getColumnClass(int ColumnIndex){
        if(clientes.isEmpty()){
            return Object.class;
        }
        return this.getValueAt(0, ColumnIndex).getClass();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        /*
        Esse switch organiza as linhas e colunas de acordo com as informações salvas no seu devido lugar no modelo criado
        */
        switch(columnIndex){
            case 0:
                return clientes.get(rowIndex).getNomeCliente();
            case 1:
                return clientes.get(rowIndex).getEmail();
            case 2:
                return clientes.get(rowIndex).getTelefone();
            case 3:
                return "";
            case 4:
                return "";
            default:  return "Dado não encontrado";
        }
    }
    
    
    public String[] getColumns() {
        return columns;
    }

    public List<cliente> getclientes() {
        return clientes;
    }

    public void setclientes(List<cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean isEmpty() {
        return false;
    }


}
