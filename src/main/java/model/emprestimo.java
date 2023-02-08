
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import util.ConnectionFactory;

public class emprestimo {

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    private int idEmprestimo;
    private int idCliente;
    private int idLivro;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String nomeCliente;
    private int qtLivros;



    public emprestimo(int idEmprestimo, int idCliente, int idLivro, Date dataEmprestimo, Date dataDevolucao) {
        this.idEmprestimo = idEmprestimo;
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public emprestimo() {
        this.dataEmprestimo = new Date();
        this.dataDevolucao = new Date();
    }
    

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
        
        // Faz a consulta para pegar o nome do cliente
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement("SELECT nomeCliente FROM cliente WHERE idCliente = ?");
            statement.setInt(1, idCliente);
            resultado = statement.executeQuery();

            if (resultado.next()) {
                this.nomeCliente = resultado.getString("nomeCliente");
            }
        } catch (Exception e) {
            System.out.println("Nome não encontrado!");
        } 
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    

    public int getQuantidadeLivrosEmprestados() {
        return qtLivros;
    }

    public void setQtLivros(int qtLivros) {
        this.qtLivros = qtLivros;
        // Faz a consulta para pegar a quantidade de livros emprestados
        Connection connect = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;

        try {
            connect = ConnectionFactory.getConnection();
            statement = connect.prepareStatement("SELECT COUNT(*) FROM emprestimo WHERE idCliente = ?");
            statement.setInt(1, idCliente);
            resultado = statement.executeQuery();

            if (resultado.next()) {
                this.qtLivros = resultado.getInt(1);
            }
        } catch (Exception e) {
            // Tratar a exceção adequadamente
        } finally {
            // Fechar as conexões e statements adequadamente
        }
    }
    
   
    @Override
    public String toString() {
        return "emprestimo{" + "idEmprestimo=" + idEmprestimo + ", idCliente=" + idCliente + ", idLivro=" + idLivro + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + '}';
    }

    
}

