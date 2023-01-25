package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.emprestimo;
import util.ConnectionFactory;

public class emprestimoController {

    //Cria um empréstimo
    public void save(emprestimo emprestimo){
        String sql = "INSERT INTO emprestimo (idCliente, idLivro, data, dataDevolucao)"
                + "VALUES (?,?,?,?)";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);
            
            statement.setInt(1, emprestimo.getIdCliente());
            statement.setInt(2, emprestimo.getIdLivro());
            statement.setDate(3, emprestimo.getDataEmprestimo());
            statement.setDate(4, emprestimo.getDataDevolucao());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o empréstimo", e);
        }finally{
            //Fecha as conexões
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }            
        }
    }
    
    //Atualiza dados de um empréstimo
    public void update(emprestimo emprestimo){
        String sql = "UPDATE emprestimo SET idCliente = ?, idLivro = ?, data = ?, dataDevolucao = ?WHERE idSecao = ?";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            statement = connect.prepareStatement(sql);
            statement.setInt(1, emprestimo.getIdCliente());
            statement.setInt(2, emprestimo.getIdLivro());
            statement.setDate(3, emprestimo.getDataEmprestimo());
            statement.setDate(4, emprestimo.getDataDevolucao());

            statement.setInt(5, emprestimo.getIdEmprestimo());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar um projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement);
        }        
        
    }
    
    public void remove(int idEmprestimo, int idCliente, int idLivro){
        String sql = "DELETE FROM emprestimo WHERE idEmprestimo = ? OR idCliente = ? OR idLivro = ?";
        
        Connection connect = null;
        PreparedStatement stat = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            stat = (PreparedStatement) connect.prepareStatement(sql);
            stat.setInt(1, idEmprestimo);
            stat.setInt(2, idCliente);
            stat.setInt(3, idLivro);
            stat.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover um emprestimo", e);
        }finally{
            ConnectionFactory.closeConnection(connect, stat);
        }
    }

    public List<emprestimo> getAll(){
        String sql = "SELECT * FROM emprestimo";
        
        Connection connect = null;
        PreparedStatement statement = null;
        /*
        ANOTA��ES
            O Resultset � uma classe da API JAVA que permite percorrermos um DataTable de alguma consulta em um banco de dados.
            Ao ser inicializado, o Resultset coloca seu cursor na primeira linha do DataTable, o m�todo next()
            permite que o ponteiro seja direcionado para a pr�xima linha caso exista.
        */
        ResultSet resultado = null;
        List<emprestimo> emprestimos = new ArrayList<>();
  
        try {
            connect = ConnectionFactory.getConnection();
            statement = (PreparedStatement) connect.prepareStatement(sql);
            
            resultado = statement.executeQuery();
            
            while(resultado.next()){
                emprestimo emprestimo = new emprestimo();
                
                emprestimo.setIdEmprestimo(resultado.getInt("idEmprestimo"));
                emprestimo.setIdLivro(resultado.getInt("idLivro"));
                emprestimo.setIdCliente(resultado.getInt("idCliente"));
                emprestimo.setDataEmprestimo(resultado.getDate("data"));
                emprestimo.setDataDevolucao(resultado.getDate("dataDevolucao"));
                

                
                emprestimos.add(emprestimo);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os projetos", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement, resultado);
        }
        return emprestimos;
    }
}

