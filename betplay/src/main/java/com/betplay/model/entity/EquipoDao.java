package com.betplay.model.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class EquipoDao {
    private Connection connection;
    public EquipoDao(){
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
