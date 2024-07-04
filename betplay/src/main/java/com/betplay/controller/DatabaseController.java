package com.betplay.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.betplay.model.entity.Permiso;
import com.betplay.model.entity.PermisoDao;
import com.betplay.model.entity.Rol;
import com.betplay.model.entity.RolDao;
import com.betplay.model.entity.Usuario;
import com.betplay.model.entity.UsuarioDao;

public class DatabaseController {
    private RolDao rolDao;
    private UsuarioDao usuarioDao;
    private PermisoDao permisoDao;

    public DatabaseController() {
        this.rolDao = new RolDao();
        this.usuarioDao = new UsuarioDao();
        this.permisoDao = new PermisoDao();
    }

    public void initializeDatabase() {
        try {
            // Crear rol
            Rol rol = new Rol();
            rol.setNombre("Administrador de la liga");
            rolDao.addRol(rol);

            // Obtener el rol creado
            List<Rol> roles = rolDao.getAllRoles();
            Rol adminRol = roles.get(0);

            // Crear usuario
            Usuario usuario = new Usuario();
            usuario.setNombre("administrador");
            usuario.setEmail("admin@example.com");
            usuario.setPassword("123");
            usuario.setIdRol(adminRol.getId());
            usuarioDao.addUsuario(usuario);

            // Crear permiso
            Permiso permiso = new Permiso();
            permiso.setDescripcion("Permiso de administrador");
            permiso.setIdRol(adminRol.getId());
            permisoDao.addPermiso(permiso);

            System.out.println("Base de datos inicializada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al inicializar la base de datos.");
        }
    }

}
