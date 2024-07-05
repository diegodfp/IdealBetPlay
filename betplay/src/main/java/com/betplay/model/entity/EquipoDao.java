package com.betplay.model.entity;
<<<<<<< HEAD

import java.sql.Connection;
import java.sql.DriverManager;
=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
>>>>>>> main
import java.util.Properties;

public class EquipoDao {
    private Connection connection;
<<<<<<< HEAD
    public EquipoDao(){
=======

    public EquipoDao() {
>>>>>>> main
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
<<<<<<< HEAD
            connection = DriverManager.getConnection(url,user,password);
=======
            connection = DriverManager.getConnection(url, user, password);
>>>>>>> main
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
=======

    public void addEquipo(Equipo equipo) throws SQLException {
        String query = "INSERT INTO equipo (nombre, ciudad, idEstadio, nombreEntrenador) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, equipo.getNombre());
        ps.setString(2, equipo.getCiudad());
        ps.setInt(3, equipo.getIdEstadio());
        ps.setString(4, equipo.getEntrenador());
        ps.executeUpdate();
    }

    public List<Equipo> getAllEquipos() throws SQLException {
        List<Equipo> equipos = new ArrayList<>();
        String query = "SELECT * FROM equipo";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Equipo equipo = new Equipo(
                rs.getInt("id"), 
                rs.getString("nombre"), 
                rs.getString("ciudad"), 
                rs.getInt("idEstadio"), 
                rs.getString("nombreEntrenador")
            );
            equipos.add(equipo);
        }
        return equipos;
    }

    public void updateEquipo(Equipo equipo) throws SQLException {
        String query = "UPDATE equipo SET nombre = ?, ciudad = ?, idEstadio = ?, nombreEntrenador = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, equipo.getNombre());
        ps.setString(2, equipo.getCiudad());
        ps.setInt(3, equipo.getIdEstadio());
        ps.setString(4, equipo.getEntrenador());
        ps.setInt(5, equipo.getId());
        ps.executeUpdate();
    }

    public void deleteEquipo(int id) throws SQLException {
        String query = "DELETE FROM equipo WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public String obtenerNombreEstadio(int idEstadio){
        try {
            String query = "SELECT e.nombre FROM estadio e " +
                           "JOIN equipo eq ON eq.idEstadio = e.id " +
                           "WHERE e.id = ?";
            
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, idEstadio);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getString("nombre");
                    } else {
                        System.out.println("Estadio no encontrado.");
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del estadio " + e.getMessage());
            return null;
        }
    }
>>>>>>> main
}
