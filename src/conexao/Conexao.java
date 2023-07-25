/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/banco";
    private static final String user = "root";
    private static final String password = "";
    
    private static Connection conn;
    
    public Connection getConexao(){
        try{
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão estabelecida!");
                return conn;
            }else{
                return conn;
            }
        } catch (SQLException e){
            System.out.println("Erro ao conectar "+e.getMessage());
            return null;
        }
    }
    
    
    
}
