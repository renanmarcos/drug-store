package br.com.fatec.DAO;

import br.com.fatec.database.Database;
import br.com.fatec.model.Consumer;
import br.com.fatec.model.Drug;
import br.com.fatec.model.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDAO implements DAO <Order> {
    private Order order; 
    private PreparedStatement pst; 
    private ResultSet rs;
    private PreparedStatement pst2; 
    private ResultSet rs2;
    
    @Override
    public boolean insert(Order obj) 
            throws SQLException, ClassNotFoundException {
            String sql;
        sql = "INSERT INTO OrderInfo"
            + "(date_ordered, time_ordered, subtotal, discount, freight, total,"
                + " special_client_id) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql, 
                Statement.RETURN_GENERATED_KEYS);        
        pst.setDate(1, Date.valueOf(obj.getDateOrdered()));
        pst.setTime(2, Time.valueOf(obj.getTimeOrdered()));
        float subtotal = 0;
        for (Map.Entry<Drug, Integer> entry : obj.getEntrySet()) {            
            subtotal += entry.getKey().getUnitprice() * entry.getValue();
        }
        float discount = obj.getDiscount();
        float freight = obj.getFreight();
        pst.setFloat(3, subtotal);
        pst.setFloat(4, discount);
        pst.setFloat(5, freight);
        pst.setFloat(6, (subtotal + freight) - discount);
        if (obj.getSpecialClient().getIdConsumer() == -1)
            pst.setNull(7, java.sql.Types.NULL);
        else
            pst.setInt(7, obj.getSpecialClient().getIdConsumer());

        if (pst.executeUpdate() > 0) {
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {    
                int orderId = generatedKeys.getInt(1);
                for (Map.Entry<Drug, Integer> entry : obj.getEntrySet()) { 
                    sql = "INSERT INTO OrderItems"
                            + "(order_id, drug_id, quantity) "
                            + "VALUES (?, ?, ?);";
                    pst = Database.getConnection().prepareStatement(sql);            
                    pst.setInt(1, orderId);       
                    pst.setInt(2, entry.getKey().getIdDrug());
                    pst.setInt(3, entry.getValue());
                    if (pst.executeUpdate() <= 0) break;
                }                
                Database.close();
                return true;
            } else {
                Database.close();
                return false;
            }
        } else {
            Database.close();
            return false;
        }
    }

    @Override
    public boolean edit(Order obj) 
            throws SQLException, ClassNotFoundException{
        String sql;
        sql = "UPDATE OrderInfo SET date_ordered = ?, time_ordered = ?, "
            + "subtotal = ?, discount = ?, freight = ?, total = ?,"
                + " special_client_id = ? WHERE id = ?;";
        
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);        
        pst.setDate(1, Date.valueOf(obj.getDateOrdered()));
        pst.setTime(2, Time.valueOf(obj.getTimeOrdered()));
        float subtotal = 0;
        for (Map.Entry<Drug, Integer> entry : obj.getEntrySet()) {            
            subtotal += entry.getKey().getUnitprice() * entry.getValue();
        }
        float discount = obj.getDiscount();
        float freight = obj.getFreight();
        pst.setFloat(3, subtotal);
        pst.setFloat(4, discount);
        pst.setFloat(5, freight);
        pst.setFloat(6, (subtotal + freight) - discount);
        pst.setFloat(7, obj.getId());
        pst.setInt(8, obj.getSpecialClient().getIdConsumer());

        if (pst.executeUpdate() > 0) {               
            int orderId = obj.getId();
            for (Map.Entry<Drug, Integer> entry : obj.getEntrySet()) { 
                sql = "UPDATE OrderItems SET "
                        + "drug_id = ?, quantity = ? WHERE order_id = ?;";
                pst = Database.getConnection().prepareStatement(sql);        
                pst.setInt(1, entry.getKey().getIdDrug());
                pst.setInt(2, entry.getValue());
                pst.setInt(3, orderId);
                if (pst.executeUpdate() <= 0) break;
            }
                Database.close();
                return true;       
        } else {
            Database.close();
            return false;
        }
    }
    @Override
    public boolean delete(Order obj) 
            throws SQLException, ClassNotFoundException {
        String sql;
        sql = "DELETE FROM OrderInfo "
            + "WHERE id = ?;";
        Database.open();
        
        pst = Database.getConnection().prepareStatement(sql);
        pst.setInt(1, obj.getId());
        
        if (pst.executeUpdate() > 0)
            return true;
        else 
            return false;
    }

    @Override
    public Order search(Order obj) 
            throws SQLException, ClassNotFoundException {
        order = null;
        String sql = "SELECT * FROM OrderInfo "
                   + "WHERE id = ?;";
        Database.open();
        Connection con = Database.getConnection();
        con.setAutoCommit(false);
        pst = con.prepareStatement(sql);
        int orderId = obj.getId();
        pst.setInt(1, orderId);        
        rs = pst.executeQuery();
        
        if (rs.next()) {
            order = new Order();
            order.setId(orderId);
            order.setDateOrdered(rs.getDate("date_ordered").toLocalDate());
            order.setTimeOrdered(rs.getTime("time_ordered").toLocalTime());
            order.setDiscount(rs.getFloat("discount"));
            order.setFreight(rs.getFloat("freight"));
            order.setTotal(rs.getFloat("total"));
            ConsumerDAO consumerDAO = new ConsumerDAO();
            Consumer consumer = new Consumer();
            consumer.setIdConsumer(rs.getInt("special_client_id"));
            if (rs.wasNull()) {
                consumer.setIdConsumer(-1);
            } else {
                consumer = consumerDAO.search(consumer);
            }            
            order.setSpecialClient(consumer);
            
            sql = "SELECT * FROM OrderItems "
                   + "WHERE order_id = ?;";
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);        
            rs = pst.executeQuery();
            
            while (rs.next()) {
                DrugDAO drugDAO = new DrugDAO();
                Drug drug = new Drug();
                drug.setIdDrug(rs.getInt("drug_id"));
                drug = drugDAO.search(drug);
                order.addDrug(drug, rs.getInt("quantity"));
            }
        }
        
        rs.close();
        Database.close();
        return order;
    }
    
    @Override
    public List<Order> list(String criterio) throws SQLException, ClassNotFoundException {
        ArrayList<Order> orders = new ArrayList<>();
        order = null;
        String sql = "SELECT * FROM OrderInfo ";
        
        if(criterio.length() > 0)
            sql += "WHERE " + criterio;
        Database.open();
        Connection con = Database.getConnection();
        con.setAutoCommit(false);
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) { 
            order = new Order();
            int orderId = rs.getInt("id");
            order.setId(orderId);
            order.setDateOrdered(rs.getDate("date_ordered").toLocalDate());
            order.setTimeOrdered(rs.getTime("time_ordered").toLocalTime());
            order.setDiscount(rs.getFloat("discount"));
            order.setFreight(rs.getFloat("freight"));
            order.setTotal(rs.getFloat("total"));
            ConsumerDAO consumerDAO = new ConsumerDAO();
            Consumer consumer = new Consumer();            
            consumer.setIdConsumer(rs.getInt("special_client_id"));
            if (rs.wasNull()) {
                consumer.setIdConsumer(-1);
            } else {
                consumer = consumerDAO.search(consumer);                
            }     
            order.setSpecialClient(consumer);
            
            String sql2 = "SELECT * FROM OrderItems "
                   + "WHERE order_id = ?;";
            pst2 = con.prepareStatement(sql2);
            pst2.setInt(1, orderId);        
            rs2 = pst2.executeQuery();
            
            while (rs2.next()) {
                DrugDAO drugDAO = new DrugDAO();
                Drug drug = new Drug();
                drug.setIdDrug(rs2.getInt("drug_id"));
                drug = drugDAO.search(drug);
                order.addDrug(drug, rs2.getInt("quantity"));
            }
            rs2.close();
            orders.add(order);
        }
        rs.close();
        Database.close();
        return orders;   
    }    
}