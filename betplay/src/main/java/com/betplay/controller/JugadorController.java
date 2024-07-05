package com.betplay.controller;

import java.sql.SQLException;

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
                
                    default:
                        break;
                }
            }
        }
    }
    public void agregar() throws SQLException{
        System.out.println("Insertar datos del jugador");
        
    }
}
