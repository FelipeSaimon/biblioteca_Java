/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




/**
 *
 * @author Saimon
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConnection(){
       try{
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
            
        }catch (Exception ex){
            throw new RuntimeException("Erro na conex�o com o banco de dados ", ex);
        }
    }
    
    //Caso haja conex�o aberta esse m�todo fecha

    /**
     *
     * @param connect
     * @param statement
     */
    public static void closeConnection(Connection connect){
        try{
            if(connect != null){
                connect.close();
            }

        }catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection connect, PreparedStatement statement){
        try{
            if(connect != null){
                connect.close();
            }

            if(statement != null){
                statement.close();
            }
        }catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connect, PreparedStatement statement, ResultSet resultado){
        try{
            if(connect != null){
                connect.close();
            }

            if(statement != null){
                statement.close();
            }
            
            if(resultado != null){
                resultado.close();
            }
            
        }catch(Exception ex){
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados", ex);
        }
    }


}
