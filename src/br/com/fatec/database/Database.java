/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Matheus1
 */
public class Database {
    public static String usuario, senha, servidor,
                         bd;
    public static int porta;
    public static java.sql.Connection conexao 
                            = null;
    static {
        usuario = "root";
        senha = "";
        servidor = "127.0.0.1";
        bd = "drugstore";
        porta = 3306;
    }
    
    public static void open() 
            throws ClassNotFoundException, 
                   SQLException {
        //carrega o driver
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + 
                     servidor +
                     ":" + porta +
                     "/" + bd;
                     
        conexao = java.sql.DriverManager.getConnection(
                url, usuario, senha);
    }
    
    public static void close() 
            throws SQLException {
        conexao.close();
    }
    
    public static Connection getConnection() {
        return conexao;
    }
}
