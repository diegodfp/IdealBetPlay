package com.betplay.model.entity;

import java.util.List;

public class Jugador {
  private int au = 0;
  private int id;
  private String nombre;
  private int edad;
  private String posicion;
  private String nacionalidad;
  private int numeroCamiseta;
  private int idEquipo;
  private List<Lesiones> lstLesiones;
  private List<Rendimiento> ldtRendimiento;
  public Jugador() {
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
  public int getEdad() {
    return edad;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }
  public String getPosicion() {
    return posicion;
  }
  public void setPosicion(String posicion) {
    this.posicion = posicion;
  }
  public String getNacionalidad() {
    return nacionalidad;
  }
  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }
  public int getNumeroCamiseta() {
    return numeroCamiseta;
  }
  public void setNumeroCamiseta(int numeroCamiseta) {
    this.numeroCamiseta = numeroCamiseta;
  }
  public int getEquipo() {
    return idEquipo;
  }
  public void setEquipo(int idEquipo) {
    this.idEquipo = idEquipo;
  }
  public List<Lesiones> getLstLesiones() {
    return lstLesiones;
  }
  public void setLstLesiones(List<Lesiones> lstLesiones) {
    this.lstLesiones = lstLesiones;
  }
  public List<Rendimiento> getLdtRendimiento() {
    return ldtRendimiento;
  }
  public void setLdtRendimiento(List<Rendimiento> ldtRendimiento) {
    this.ldtRendimiento = ldtRendimiento;
  }
  public Jugador(String nombre, int edad, String posicion, String nacionalidad, int numeroCamiseta,
      int idEquipo, List<Lesiones> lstLesiones, List<Rendimiento> ldtRendimiento) {
    this.id = au++;
    this.nombre = nombre;
    this.edad = edad;
    this.posicion = posicion;
    this.nacionalidad = nacionalidad;
    this.numeroCamiseta = numeroCamiseta;
    this.idEquipo = idEquipo;
    this.lstLesiones = lstLesiones;
    this.ldtRendimiento = ldtRendimiento;
  }
  

  

}
