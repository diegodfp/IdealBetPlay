package com.betplay.controller;

import java.sql.SQLException;
import java.util.List;

import com.betplay.model.entity.Jugador;
import com.betplay.model.entity.JugadorDao;
import com.betplay.view.JugadorView;
import com.mysql.cj.jdbc.exceptions.SQLError;

public class JugadorController {
    private JugadorDao dao;
    private JugadorView view;

    public JugadorController(JugadorDao dao, JugadorView view){
        this.dao = dao;
        this.view = view;
    }

    public void start(){
        while(true){
            int choice = view.menu();
            try{
                switch (choice) {
                    case 1:
                        agregar();
                        break;
                    case 2:
                        obtener();
                    default:
                        break;
                }
            }
        }
    }
    public void agregar() throws SQLException{
        try{
            System.out.println("Insertar datos del jugador");
            Jugador jugador = view.getDataPlayer();
            dao.addJugador(jugador);
            System.out.println("Jugador agregado con éxito!");
            }catch(Exception e){
                e.getStackTrace();
            }
    }
    public void obtener() throws SQLException{
        try{
            String name = view.getNamePlayerRequired();
            List<String> jugador  = dao.getJugador(name);
            view.mostrarJugador(jugador);
        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
}
