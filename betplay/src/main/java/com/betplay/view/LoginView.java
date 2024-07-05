package com.betplay.view;

import java.util.Scanner;

import com.betplay.controller.EquiposController;
import com.betplay.controller.LoginController;
import com.betplay.controller.UsuariosController;
import com.betplay.model.entity.EquipoDao;
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
            if(rol=="administrador"){
                System.out.println("Seleccione el menú que desea ");
                System.out.println("1. Gestión usuarios: ");
                System.out.println("2. Gestión Equipos");
                System.out.println("3. Gestión jugadores");
                System.out.println("4. Gestión Partidos");
                System.out.println("5. Registro resultados");
                System.out.println("6. Gestión noticias");
                System.out.println("7. Gestión entrenadores");
                System.out.println("8. Gestión árbitros ");
                System.out.println("9. Gestión estadios");
                System.out.println("10. Gesitión patrocinios");
                System.out.println("11. Generación informes");
                System.out.println("12. Gestión incidentes");
                System.out.println("13. Gestión medios de comunicación");
                System.out.println("14. Gestión transferencias de jugadores");
                System.out.println("15. Gestión equipamiento");
                System.out.println("16. Gestión premios y reconocimientos");
                System.out.println("17. Gestión relaciones públicas");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Mostrar vista de administrador
                        // System.out.println("Acceso como Administrador.");
                        AdminView view = new AdminView();
                        UsuarioDao dao = new UsuarioDao();
                        UsuariosController controller = new UsuariosController(view, dao);
                        controller.start();//Usuarios
                        break;
                    case 2:
                        //Gestion equipos
                        break;
                    default:
                        System.out.println("Rol desconocido.");
                        break;
                }
            }

        } else {
            System.out.println("Credenciales incorrectas. Intente nuevamente.");
            showLogin(); // Volver a mostrar el login
        }
    }
}
