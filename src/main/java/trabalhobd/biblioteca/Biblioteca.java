/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package trabalhobd.biblioteca;

import controller.livroController;
import model.livro;

/**
 *
 * @author Saimon
 */
public class Biblioteca {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        
//        clienteController controller = new clienteController();
//        cliente cliente = new cliente();
//        cliente.setNomeCliente("admin");
//        cliente.setEmail("email@email.com");
//        cliente.setTelefone("999259456");
//        controller.save(cliente);

        livro livro = new livro();
        livroController livroControll = new livroController();
        
        livro.setTitulo("Banco de dados");
        livro.setAutor("jose alencar");
        livro.setEditora("maristela");
        livro.setPaginas(2591);
        
        livroControll.save(livro);
        
    }
    
    

}
