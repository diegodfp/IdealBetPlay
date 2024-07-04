package com.betplay.view;

import java.util.Scanner;

import com.betplay.controller.LoginController;
import com.betplay.controller.UsuariosController;
import com.betplay.model.entity.UsuarioDao;

public class LoginView {
private LoginController loginController;

    public LoginView(LoginController loginController) {
        this.loginController = loginController;
    }

    public void showLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bienvenido al Sistema ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        boolean loginExitoso = loginController.autenticarUsuario(usuario, contrasena);

        if (loginExitoso) {
            System.out.println("Inicio de sesión exitoso.");

            // Obtener y mostrar la vista correspondiente al rol del usuario
            String rol = loginController.obtenerRolUsuario(usuario);
            switch (rol) {
                case "administrador":
                    // Mostrar vista de administrador
                    System.out.println("Acceso como Administrador.");
                    AdminView view = new AdminView();
                    UsuarioDao dao = new UsuarioDao();
                    UsuariosController controller = new UsuariosController(view, dao);
                    controller.start();
                    break;
                case "equipo tecnico":
                    // Mostrar vista de usuario normal
                    System.out.println("Acceso como equipo tecnico.");
                    // Ejemplo: new UserView().show();adm
                    break;
                default:
                    System.out.println("Rol desconocido.");
                    break;
            }
        } else {
            System.out.println("Credenciales incorrectas. Intente nuevamente.");
            showLogin(); // Volver a mostrar el login
        }
    }
}
