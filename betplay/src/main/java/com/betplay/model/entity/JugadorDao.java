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

public class JugadorDao /*implements Dao*/ {
    private Connection connection;
    public JugadorDao(){
        try{
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url,user,password);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
    public void addJugador(Jugador jugador) throws SQLException {
        String query = "INSERT INTO jugador(nombre,edad,posicion,nacionalidad,dorsal,idEquipo)VALUES(?,?,?,?,?,?);";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, jugador.getNombre());
        ps.setInt(2, jugador.getEdad());
        ps.setString(3, jugador.getPosicion());
        ps.setString(4, jugador.getNacionalidad());
        ps.setInt(5, jugador.getNumeroCamiseta());
        ps.setInt(6,jugador.getEquipo());
        ps.executeUpdate();
    }

    public List<String> getJugador(String nombreJ) throws SQLException {
        String query = "SELECT J.nombre,J.edad,J.posicion,J.nacionalidad,J.dorsal,E.nombre AS nombreE FROM jugador J INNER JOIN equipo E ON J.idEquipo = E.id WHERE J.nombre = ?;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<String> data = new ArrayList<>();
        data.add(rs.getString("nombre"));
        data.add(String.valueOf(rs.getInt("edad")));
        data.add(rs.getString("posicion"));
        data.add(rs.getString("nacionalidad"));
        data.add(String.valueOf(rs.getInt("dorsal")));
        data.add(rs.getString("nombreE"));
        return data;
    }

    public void updateJugador(Jugador jugador) throws SQLException {
        String query = "UPDATE jugador SET nombre = ?, edad  = ?, posicion = ?, nacionalidad = ?, dorsal = ?, idEquipo = ?;";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, jugador.getNombre());
        ps.setInt(2, jugador.getEdad());
        ps.setString(3, jugador.getPosicion());
        ps.setString(4, jugador.getNacionalidad());
        ps.setInt(5, jugador.getNumeroCamiseta());
        ps.setInt(6, jugador.getEquipo());
        ps.executeUpdate();
    }

    public void deleteJugador(String nombreJ) throws SQLException{
        String query = "DELETE FROM jugador WHERE nombre = ?;";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, nombreJ);
        ps.executeUpdate();
    }

}
