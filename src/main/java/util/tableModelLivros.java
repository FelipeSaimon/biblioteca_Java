/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import model.livro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Saimon
 */
public class tableModelLivros extends AbstractTableModel {

    String[] columns = {"Titulo", "Autor", "Ano de publicação", "Editora", "Excluir"};
    List<livro> livros = new ArrayList();

    @Override
    public int getRowCount() {
        return livros.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override // <-- Significa sobreescrita
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
        if (livros.isEmpty()) {
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
                return livros.get(rowIndex).getTitulo();
            case 1:
                return livros.get(rowIndex).getAutor();
            case 2:
                return livros.get(rowIndex).getAnoPublicacao();
            case 3:
                return livros.get(rowIndex).getEditora();
            case 4:
                return "";
            default:
                return "Dado não encontrado";
        }
    }

    public String[] getColumns() {
        return columns;
    }

    public List<livro> getlivros() {
        return livros;
    }

    public void setlivros(List<livro> livros) {
        this.livros = livros;
    }

    public boolean isEmpty() {
        return true;
    }
}
