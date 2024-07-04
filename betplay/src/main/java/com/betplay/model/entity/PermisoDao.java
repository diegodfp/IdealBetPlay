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

public class PermisoDao {
    private Connection connection;

    public PermisoDao() {
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

    public void addPermiso(Permiso permiso) throws SQLException {
        String query = "INSERT INTO Permiso (descripcion, Rol_idRol) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, permiso.getDescripcion());
        ps.setInt(2, permiso.getId());
        ps.executeUpdate();
    }

    public List<Permiso> getAllPermisos() throws SQLException {
        List<Permiso> permisos = new ArrayList<>();
        String query = "SELECT * FROM Permiso";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Permiso permiso = new Permiso(rs.getInt("idPermiso"), rs.getString("descripcion"), rs.getInt("Rol_idRol"));
            permisos.add(permiso);
        }
        return permisos;
    }

    public void updatePermiso(Permiso permiso) throws SQLException {
        String query = "UPDATE Permiso SET descripcion = ?, Rol_idRol = ? WHERE idPermiso = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, permiso.getDescripcion());
        ps.setInt(2, permiso.getId());
        ps.setInt(3, permiso.getIdRol());
        ps.executeUpdate();
    }

    public void deletePermiso(int id) throws SQLException {
        String query = "DELETE FROM Permiso WHERE idPermiso = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
