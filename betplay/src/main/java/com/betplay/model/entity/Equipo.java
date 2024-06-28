package com.betplay.model.entity;

import java.util.List;

public class Equipo {
    private String id;
    private String nombre;
    private String ciudad;
    private String estadio;
    private String entrenador;
    private List<Jugador> listJugadores;
    private List<Partido> listPartidos;

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public String getEstadio() {
        return estadio;
    }
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }
    public String getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
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
