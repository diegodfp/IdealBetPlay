package com.betplay.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.betplay.model.entity.Jugador;
import com.betplay.model.entity.Lesiones;
import com.betplay.model.entity.Rendimiento;

public class JugadorView {
    private Scanner sc;

    public JugadorView() {
        sc = new Scanner(System.in);
    }
    public int menu(){
        System.out.println("Elija una opción");
        System.out.println("1. Registrar jugador");
        System.out.println("2. Buscar jugador por nombre");
        System.out.println("3. Modificar jugador");
        System.out.println("4. Eliminar jugador");
        return sc.nextInt();
    }
    public Jugador getDataPlayer(){
        sc.nextLine();
        System.out.println("Nombre del jugador [COMPLETO]: ");
        String name = sc.nextLine();
        System.out.println("Edad del jugador: ");
        int edad = sc.nextInt();
        System.out.println("Posición del jugador: ");
        String posicion = sc.nextLine();
        System.out.println("Nacionalidad del jugador: ");
        String nacionalidad = sc.nextLine();
        System.out.println("Numero dorsal: ");
        int dorsal = sc.nextInt();
        System.out.println("Identificador equipo");
        int idEquipo = sc.nextInt();
        List<Lesiones> lesiones = new ArrayList<>();
        List<Rendimiento> rendimientos = new ArrayList<>();
        Jugador jugador = new Jugador(name,edad,posicion,nacionalidad,dorsal,idEquipo,lesiones,rendimientos);
        return jugador;
    }
    public String getNamePlayerRequired(){
        sc.nextLine();
        System.out.println("Ingrese el nombre completo del jugador que desea buscar");
        String name = sc.nextLine();
        return name;
    }
    public void mostrarJugador(List<String> jugador){
        if(jugador.size()<1){
            System.out.println("Jugador no registrado ...");
        }else{
            for (String dato : jugador) {
                System.out.println(dato+"\n");
            }
        }

    }
    
}
