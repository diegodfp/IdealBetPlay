package com.betplay.controller;

import java.sql.SQLException;

import com.betplay.model.entity.Usuario;
import com.betplay.model.entity.UsuarioDao;

public class LoginController {
private UsuarioDao usuarioDao;

    public LoginController() {
        this.usuarioDao = new UsuarioDao(); 
    }

    public boolean autenticarUsuario(String usuario, String contrasena) {
        try {
            Usuario usuarioValido = usuarioDao.getUsuarioByCredentials(usuario, contrasena);
            return usuarioValido != null;
        } catch (SQLException e) {
            System.out.println("Error al autenticar usuario: " + e.getMessage());
            return false;
        }
    }
      // Método para obtener el rol de un usuario
    public String obtenerRolUsuario(String nombreUsuario) {
        return usuarioDao.obtenerRolUsuario(nombreUsuario);
    }
    
}
