package com.betplay.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.betplay.model.entity.Equipo;

public class EquipoView {
    private Scanner scanner;

    public EquipoView() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("1. Añadir equipo");
        System.out.println("2. Listar equipos");
        System.out.println("3. Actualizar equipo");
        System.out.println("4. Eliminar equipo");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

    public Equipo getEquipoDetails() {
        scanner.nextLine();
        System.out.print("Nombre del equipo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ciudad del equipo: ");
        String ciudad = scanner.nextLine();
        System.out.print("ID del estadio: ");
        int idEstadio = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre del entrenador ");
        String nombreEntrenador = scanner.nextLine();
        scanner.nextLine(); // Consumir la nueva línea
        return new Equipo(null, nombre, ciudad, idEstadio, nombreEntrenador);
    }

    public String getEquipoId() {
        System.out.print("ID del equipo: ");
        return scanner.nextLine();
    }

    public void showEquipos(List<Equipo> equipos) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int pageSize = 3;
        int totalEquipos = equipos.size();
        int totalPages = (int) Math.ceil((double) totalEquipos / pageSize);
        String leftAlignFormat = "| %-4s | %-20s | %-20s | %-10d |%n"; // Ajusta según tu formato deseado

        for (int page = 1; page <= totalPages; page++) {
            System.out.format("+------+----------------------+----------------------+------------+%n");
            System.out.format("| ID   | Nombre               | Ciudad               | Estadio ID |%n");
            System.out.format("+------+----------------------+----------------------+------------+%n");

            int start = (page - 1) * pageSize;
            int end = Math.min(start + pageSize, totalEquipos);
            for (int i = start; i < end; i++) {
                Equipo equipo = equipos.get(i);
                System.out.format(leftAlignFormat, equipo.getId(), equipo.getNombre(), equipo.getCiudad(),
                        equipo.getIdEstadio());
            }

            System.out.format("+------+----------------------+----------------------+------------+%n");
            System.out.println("Página " + page + " de " + totalPages);

            if (page < totalPages) {
                System.out.println("Presiona Enter para mostrar la siguiente página...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scanner.nextLine();
                // clearConsole();
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}
