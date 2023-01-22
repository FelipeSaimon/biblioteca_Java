
package model;

import java.sql.Timestamp;

public class reserva {

    private int idReserva;
    private int idCliente;
    private int idLivro;
    private Timestamp dataHora;
    private Timestamp dataHoraDevolucao;

    public reserva() {}

    public reserva(int idCliente, int idLivro, Timestamp dataHora, Timestamp dataHoraDevolucao) {
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.dataHora = dataHora;
        this.dataHoraDevolucao = dataHoraDevolucao;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
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

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public Timestamp getDataHoraDevolucao() {
        return dataHoraDevolucao;
    }

    public void setDataHoraDevolucao(Timestamp dataHoraDevolucao) {
        this.dataHoraDevolucao = dataHoraDevolucao;
    }
}
