
package model;

import java.sql.Date;

public class emprestimo {
    private int idEmprestimo;
    private int idCliente;
    private int idLivro;
    private Date dataEmprestimo;
    private Date dataDevolucao;



    public emprestimo(int idEmprestimo, int idCliente, int idLivro, Date dataEmprestimo, Date dataDevolucao) {
        this.idEmprestimo = idEmprestimo;
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public emprestimo() {
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
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "emprestimo{" + "idEmprestimo=" + idEmprestimo + ", idCliente=" + idCliente + ", idLivro=" + idLivro + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + '}';
    }

    
}

