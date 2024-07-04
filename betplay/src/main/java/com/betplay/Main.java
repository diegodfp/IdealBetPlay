package com.betplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.betplay.controller.LoginController;
import com.betplay.model.entity.UsuarioDao;
import com.betplay.view.LoginView;

public class Main {
     public static void main(String[] args) {
        // Crear el controlador y la vista de login
        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView(loginController);

        // Mostrar la vista de login
        loginView.showLogin();
    }
}