package com.betplay.controller;

import java.sql.SQLException;
import java.util.List;

import com.betplay.model.entity.Partido;
import com.betplay.model.entity.PartidoDao;
import com.betplay.view.PartidoView;

public class PartidosController {
    private PartidoView view;
    private PartidoDao dao;



    public PartidosController(PartidoView view, PartidoDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void start() {
        while (true) {
            int choice = view.showMenu();
            try {
                switch (choice) {
                    case 1:
                        addPartido();
                        break;
                    case 2:
                        listPartidos();
                        break;
                    case 3:
                        updatePartido();
                        break;
                    case 4:
                        deletePartido();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        view.showMessage("Opción no válida.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addPartido() throws SQLException {
        Partido partido = view.getPartidoDetails();
        dao.addPartido(partido);
        view.showMessage("Partido añadido exitosamente.");
    }

    private void listPartidos() throws SQLException {
        List<Partido> partidos = dao.getAllPartidos();
        view.showPartidos(partidos);
    }



    private void updatePartido() throws SQLException {
        int id = view.getPartidoId();
        Partido partido = view.getPartidoDetails();
        partido.setId(id);
        dao.updatePartido(partido); 
    }

    private void deletePartido() throws SQLException {
        int id = view.getPartidoId();
        dao.deletePartido(id);
        view.showMessage("Partido eliminado exitosamente.");
    }
}
