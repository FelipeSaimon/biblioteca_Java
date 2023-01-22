package controller;

import util.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.secao;


public class secaoController {

    //Cria um projeto
    public void save(secao secao){
        String sql = "INSERT INTO secao (genero, capacidade)"
                + "VALUES (?,?)";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            statement.setString(1, secao.getGenero());
            statement.setInt(2, secao.getCapacidade());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o secao", e);
        }finally{
            //Fecha as conex�es
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
    
    //Atualiza dados de um projeto
    public void update(secao secao){
        String sql = "UPDATE secoes SET genero = ? , capacidade = ?WHERE idSecao = ?";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            statement = connect.prepareStatement(sql);
            statement.setString(1, secao.getGenero());
            statement.setInt(2, secao.getCapacidade());

            statement.setInt(3, secao.getIdSecao());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar um projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement);
        }        
        
    }
    
    public void remove(int id){
        String sql = "DELETE FROM secao WHERE idSecao = ?";
        
        Connection connect = null;
        PreparedStatement stat = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            stat = (PreparedStatement) connect.prepareStatement(sql);
            stat.setInt(1, id);
            stat.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover um projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connect, stat);
        }
    }
    
    public List<secao> getAll(){
        String sql = "SELECT * FROM secao";
        
        Connection connect = null;
        PreparedStatement statement = null;
        /*
        ANOTA��ES
            O Resultset � uma classe da API JAVA que permite percorrermos um DataTable de alguma consulta em um banco de dados.
            Ao ser inicializado, o Resultset coloca seu cursor na primeira linha do DataTable, o m�todo next()
            permite que o ponteiro seja direcionado para a pr�xima linha caso exista.
        */
        ResultSet resultado = null;
        List<secao> secoes = new ArrayList<>();
  
        try {
            connect = ConnectionFactory.getConnection();
            statement = (PreparedStatement) connect.prepareStatement(sql);
            
            resultado = statement.executeQuery();
            
            while(resultado.next()){
                secao secao = new secao();
                
                secao.setIdSecao(resultado.getInt("idSecao"));
                secao.setGenero(resultado.getString("genero"));
                secao.setCapacidade(resultado.getInt("capacidade"));
                

                
                secoes.add(secao);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os projetos", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement, resultado);
        }
        return secoes;
    }
}
