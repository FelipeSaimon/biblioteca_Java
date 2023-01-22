
package model;

import java.sql.Date;

public class emprestimo {
    private int idEmprestimo;
    private int idCliente;
    private int idLivro;
    private Date data;
    private Date dataDevolucao;
    
    public emprestimo(){

}

public emprestimo(int idEmprestimo, int idCliente, int idLivro, Date data, Date dataDevolucao) {
    this.idEmprestimo = idEmprestimo;
    this.idCliente = idCliente;
    this.idLivro = idLivro;
    this.data = data;
    this.dataDevolucao = dataDevolucao;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}

