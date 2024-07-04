package com.betplay.model.entity;

public class Permiso {
    private int id;
    private String descripcion;
    private int idRol;
    
    public Permiso() {
    }
    public Permiso(int id, String descripcion, int idRol) {
        this.id = id;
        this.descripcion = descripcion;
        this.idRol = idRol;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getIdRol() {
        return idRol;
    }
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    
}
