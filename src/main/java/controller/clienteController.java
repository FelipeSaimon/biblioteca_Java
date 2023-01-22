
package controller;

import util.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.cliente;

/**
 *
 * @author Saimon
 */
public class clienteController {

    //Cria um projeto
    public void save(cliente cliente){
        String sql = "INSERT INTO cliente (nomeCliente , email, telefone)"
                + "VALUES (?,?,?)";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            statement.setString(1, cliente.getNomeCliente());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefone());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o cliente", e);
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
    public void update(cliente cliente){
        String sql = "UPDATE clientes SET nomeCliente = ? , email = ?, telefone = ? WHERE idCliente = ?";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            statement = connect.prepareStatement(sql);
            statement.setString(1, cliente.getNomeCliente());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefone());

            statement.setInt(5, cliente.getIdCliente());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar um projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement);
        }        
        
    }
    
    public void remove(int id){
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        
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
    
    public List<cliente> getAll(){
        String sql = "SELECT * FROM cliente";
        
        Connection connect = null;
        PreparedStatement statement = null;
        /*
        ANOTA��ES
            O Resultset � uma classe da API JAVA que permite percorrermos um DataTable de alguma consulta em um banco de dados.
            Ao ser inicializado, o Resultset coloca seu cursor na primeira linha do DataTable, o m�todo next()
            permite que o ponteiro seja direcionado para a pr�xima linha caso exista.
        */
        ResultSet resultado = null;
        List<cliente> clientes = new ArrayList<>();
  
        try {
            connect = ConnectionFactory.getConnection();
            statement = (PreparedStatement) connect.prepareStatement(sql);
            
            resultado = statement.executeQuery();
            
            while(resultado.next()){
                cliente cliente = new cliente();
                
                cliente.setIdCliente(resultado.getInt("idCliente"));
                cliente.setNomeCliente(resultado.getString("nomeCliente"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("Telefone"));

                
                clientes.add(cliente);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os clientes", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement, resultado);
        }
        return clientes;
    }
}
