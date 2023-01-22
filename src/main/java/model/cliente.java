
package model;

/**
 *
 * @author Saimon
 */
public class cliente {
    private int idCliente;
    private String nomeCliente;
    private String email;
    private String telefone;
    private String cpf;
    private String endereco;
    
    public cliente(int idCliente, String nomeCliente, String email, String telefone, String cpf, String endereco) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public cliente() {
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
 
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "cliente{" + "idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", email=" + email + ", telefone=" + telefone + '}';
    }

    
    
}
