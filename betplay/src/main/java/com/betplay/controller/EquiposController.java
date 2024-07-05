package com.betplay.controller;


import java.sql.SQLException;
import java.util.List;

import com.betplay.model.entity.Equipo;
import com.betplay.model.entity.EquipoDao;
import com.betplay.view.EquipoView;

public class EquiposController {
    private EquipoView view;
    private EquipoDao dao;

    public EquiposController(EquipoView view, EquipoDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void start() {
        while (true) {
            int choice = view.showMenu();
            try {
                switch (choice) {
                    case 1:
                        addEquipo();
                        break;
                    case 2:
                        listEquipos();
                        break;
                    case 3:
                        updateEquipo();
                        break;
                    case 4:
                        deleteEquipo();
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

    private void addEquipo() throws SQLException {
        Equipo equipo = view.getEquipoDetails();
        dao.addEquipo(equipo);
        view.showMessage("Equipo añadido exitosamente.");
    }

    private void listEquipos() throws SQLException {
        List<Equipo> equipos = dao.getAllEquipos();
        view.showEquipos(equipos);
    }

    private void updateEquipo() throws SQLException {
        int id = view.getEquipoId();
        Equipo equipo = view.getEquipoDetails();
        equipo.setId(id);
        dao.updateEquipo(equipo);
        view.showMessage("Equipo actualizado exitosamente.");
    }

    private void deleteEquipo() throws SQLException {
        int id = view.getEquipoId();
        dao.deleteEquipo(id);
        view.showMessage("Equipo eliminado exitosamente.");
    }
}
