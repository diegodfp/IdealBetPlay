package com.betplay.view;

import java.util.Scanner;

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
        
    }
    
}
