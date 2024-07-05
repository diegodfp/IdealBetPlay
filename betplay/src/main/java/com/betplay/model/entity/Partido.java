package com.betplay.model.entity;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

public class Partido {
    private int id;
    private int idEquipoLocal;
    private int idEquipoVisitante;
    private Date fecha;
    private Time hora;
    private int idEstadio;
    private List<Gol> lstGoles;
    private List<Tarjeta> lstTarjetas;
    private List<Incidente> lstIncidentes;
    private int golesLocal;
    private int golesVisitante;
    

    public Partido() {
    }
    




    public Partido(int id, int idEquipoLocal, int idEquipoVisitante, Date fecha, Time hora, int idEstadio,
            int golesLocal, int golesVisitante) {
        this.id = id;
        this.idEquipoLocal = idEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.fecha = fecha;
        this.hora = hora;
        this.idEstadio = idEstadio;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }





    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }


    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }


    public int getIdEquipoVisitante() {
        return idEquipoVisitante;
    }


    public void setIdEquipoVisitante(int idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }


    public String getFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha);
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Time getHora() {
        return hora;
    }


    public void setHora(Time hora) {
        this.hora = hora;
    }


    public int getIdEstadio() {
        return idEstadio;
    }


    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }


    public List<Gol> getLstGoles() {
        return lstGoles;
    }


    public void setLstGoles(List<Gol> lstGoles) {
        this.lstGoles = lstGoles;
    }


    public List<Tarjeta> getLstTarjetas() {
        return lstTarjetas;
    }


    public void setLstTarjetas(List<Tarjeta> lstTarjetas) {
        this.lstTarjetas = lstTarjetas;
    }


    public List<Incidente> getLstIncidentes() {
        return lstIncidentes;
    }


    public void setLstIncidentes(List<Incidente> lstIncidentes) {
        this.lstIncidentes = lstIncidentes;
    }


    public int getGolesLocal() {
        return golesLocal;
    }


    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }


    public int getGolesVisitante() {
        return golesVisitante;
    }


    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

        
}
