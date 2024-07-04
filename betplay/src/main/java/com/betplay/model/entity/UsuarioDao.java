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

public class UsuarioDao {
 private Connection connection;

    public UsuarioDao() {
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
     /// VERIFICACION USUARIOS EN EL LOGGIN /// 
     public Usuario getUsuarioByCredentials(String usuario, String contrasena) throws SQLException {
        try {
            String query = "SELECT * FROM Usuario WHERE nombre = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario user = new Usuario();
                user.setId(rs.getInt("idUsuario"));
                user.setNombre(rs.getString("nombre"));
                user.setPassword(rs.getString("password"));
                user.setIdRol(rs.getInt("Rol_idRol"));
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new SQLException("Error al obtener usuario por credenciales: " + e.getMessage());
        }
    }

 

    public String obtenerRolUsuario(String usuario) {
        try {
            String query = "SELECT r.nombre FROM Usuario u " +
                           "JOIN Rol r ON u.Rol_idRol = r.idRol " +
                           "WHERE u.nombre = ?";
            
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, usuario);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("nombre");
                    } else {
                        System.out.println("Usuario no encontrado.");
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener rol del usuario: " + e.getMessage());
            return null;
        }
    }

    ////// CRUD ////

    public void addUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO Usuario (nombre, email, password, Rol_idRol) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getPassword());
        ps.setInt(4, usuario.getIdRol());
        ps.executeUpdate();
    }

    public List<Usuario> getAllUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM Usuario";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Usuario usuario = new Usuario(
                rs.getInt("idUsuario"),
                rs.getString("nombre"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getInt("Rol_idRol")
            );
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public void updateUsuario(Usuario usuario) throws SQLException {
        String query = "UPDATE Usuario SET nombre = ?, email = ?, password = ?, Rol_idRol = ? WHERE idUsuario = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getPassword());
        ps.setInt(4, usuario.getIdRol());
        ps.setInt(5, usuario.getId());
        ps.executeUpdate();
    }

    public void deleteUsuario(int idUsuario) throws SQLException {
        String query = "DELETE FROM Usuario WHERE idUsuario = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idUsuario);
        ps.executeUpdate();
    }
}
