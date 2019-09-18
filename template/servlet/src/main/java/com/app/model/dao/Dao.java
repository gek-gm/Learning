package com.app.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public interface Dao<T> {
    
    public List<T> getAll();
    public void save(T object);
    
    public static Connection getConnection()  {
        DataSource _ds;
        try {
            _ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/ds");
            return _ds.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
