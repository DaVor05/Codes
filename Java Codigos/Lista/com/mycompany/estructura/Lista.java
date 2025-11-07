package com.mycompany.estructura;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String nombre = "";
        ArrayList<String> listaNombres = new ArrayList<>();
        listaNombres.add("Jovanny");
        listaNombres.add("Juan");
        listaNombres.add("Maria");
        listaNombres.add("Pepe");

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuál es tu nombre?");
        nombre = scanner.nextLine();
        listaNombres.add(nombre);

        System.out.println("\nNombres en la lista:");
        for (String nombreLista : listaNombres) {
            System.out.println(nombreLista);
        }

        System.out.println("\n¿Quieres eliminar un nombre de la lista? (Sí/No)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Introduce el nombre que quieres eliminar:");
            String nombreEliminar = scanner.nextLine();
            if (listaNombres.remove(nombreEliminar)) {
                System.out.println(nombreEliminar + " ha sido eliminado de la lista.");
            } else {
                System.out.println(nombreEliminar + " ya no se encuentra en la lista.");
            }
        }

        System.out.println("\nEl tamaño de la lista es: " + listaNombres.size());

        System.out.println("\n¿Quieres conocer la posición de algún nombre en la lista? (sí/no)");
        respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Introduce el nombre del cual quieres conocer la posición:");
            String nombreBuscar = scanner.nextLine();
            int indice = listaNombres.indexOf(nombreBuscar);
            if (indice != -1) {
                System.out.println("El nombre " + nombreBuscar + " está en la posición: " + indice);
            } else {
                System.out.println("El nombre " + nombreBuscar + " no se encontró en la lista.");
            }
        }

        System.out.println("\nNombres en la lista después de posibles eliminaciones:");
        for (String nombreLista : listaNombres) {
            System.out.println(nombreLista);
        }

        System.out.println("\nEl tamaño final de la lista es: " + listaNombres.size());
    }
}