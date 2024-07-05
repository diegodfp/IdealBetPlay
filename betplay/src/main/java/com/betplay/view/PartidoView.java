package com.betplay.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;
import java.sql.Time;
import com.betplay.model.entity.Partido;

public class PartidoView {
private Scanner scanner;

    public PartidoView() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("1. Añadir partido");
        System.out.println("2. Listar partidos");
        System.out.println("3. Actualizar partido");
        System.out.println("4. Eliminar partido");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

    public Partido getPartidoDetails() {
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("ID del equipo local: ");
        int idEquipoLocal = scanner.nextInt();
        System.out.print("ID del equipo visitante: ");
        int idEquipoVisitante = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        Date fecha = Date.valueOf(fechaStr);
        System.out.print("Hora (HH:MM): ");
        String horaStr = scanner.nextLine();
        Time hora = Time.valueOf(horaStr);
        System.out.print("ID del estadio: ");
        int idEstadio = scanner.nextInt();
        System.out.print("Goles del equipo local: ");
        int golesLocal = scanner.nextInt();
        System.out.print("Goles del equipo visitante: ");
        int golesVisitante = scanner.nextInt();
        return new Partido(0, idEquipoLocal, idEquipoVisitante, fecha, hora, idEstadio, golesLocal, golesVisitante);
    }

    public int getPartidoId() {
        System.out.print("ID del partido: ");
        return scanner.nextInt();
    }

    public void showPartidos(List<Partido> partidos) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int pageSize = 3;
        int totalPartidos = partidos.size();
        int totalPages = (int) Math.ceil((double) totalPartidos / pageSize);
        String leftAlignFormat = "| %-4d | %-15d | %-15d | %-10s | %-8s | %-8d | %-8d | %-15d |%n";

        for (int page = 1; page <= totalPages; page++) {
            System.out.format("+------+-----------------+-----------------+------------+----------+----------+----------+-----------------+%n");
            System.out.format("| ID   | Equipo Local    | Equipo Visitante| Fecha      | Hora     | Goles Local | Goles Visitante | Estadio         |%n");
            System.out.format("+------+-----------------+-----------------+------------+----------+-------------+-------------+-----------------+%n");

            int start = (page - 1) * pageSize;
            int end = Math.min(start + pageSize, totalPartidos);
            for (int i = start; i < end; i++) {
                Partido partido = partidos.get(i);
                System.out.format(leftAlignFormat, partido.getId(), partido.getIdEquipoLocal(), partido.getIdEquipoVisitante(),
                        partido.getFecha(), partido.getHora(), partido.getGolesLocal(), partido.getGolesVisitante(), partido.getIdEstadio());
            }

            System.out.format("+------+-----------------+-----------------+------------+----------+-------------+-------------+-----------------+%n");
            System.out.println("Página " + page + " de " + totalPages);

            if (page < totalPages) {
                System.out.println("Presiona Enter para mostrar la siguiente página...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                scanner.nextLine();
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
