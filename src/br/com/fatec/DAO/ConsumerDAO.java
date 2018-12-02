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
        sql = "INSERT INTO SpecialClient"
            + "(name, cpf, rg, phone, email, datebirth) "
            + "values (?, ?, ?, ?, ?, ?);";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        pst.setString(1, obj.getName());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getPhone());
        pst.setString(5, obj.getEmail());
        pst.setString(6, obj.getDateBirth());

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
        sql = "UPDATE SpecialClient SET name = ?, cpf = ?, "
            + "rg = ?, phone = ?, email = ?, datebirth = ? "
            + "WHERE id = ?;";
        
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        pst.setString(1, obj.getName());
        pst.setString(2, obj.getCpf());
        pst.setString(3, obj.getRg());
        pst.setString(4, obj.getPhone());
        pst.setString(5, obj.getEmail());
        pst.setString(6, obj.getDateBirth());
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
        sql = "DELETE FROM SpecialClient "
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
        String sql = "SELECT * FROM SpecialClient "
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
            consumer.setPhone(rs.getString("phone"));
            consumer.setEmail(rs.getString("email"));
            consumer.setDateBirth(rs.getString("datebirth"));
        }
        
        rs.close();
        Database.close();
        return consumer;
    }
    
    @Override
    public List<Consumer> list(String criterio) throws SQLException, ClassNotFoundException {
        ArrayList<Consumer> consumers = new ArrayList<>();
        consumer = null;
        String sql = "SELECT * FROM SpecialClient ";
        
        if(criterio.length() > 0)
            sql += "WHERE " + criterio;
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) { 
            consumer = new Consumer();
            consumer.setIdConsumer(rs.getInt("id"));
            consumer.setName(rs.getString("name"));
            consumer.setCpf(rs.getString("cpf"));
            consumer.setRg(rs.getString("rg"));
            consumer.setPhone(rs.getString("phone"));
            consumer.setEmail(rs.getString("email"));
            consumer.setDateBirth(rs.getString("datebirth"));
            consumers.add(consumer);
        }
        rs.close();
        Database.close();
        return consumers;   
    }    
}