package br.com.fatec.DAO;

import br.com.fatec.database.Database;
import br.com.fatec.model.Cashier;
import br.com.fatec.model.CashierLog;
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

public class CashierDAO implements DAO <Cashier> {
    private Cashier cashier; 
    private PreparedStatement pst; 
    private ResultSet rs;
    private PreparedStatement pst2; 
    private ResultSet rs2;
    
    @Override
    public boolean insert(Cashier obj) 
            throws SQLException, ClassNotFoundException {
        String sql;
        sql = "INSERT INTO Cashier (current_status) VALUES (DEFAULT)";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);     
        
        if (pst.executeUpdate() > 0) {
            Database.close();
            return true;            
        } else {
            Database.close();
            return false;
        }
    }
    
    public boolean insert(CashierLog obj, int cashierNumber) 
            throws SQLException, ClassNotFoundException {
        String sql;
        sql = "INSERT INTO CashierLog "
                + "(cashier_number, date_recorded, time_recorded, status) "
                + "VALUES (?, ?, ?, ?)";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql); 
        pst.setInt(1, cashierNumber);
        pst.setDate(2, Date.valueOf(obj.getDateRecorded()));
        pst.setTime(3, Time.valueOf(obj.getTimeRecorded()));
        pst.setString(4, obj.getStatus());
        
        if (pst.executeUpdate() > 0) {
            Database.close();
            return true;            
        } else {
            Database.close();
            return false;
        }
    }

    @Override
    public boolean edit(Cashier obj) 
            throws SQLException, ClassNotFoundException{
        String sql = "UPDATE Cashier SET current_status = ? WHERE number = ?";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql); 
        pst.setString(1, obj.getCurrentStatus());
        pst.setInt(2, obj.getNumber());
        
        if (pst.executeUpdate() > 0) {
            Database.close();
            return true;            
        } else {
            Database.close();
            return false;
        }
    }
    
    @Override
    public boolean delete(Cashier obj) 
            throws SQLException, ClassNotFoundException {
        String sql;
        sql = "DELETE FROM Cashier "
            + "WHERE number = ?";
        Database.open();
        
        pst = Database.getConnection().prepareStatement(sql);
        pst.setInt(1, obj.getNumber());
        
        if (pst.executeUpdate() > 0)
            return true;
        else 
            return false;
    }

    @Override
    public Cashier search(Cashier obj) 
            throws SQLException, ClassNotFoundException {
        cashier = null;
        String sql = "SELECT * FROM Cashier "
                   + "WHERE number = ?";
        Database.open();
        Connection con = Database.getConnection();
        con.setAutoCommit(false);
        pst = con.prepareStatement(sql);
        int cashierNumber = obj.getNumber();
        pst.setInt(1, cashierNumber);        
        rs = pst.executeQuery();
        
        if (rs.next()) {
            cashier = new Cashier();
            cashier.setNumber(cashierNumber);
            cashier.setCurrentStatus(rs.getString("current_status"));
            
            sql = "SELECT * FROM CashierLog "
                   + "WHERE cashier_number = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cashierNumber);        
            rs = pst.executeQuery();
            
            while (rs.next()) {
                CashierLog log = new CashierLog();
                log.setId(rs.getInt("id"));
                log.setDateRecorded(rs.getDate("date_recorded").toLocalDate());
                log.setTimeRecorded(rs.getTime("time_recorded").toLocalTime());
                log.setStatus(rs.getString("status"));
                cashier.addLog(log);
            }
        }
        
        rs.close();
        Database.close();
        return cashier;
    }
    
    @Override
    public List<Cashier> list(String criterio) throws SQLException, ClassNotFoundException {
        ArrayList<Cashier> cashiers = new ArrayList<>();
        cashier = null;
        String sql = "SELECT * FROM Cashier ";
        
        if(criterio.length() > 0)
            sql += "WHERE " + criterio;
        Database.open();
        Connection con = Database.getConnection();
        con.setAutoCommit(false);
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) { 
            cashier = new Cashier();
            cashier.setNumber(rs.getInt("number"));
            
            sql = "SELECT * FROM CashierLog "
                   + "WHERE cashier_number = ?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, cashier.getNumber());        
            rs2 = pst.executeQuery();
            
            while (rs2.next()) {
                CashierLog log = new CashierLog();
                log.setId(rs2.getInt("id"));
                log.setDateRecorded(rs2.getDate("date_recorded").toLocalDate());
                log.setTimeRecorded(rs2.getTime("time_recorded").toLocalTime());
                log.setStatus(rs2.getString("status"));
                cashier.addLog(log);
            }
            rs2.close();
            cashiers.add(cashier);
        }
        rs.close();
        Database.close();
        return cashiers;   
    }    
}