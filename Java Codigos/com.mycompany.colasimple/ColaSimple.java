package com.mycompany.colasimple;

import java.util.Queue;
import java.util.Scanner;

//Objetivo: Hacer un programa que simule un sistema bancario de asignacion de turnos.
//Un cliente tiene id y tiempo de espera
//Implementar una cola para administrar el turno de los clientes
//Indicar la llegada de los clientes (enqueue)
//Indicar quien se esta atendiendo
//Indicar cuando ya se atendio (dequeue)
//Mostrar el estado de la cola en todo momento

public class ColaSimple {
    public static void main(String[] args) {
        Scanner captura = new Scanner(System.in);
        ColaBancaria sistema = new ColaBancaria();
        boolean continuar = true;

        while (continuar) {
            System.out.println("------OPCIONES-------:");
            System.out.println("1. Cliente nuevo");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar estado de la cola");
            System.out.println("4. Salir");
            System.out.println("----------------------");
            int opcion = captura.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el ID del cliente:");
                    int idCliente = captura.nextInt();
                    System.out.println("Ingrese el tiempo de espera del cliente (en minutos):");
                    int tiempoEspera = captura.nextInt();
                    sistema.llegadaCliente(new Cliente(idCliente, tiempoEspera));
                    break;
                case 2:
                    sistema.atenderCliente();
                    break;
                case 3:
                    sistema.mostrar();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Error de captura");
            }
        }

        captura.close();
    }
}

class Cliente {
    public int idCliente;
    public int tiempoEspera;

    public Cliente(int idCliente, int tiempoEspera) {
        this.idCliente = idCliente;
        this.tiempoEspera = tiempoEspera;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + idCliente + ", Tiempo de espera: " + tiempoEspera + " minutos";
    }
}

class Nodo {
    Cliente cliente;
    Nodo siguiente;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}

class ColaBancaria {
    private Nodo frente;
    private Nodo fondo;

    public ColaBancaria() {
        this.frente = null;
        this.fondo = null;
    }

    public void llegadaCliente(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);
        if (fondo == null) {
            frente = nuevoNodo;
            fondo = nuevoNodo;
        } else {
            fondo.siguiente = nuevoNodo;
            fondo = nuevoNodo;
        }
        System.out.println("Llegada de " + cliente);
        mostrar();
    }

    public void atenderCliente() {
        if (frente != null) {
            Cliente cliente = frente.cliente;
            frente = frente.siguiente;
            if (frente == null) {
                fondo = null;
            }
            System.out.println("Atendiendo a " + cliente);
        } else {
            System.out.println("No hay clientes en la cola");
        }
        mostrar();
    }

    public void mostrar() {
        if (frente == null) {
            System.out.println("La cola está vacía");
        } else {
            System.out.println("Estado de la cola:");
            Nodo actual = frente;
            while (actual != null) {
                System.out.println(actual.cliente);
                actual = actual.siguiente;
            }
        }
    }
}
