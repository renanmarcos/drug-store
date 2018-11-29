package br.com.fatec.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO <tipoOBJ> {    
    public boolean insert(tipoOBJ obj) 
            throws SQLException, ClassNotFoundException;    
    public boolean edit(tipoOBJ obj) 
            throws SQLException, ClassNotFoundException;
    public boolean delete(tipoOBJ obj) 
            throws SQLException, ClassNotFoundException;
    public tipoOBJ search(tipoOBJ obj) 
            throws SQLException, ClassNotFoundException;
    public List<tipoOBJ> list(String criterio) 
            throws SQLException, ClassNotFoundException;    
}
