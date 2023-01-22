
package controller;

import util.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.reserva;


public class reservaController {

    //Cria um projeto
    public void save(reserva reserva){
        String sql = "INSERT INTO reserva (idLivro, idCliente, dataHora, dataHoraDevolucao)"
                + "VALUES (?,?,?,?)";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            statement.setInt(1, reserva.getIdLivro());
            statement.setInt(2, reserva.getIdCliente());
            statement.setTimestamp(3, reserva.getDataHora());
            statement.setTimestamp(4, reserva.getDataHoraDevolucao());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o reserva", e);
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
    public void update(reserva reserva){
        String sql = "UPDATE reservas SET dataHora = ? , dataHoraDevolucao = ?WHERE idReserva = ?";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            statement = connect.prepareStatement(sql);
            statement.setInt(1, reserva.getIdLivro());
            statement.setInt(2, reserva.getIdCliente());
            statement.setTimestamp(3, reserva.getDataHora());
            statement.setTimestamp(4, reserva.getDataHoraDevolucao());

            statement.setInt(5, reserva.getIdReserva());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar um projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement);
        }        
        
    }
    
    public void remove(int idReserva, int idCliente, int idLivro){
        String sql = "DELETE FROM reserva WHERE idReserva = ? OR idCliente = ? OR idLivro = ?";
        
        Connection connect = null;
        PreparedStatement stat = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            stat = (PreparedStatement) connect.prepareStatement(sql);
            stat.setInt(1, idReserva);
            stat.setInt(2, idCliente);
            stat.setInt(3, idLivro);
            stat.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover uma reserva", e);
        }finally{
            ConnectionFactory.closeConnection(connect, stat);
        }
    }

    public List<reserva> getAll(){
        String sql = "SELECT * FROM reserva";
        
        Connection connect = null;
        PreparedStatement statement = null;
        /*
        ANOTA��ES
            O Resultset � uma classe da API JAVA que permite percorrermos um DataTable de alguma consulta em um banco de dados.
            Ao ser inicializado, o Resultset coloca seu cursor na primeira linha do DataTable, o m�todo next()
            permite que o ponteiro seja direcionado para a pr�xima linha caso exista.
        */
        ResultSet resultado = null;
        List<reserva> reservas = new ArrayList<>();
  
        try {
            connect = ConnectionFactory.getConnection();
            statement = (PreparedStatement) connect.prepareStatement(sql);
            
            resultado = statement.executeQuery();
            
            while(resultado.next()){
                reserva reserva = new reserva();
                
                reserva.setIdReserva(resultado.getInt("idReserva"));
                reserva.setIdLivro(resultado.getInt("idLivro"));
                reserva.setIdCliente(resultado.getInt("idCliente"));
                reserva.setDataHora(resultado.getTimestamp("dataHora"));
                reserva.setDataHoraDevolucao(resultado.getTimestamp("dataHoraDevolucao"));
                

                
                reservas.add(reserva);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os projetos", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement, resultado);
        }
        return reservas;
    }
}
