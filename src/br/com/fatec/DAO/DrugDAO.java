package br.com.fatec.DAO;

import br.com.fatec.database.Database;
import br.com.fatec.model.Drug;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDAO implements DAO <Drug> {
    private Drug drug; 
    private PreparedStatement pst; 
    private ResultSet rs;
    @Override
    public boolean insert(Drug obj) 
            throws SQLException, ClassNotFoundException {
            String sql;
        sql = "INSERT INTO Drug "
            + "(com_name, type_drug, lab, is_generic, need_pre, unit_price, desc_drug, dateshelf) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?);";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        pst.setString(1, obj.getComname());
        pst.setString(2, obj.getTypedrug());
        pst.setString(3, obj.getLab());
        pst.setInt(4, obj.getIsgeneric());
        pst.setInt(5, obj.getNeedpre());
        pst.setFloat(6, obj.getUnitprice());
        pst.setString(7, obj.getDescdrug());
        pst.setString(8, obj.getDateshelf());
        if (pst.executeUpdate() > 0) {
            Database.close();
            return true;
        } else {
            Database.close();
            return false;
        }
    }
    @Override
    public boolean edit(Drug obj) 
            throws SQLException, ClassNotFoundException{
        String sql;
        sql = "UPDATE Drug SET com_name = ?, type_drug = ?, lab = ?, "
            + "is_generic = ?, need_pre = ?, unit_price = ?, desc_drug = ?, dateshelf = ? "
            + "WHERE id = ?;";
        
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        pst.setString(1, obj.getComname());
        pst.setString(2, obj.getTypedrug());
        pst.setString(3, obj.getLab());
        pst.setInt(4, obj.getIsgeneric());
        pst.setInt(5, obj.getNeedpre());
        pst.setFloat(6, obj.getUnitprice());
        pst.setString(7, obj.getDescdrug());
        pst.setString(8, obj.getDateshelf());
        pst.setInt(9, obj.getIdDrug());
    
        if (pst.executeUpdate() > 0) {
            Database.close();
            return true;
        } else {
            Database.close();
            return false;
        }
    }
    @Override
    public boolean delete(Drug obj) 
            throws SQLException, ClassNotFoundException {
        String sql;
        sql = "DELETE FROM Drug "
            + "WHERE id = ?;";
        Database.open();
        
        pst = Database.getConnection().prepareStatement(sql);
        pst.setInt(1, obj.getIdDrug());
        
        if (pst.executeUpdate() > 0)
            return true;
        else 
            return false;
    }
    @Override
    public Drug search(Drug obj) 
            throws SQLException, ClassNotFoundException {
        drug = null;
        String sql = "SELECT * FROM Drug "
                   + "WHERE id = ?;";
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        pst.setInt(1, obj.getIdDrug());        
        rs = pst.executeQuery();
        if (rs.next()) {
            drug = new Drug();
            drug.setIdDrug(rs.getInt("id"));
            drug.setComname(rs.getString("com_name"));
            drug.setTypedrug(rs.getString("type_drug"));
            drug.setLab(rs.getString("lab"));
            drug.setIsgeneric(rs.getInt("is_generic"));
            drug.setNeedpre(rs.getInt("need_pre"));
            drug.setUnitprice(rs.getFloat("unit_price"));
            drug.setDescdrug(rs.getString("desc_drug"));
            drug.setDateshelf(rs.getString("dateshelf"));
        }
        
        rs.close();
        Database.close();
        return drug;
    }
    
    @Override
    public List<Drug> list(String criterio) throws SQLException, ClassNotFoundException {
        ArrayList<Drug> drugs = new ArrayList<>();
        drug = null;
        String sql = "SELECT * FROM Drug ";
        
        if(criterio.length() > 0)
            sql += "WHERE " + criterio;
        Database.open();
        pst = Database.getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) { 
            drug = new Drug();
            drug.setIdDrug(rs.getInt("id"));
            drug.setComname(rs.getString("com_name"));
            drug.setTypedrug(rs.getString("type_drug"));
            drug.setLab(rs.getString("lab"));
            drug.setIsgeneric(rs.getInt("is_generic"));
            drug.setNeedpre(rs.getInt("need_pre"));
            drug.setUnitprice(rs.getFloat("unit_price"));
            drug.setDescdrug(rs.getString("desc_drug"));
            drug.setDateshelf(rs.getString("dateshelf"));
            drugs.add(drug);
        }
        rs.close();
        Database.close();
        return drugs;   
    }    
}