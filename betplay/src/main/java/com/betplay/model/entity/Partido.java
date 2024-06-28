package com.betplay.model.entity;

import java.sql.Date;
import java.util.List;

public class Partido {
    private String id;
    private String equipoLocal;
    private String equipoVisitante;
    private String fecha;
    private String hora;
    private Estadio estadio;
    private List<Gol> lstGoles;
    private List<Tarjeta> lstTarjetas;
    private List<Incidente> lstIncidentes;
    private String resultado;

    
}
