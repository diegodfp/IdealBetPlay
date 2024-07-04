package com.betplay.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.betplay.model.entity.Usuario;
import com.betplay.model.entity.UsuarioDao;

public class AdminView {
    
     private Scanner scanner;

    public AdminView() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        //clearConsole();
        System.out.println("1. Añadir usuario");
        System.out.println("2. Listar usuarios");
        System.out.println("3. Actualizar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

        public Usuario getUsuarioDetails() {
        scanner.nextLine();
        System.out.println("Nombre del usuario: ");
        String name = scanner.nextLine();
        System.out.println(" email: ");
        String email = scanner.nextLine();
        System.out.println(" password");
        String password = scanner.nextLine();
        String escogerRol = """
            ********************************************
            Ingrese el numero del rol correspondiente:
            1. Administrador
            2. Equipo Tecnico
            3. Arbitro
            4. Aficionado
            5. Periodista
            6. Medico
            ********************************************
            """.formatted();
        System.out.println(escogerRol);
        int idRol = scanner.nextInt();
        return new Usuario(0, name, email, password, idRol);
    }

    public int getUsuarioId() {
        System.out.print("ID del usuario: ");
        return scanner.nextInt();
    }

    public void showUsuarios(List<Usuario> usuarios) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int pageSize = 3;
        int totalUsuarios = usuarios.size();
        int totalPages = (int) Math.ceil((double) totalUsuarios / pageSize);
        String leftAlignFormat = "| %-4d | %-20s | %-30s | %-10s | %-16s |%n"; // Cambiado el último %d a %s

        for (int page = 1; page <= totalPages; page++) {
            System.out.format("+------+----------------------+--------------------------------+------------+------------------+%n");
            System.out.format("| ID   | Nombre               | Email                          | Password   |      Rol         |%n");
            System.out.format("+------+----------------------+--------------------------------+------------+------------------+%n");

            int start = (page - 1) * pageSize;
            int end = Math.min(start + pageSize, totalUsuarios);
            for (int i = start; i < end; i++) {
                Usuario usuario = usuarios.get(i);
                UsuarioDao usuarioDao = new UsuarioDao();
                System.out.format(leftAlignFormat, usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getPassword(), usuarioDao.obtenerRolUsuario(usuario.getNombre()));
            }

            System.out.format("+------+----------------------+--------------------------------+------------+------------------+%n");
            System.out.println("Página " + page + " de " + totalPages);

            if (page < totalPages) {
                System.out.println("Presiona Enter para mostrar la siguiente página...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scanner.nextLine();
                clearConsole();
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
