
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.livro;
import util.ConnectionFactory;

/**
 *
 * @author Saimon
 */
public class livroController {

    //Cria um projeto
    public void save(livro livro){
        //Para testar eu removi a disponibilidade
        String sql = "INSERT INTO livro (idSecao, titulo, autor, paginas, anoPublicacao, editora)"
                + "VALUES (?,?,?,?,?,?)";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement(sql);

            
            statement.setInt(1, livro.getIdSecao());
            statement.setString(2, livro.getTitulo());
            statement.setString(3, livro.getAutor());
            statement.setInt(4, livro.getPaginas());
            statement.setDate(5, new java.sql.Date (livro.getAnoPublicacao().getTime()));
            statement.setString(6, livro.getEditora());
            //statement.setBoolean(7, livro.getDisponibilidade());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar o livro", e);
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
    public void update(livro livro){
        String sql = "UPDATE livros SET titulo = ? , autor = ?, paginas = ?, anoPublicacao= ?, editora = ?, disponivel = ? WHERE idCliente = ?";
        
        Connection connect = null;
        PreparedStatement statement = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            statement = connect.prepareStatement(sql);
            statement.setInt(1, livro.getIdSecao());
            statement.setString(2, livro.getTitulo());
            statement.setString(3, livro.getAutor());
            statement.setInt(4, livro.getPaginas());
            statement.setDate(5, new java.sql.Date (livro.getAnoPublicacao().getTime()));
            statement.setString(6, livro.getEditora());
            statement.setBoolean(7, livro.getDisponibilidade());
            
            statement.setInt(8, livro.getIdLivro());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar um projeto", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement);
        }        
        
    }
    
    public void remove(int idLivro, int idSecao){
        String sql = "DELETE FROM livro WHERE idLivro = ? or idSecao = ?";
        
        Connection connect = null;
        PreparedStatement stat = null;
        
        try {
            connect = ConnectionFactory.getConnection();
            
            stat = (PreparedStatement) connect.prepareStatement(sql);
            stat.setInt(1, idLivro);
            stat.setInt(2, idSecao);
            stat.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover um livro", e);
        }finally{
            ConnectionFactory.closeConnection(connect, stat);
        }
    }

    
    public List<livro> getAll(){
        String sql = "SELECT * FROM livro";
        
        Connection connect = null;
        PreparedStatement statement = null;
        /*
        ANOTA��ES
            O Resultset � uma classe da API JAVA que permite percorrermos um DataTable de alguma consulta em um banco de dados.
            Ao ser inicializado, o Resultset coloca seu cursor na primeira linha do DataTable, o m�todo next()
            permite que o ponteiro seja direcionado para a pr�xima linha caso exista.
        */
        ResultSet resultado = null;
        List<livro> livros = new ArrayList<>();
  
        try {
            connect = ConnectionFactory.getConnection();
            statement = (PreparedStatement) connect.prepareStatement(sql);
            
            resultado = statement.executeQuery();
            
            while(resultado.next()){
                livro livro = new livro();
                
                
                livro.setIdSecao(resultado.getInt("idSecao"));
                livro.setIdLivro(resultado.getInt("idLivro"));
                livro.setTitulo(resultado.getString("titulo"));
                livro.setAutor(resultado.getString("autor"));
                livro.setPaginas(resultado.getInt("paginas"));
                livro.setAnoPublicacao(resultado.getDate("anoPublicacao"));
                livro.setEditora(resultado.getString("editora"));
                
                
                livros.add(livro);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os projetos", e);
        }finally{
            ConnectionFactory.closeConnection(connect, statement, resultado);
        }
        return livros;
    }
}

