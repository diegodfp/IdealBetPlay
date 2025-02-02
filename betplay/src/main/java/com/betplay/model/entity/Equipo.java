package com.betplay.model.entity;

import java.util.List;

public class Equipo {
    private int id;
    private String nombre;
    private String ciudad;
    private int idEstadio;
    private String entrenador;
    private List<Jugador> listJugadores;
    private List<Partido> listPartidos;

    
    
    public Equipo() {
    }

    
    public Equipo(int id, String nombre, String ciudad, int idEstadio, String entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.idEstadio = idEstadio;
        this.entrenador = entrenador;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
   
    public String getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }
    public int getIdEstadio() {
        return idEstadio;
    }
    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }
    public List<Jugador> getListJugadores() {
        return listJugadores;
    }
    public void setListJugadores(Jugador jugador) {
        this.listJugadores.add(jugador);
    }
    public List<Partido> getListPartidos() {
        return listPartidos;
    }
    public void setListPartidos(Partido partido) {
        this.listPartidos.add(partido);
    }
}
