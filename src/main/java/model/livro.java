
package model;

import java.util.Date;

public class livro {
    private int idLivro;
    private int idSecao;
    private String titulo;
    private String autor;
    private int paginas;
    private Date anoPublicacao;
    private String editora;
    private boolean disponibilidade;

    public livro(int idLivro, int idSecao, String titulo, String autor, int paginas, Date anoPublicacao, String editora, boolean disponibilidade) {
        this.idLivro = idLivro;
        this.idSecao = idSecao;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.disponibilidade = disponibilidade;
    }

    public livro() {
        this.anoPublicacao = new Date();
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdSecao() {
        return idSecao;
    }

    public void setIdSecao(int idSecao) {
        this.idSecao = idSecao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public Date getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public String toString() {
        return "livro{" + "idLivro=" + idLivro + ", idSecao=" + idSecao + ", titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", anoPublicacao=" + anoPublicacao + ", editora=" + editora + ", disponibilidade=" + disponibilidade + '}';
    }
    
    
}

