package br.com.fatec.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    public static String usuario, senha, servidor,
                         bd;
    public static int porta;
    public static java.sql.Connection conexao = null;
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
