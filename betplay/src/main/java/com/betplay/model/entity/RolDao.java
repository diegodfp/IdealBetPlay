package com.betplay.model.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RolDao {
    private Connection connection;

    public RolDao() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public void addRol(Rol rol) throws SQLException {
        String query = "INSERT INTO Rol (nombre) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, rol.getNombre());
        ps.executeUpdate();
    }

    public List<Rol> getAllRoles() throws SQLException {
        List<Rol> roles = new ArrayList<>();
        String query = "SELECT * FROM Rol";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Rol rol = new Rol(rs.getInt("idRol"), rs.getString("nombre"));
            roles.add(rol);
        }
        return roles;
    }

    public void updateRol(Rol rol) throws SQLException {
        String query = "UPDATE Rol SET nombre = ? WHERE idRol = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, rol.getNombre());
        ps.setInt(2, rol.getId());
        ps.executeUpdate();
    }

    public void deleteRol(int idRol) throws SQLException {
        String query = "DELETE FROM Rol WHERE idRol = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idRol);
        ps.executeUpdate();
    }
}
