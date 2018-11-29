package br.com.fatec.DAO;

import br.com.fatec.database.Database;
import br.com.fatec.model.Consumer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsumerDAO implements DAO <Consumer> {
    private Consumer consumer; 
    private PreparedStatement pst; 
    private ResultSet rs;
    
    @Override
    public boolean insert(Consumer obj) 
            throws SQLException, ClassNotFoundException {
            String sql;
        sql = "INSERT INTO specialclient "
            + "(name, cpf, rg, fone, email, databirth) "
            + "values (?, ?, ?, ?, ?, ?);";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        pst.setString(1, obj.getName());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getFone());
        pst.setString(5, obj.getEmail());
        pst.setString(6, obj.getDate());

        if (pst.executeUpdate() > 0) {
            Database.close();
            return true;
        } else {
            Database.close();
            return false;
        }
    }

    @Override
    public boolean edit(Consumer obj) 
            throws SQLException, ClassNotFoundException{
        String sql;
        sql = "UPDATE specialclient SET name = ?, cpf = ?, "
            + "rg = ?, fone = ?, email = ?, databirth = ? "
            + "WHERE id = ?;";
        
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        pst.setString(1, obj.getName());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getFone());
        pst.setString(5, obj.getEmail());
        pst.setString(6, obj.getDate());
        pst.setInt(7, obj.getIdConsumer());
    
        if (pst.executeUpdate() > 0) {
            Database.close();
            return true;
        } else {
            Database.close();
            return false;
        }
    }
    @Override
    public boolean delete(Consumer obj) 
            throws SQLException, ClassNotFoundException {
        String sql;
        sql = "DELETE FROM specialclient "
            + "WHERE id = ?;";
        Database.open();
        
        pst = Database.getConnection().prepareStatement(sql);
        pst.setInt(1, obj.getIdConsumer());
        
        if (pst.executeUpdate() > 0)
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
        pst.setInt(1, obj.getIdConsumer());        
        rs = pst.executeQuery();
        
        if (rs.next()) {
            consumer = new Consumer();
            consumer.setIdConsumer(rs.getInt("id"));
            consumer.setName(rs.getString("name"));
            consumer.setCpf(rs.getString("cpf"));
            consumer.setRg(rs.getString("rg"));
            consumer.setFone(rs.getString("fone"));
            consumer.setEmail(rs.getString("email"));
            consumer.setDate(rs.getString("databirth"));
        }
        
        rs.close();
        Database.close();
        return consumer;
    }
    
    @Override
    public List<Consumer> list(String criterio) throws SQLException, ClassNotFoundException {
        ArrayList<Consumer> consumers = new ArrayList<>();
        consumer = null;
        String sql = "SELECT * FROM specialclient ";
        
        if(criterio.length() > 0)
            sql += "WHERE " + criterio;
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) { 
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
        }
        rs.close();
        Database.close();
        return consumers;   
    }    
}