package com.betplay.model.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PartidoDao {
    private Connection connection;

    public PartidoDao() {
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

    public void addPartido(Partido partido) throws SQLException {
        String query = "INSERT INTO partido (idEquipoLocal, idEquipoVisitante, fecha, hora, idEstadio, golesLocal, golesVisitante) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, partido.getIdEquipoLocal());
        ps.setInt(2, partido.getIdEquipoVisitante());
        ps.setDate(3, Date.valueOf(partido.getFecha()));
        ps.setTime(4, Time.valueOf(partido.getHora() + ":00"));
        ps.setInt(5, partido.getIdEstadio());
        ps.setInt(6, partido.getGolesLocal());
        ps.setInt(7, partido.getGolesVisitante());
        ps.executeUpdate();
    }

    public List<Partido> getAllPartidos() throws SQLException {
        List<Partido> partidos = new ArrayList<>();
        String query = "SELECT * FROM partido";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            Partido partido = new Partido(
                rs.getInt("id"),
                rs.getInt("idEquipoLocal"),
                rs.getInt("idEquipoVisitante"),
                rs.getDate("fecha"),
                rs.getTime("hora"),
                rs.getInt("idEstadio"),
                rs.getInt("golesLocal"),
                rs.getInt("golesVisitante")
            );
            partidos.add(partido);
        }
        return partidos;
    }

    public void updatePartido(Partido partido) throws SQLException {
        String query = "UPDATE partido SET idEquipoLocal = ?, idEquipoVisitante = ?, fecha = ?, hora = ?, idEstadio = ?, golesLocal = ?, golesVisitante = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, partido.getIdEquipoLocal());
        ps.setInt(2, partido.getIdEquipoVisitante());
        ps.setDate(3, Date.valueOf(partido.getFecha()));
        ps.setTime(4, Time.valueOf(partido.getHora() + ":00"));
        ps.setInt(5, partido.getIdEstadio());
        ps.setInt(6, partido.getGolesLocal());
        ps.setInt(7, partido.getGolesVisitante());
        ps.setInt(8, partido.getId());
        ps.executeUpdate();
    }

    public void deletePartido(int id) throws SQLException {
        String query = "DELETE FROM partido WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }


}
