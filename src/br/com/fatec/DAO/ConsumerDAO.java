/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;
import br.com.fatec.database.Database;
import br.com.fatec.model.Consumer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Matheus1
 */
public class ConsumerDAO implements DAO <Consumer> {

    //Variaveis auxiliares
    private Consumer consumer; 
    //recebera comandos DML
    private java.sql.PreparedStatement pst; 
    //recebera estrutura com dados das tabelas
    private java.sql.ResultSet rs;
    
    @Override
    public boolean insert(Consumer obj) 
            throws SQLException, ClassNotFoundException {
            String sql;
        //cria o comando DML
        sql = "INSERT INTO specialclient "
            + "(name, cpf, rg, fone, email, databirth) "
            + "values (?, ?, ?, ?, ?, ?);";
        //Cria o pst com base na conexao e no comando DML
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        //Atribuir os dados do model para o pst
        pst.setString(1, obj.getName());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getFone());
        pst.setString(5, obj.getEmail());
        pst.setString(6, obj.getDate());
        //vamos executar o comando
        if(pst.executeUpdate() > 0) {
            Database.close();
            return true;
        }
        else {
            Database.close();
            return false;
        }
    }

    @Override
    public boolean edit(Consumer obj) 
            throws SQLException, ClassNotFoundException{
        String sql;
        //cria o comando DML
        sql = "UPDATE specialclient SET name = ?, cpf = ?, "
            + "rg = ?, fone = ?, email = ?, databirth = ? "
            + "WHERE id = ?;";
        //Cria o pst com base na conexao e no comando DML
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        //Atribuir os dados do model para o pst
        pst.setString(1, obj.getName());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getFone());
        pst.setString(5, obj.getEmail());
        pst.setString(6, obj.getDate());
        pst.setInt(7, obj.getIdConsumer());
    
        //vamos executar o comando
        if(pst.executeUpdate() > 0) {
            Database.close();
            return true;
        }
        else {
            Database.close();
            return false;
        }
    }
    @Override
    public boolean delete(Consumer obj) 
            throws SQLException, ClassNotFoundException {
        String sql;
        //cria o comando DML
        sql = "DELETE FROM specialclient "
            + "WHERE id = ?;";
        Database.open();
        //Cria o pst com base na conexao e no comando DML
        pst = Database.getConnection().prepareStatement(sql);
        //Atribuir os dados do model para o pst
        pst.setInt(1, obj.getIdConsumer());
        
        //vamos executar o comando
        if(pst.executeUpdate() > 0)
            return true;
        else 
            return false;
    }

    @Override
    public Consumer search(Consumer obj) 
            throws SQLException, ClassNotFoundException {
        consumer = null;
        String sql = "SELECT * FROM specialclient "
                   + "WHERE id = ?;";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        //Atribuir os dados do model para o pst

        pst.setInt(1, obj.getIdConsumer());
        //Executa a PESQUISA no banco
        rs = pst.executeQuery();
        //le o proximo registro
        if(rs.next()) { //achou alguem 
            consumer = new Consumer();
            consumer.setIdConsumer(rs.getInt("id"));
            consumer.setName(rs.getString("name"));
            consumer.setCpf(rs.getString("cpf"));
            consumer.setRg(rs.getString("rg"));
            consumer.setFone(rs.getString("fone"));
            consumer.setEmail(rs.getString("email"));
            consumer.setDate(rs.getString("databirth"));
        }
        //fecha o resultSet
        rs.close();
        Database.close();
        return consumer;
    }
    
    @Override
    public List<Consumer> list(String criterio) throws SQLException, ClassNotFoundException {
        //cria uma coleção para filmes
        ArrayList<Consumer> consumers = new ArrayList<>();
        consumer = null;
        String sql = "SELECT * FROM specialclient ";
        //verifica se tem criterio
        if(criterio.length() > 0)
            sql += "WHERE " + criterio;
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        //Executa a PESQUISA no banco
        rs = pst.executeQuery();
        //le os proximos registros
        while(rs.next()) { 
            //mover os dados do resultSet para o objeto filme
            consumer = new Consumer();
            consumer = new Consumer();
            consumer.setIdConsumer(rs.getInt("id"));
            consumer.setName(rs.getString("name"));
            consumer.setCpf(rs.getString("cpf"));
            consumer.setRg(rs.getString("rg"));
            consumer.setFone(rs.getString("fone"));
            consumer.setEmail(rs.getString("email"));
            consumer.setDate(rs.getString("databirth"));
            consumers.add(consumer);
        } //end while()
        //fecha o resultSet
        rs.close();
        Database.close();
        return consumers;        
    }
    
}