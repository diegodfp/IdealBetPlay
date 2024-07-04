package com.betplay.controller;

import java.sql.SQLException;
import java.util.List;

import com.betplay.model.entity.Usuario;
import com.betplay.model.entity.UsuarioDao;
import com.betplay.view.AdminView;

public class UsuariosController {
    private AdminView view;
    private UsuarioDao dao;
    public UsuariosController(AdminView view, UsuarioDao dao) {
        this.view = view;
        this.dao = dao;
    }
    
     public void start() {
        while (true) {
            int choice = view.showMenu();
            try {
                switch (choice) {
                    case 1:
                        addUsuario();
                        break;
                    case 2:
                        listUsuarios();
                        break;
                    case 3:
                        updateUsuario();
                        break;
                    case 4:
                        deleteUsuario();
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

    private void addUsuario() throws SQLException {
        Usuario usuario = view.getUsuarioDetails();
        dao.addUsuario(usuario);
        view.showMessage("Usuario añadido exitosamente.");
    }

    private void listUsuarios() throws SQLException {
        List<Usuario> usuarios = dao.getAllUsuarios();
        view.showUsuarios(usuarios);
    }

    private void updateUsuario() throws SQLException {
        int id = view.getUsuarioId();
        Usuario usuario = view.getUsuarioDetails();
        usuario.setId(id);
        dao.updateUsuario(usuario);
        view.showMessage("Usuario actualizado exitosamente.");
    }

    private void deleteUsuario() throws SQLException {
        int id = view.getUsuarioId();
        dao.deleteUsuario(id);
        view.showMessage("Usuario eliminado exitosamente.");
    }
    
}
