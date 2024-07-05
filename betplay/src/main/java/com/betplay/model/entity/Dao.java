package com.betplay.model.entity;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    public void add(T coso) throws SQLException;
    public List<T> get()throws SQLException;
    public void update(T coso)throws SQLException;
    public void delete(int id)throws SQLException;
    }

