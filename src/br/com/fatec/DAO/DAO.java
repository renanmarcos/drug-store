/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Matheus1
 */
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
