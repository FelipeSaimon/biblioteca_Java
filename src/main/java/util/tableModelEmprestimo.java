/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.emprestimo;


/**
 *
 * @author Saimon
 */
public class tableModelEmprestimo extends AbstractTableModel {

    String[] columns = {"Titulo", "Autor", "Ano de publicação", "Editora", "Excluir"};
    List<emprestimo> emprestimos = new ArrayList();

    @Override
    public int getRowCount() {
        return emprestimos.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex]; // <--Irá sobreescrever os nomes das colunas no model
    }

    //celula para editar um livro
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return columnIndex == 3;
//    }
    @Override
    public Class<?> getColumnClass(int ColumnIndex) {
        if (emprestimos.isEmpty()) {
            return Object.class;
        }
        return this.getValueAt(0, ColumnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        /*
        Esse switch organiza as linhas e colunas de acordo com as informações salvas no seu devido lugar no modelo criado
         */
        switch (columnIndex) {
            case 0:
                return emprestimos.get(rowIndex).getIdEmprestimo();
            case 1:
                return emprestimos.get(rowIndex).getIdCliente();
            case 2:
                return emprestimos.get(rowIndex).getIdLivro();
            case 3:
                return emprestimos.get(rowIndex).getNomeCliente();
            case 4:
                return emprestimos.get(rowIndex).getQuantidadeLivrosEmprestados();
            case 5:
                return emprestimos.get(rowIndex).getDataEmprestimo();
            case 6:
                return emprestimos.get(rowIndex).getDataDevolucao();
            default:
                return "Dado não encontrado";
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public List<emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public boolean isEmpty() {
        return true;
    }
}
