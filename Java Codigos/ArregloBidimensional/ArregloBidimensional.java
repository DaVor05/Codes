import java.util.Scanner;

public class ArregloBidimensional {
    // Número de filas (A-I)
    private static final int FILAS = 9;
    // Número de asientos por fila
    private static final int ASIENTOS_POR_FILA = 10; 
    // Matriz para representar el estado de los asientos
    private static boolean[][] asientos = new boolean[FILAS][ASIENTOS_POR_FILA]; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Arreglo bidimensional");

        // While para que se repita el codigo cuando acaber una opcion
        while (true) {
            // Menú de opciones
            System.out.println("-------- MENU ---------");
            System.out.println("- [1] Asignar Boleto  -");
            System.out.println("- [2] Cancelar Venta  -");
            System.out.println("- [3]  Mostrar Mapa   -");
            System.out.println("- [4]    Calcular     -");
            System.out.println("- [5]     Salir       -");
            System.out.println("-----------------------");
            System.out.println("Ingrese una opción:");
            int opcion = scanner.nextInt();
            
            // Switch para las diferents opciones de codigo
            switch (opcion) {
                case 1:
                // Llama a la función para asignar un boleto
                    asignar(scanner);
                    System.out.println("Asignar Boleto");
                    break;
                case 2:
                // Llama a la función para cancelar un boleto
                    cancelar(scanner);
                    System.out.println("Cancelar Boleto");
                    break;
                case 3:
                // Llama a la función para mostrar el mapa de asientos
                    mostrar();
                    System.out.println("Mostrar Mapa");
                    break;
                case 4:
                // Llama a la función para calcular el total de ventas
                    calcular();
                    break;
                case 5:
                    // Termina el programa
                    System.out.println("¡Gracias por utilizar nuestro sistema de asignación de boletos!");
                    System.exit(0);
                    break;
                default:
                    // Mensaje para opciones inválidas
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    static void asignar(Scanner scanner) {
        // Lógica para asignar un boleto
        System.out.println("Ingrese la fila (A-I) y el número de asiento (1-10) separados por espacio:");
        char fila = scanner.next().charAt(0);
        int numAsiento = scanner.nextInt();

        if (!esValido(fila, numAsiento)) {
            System.out.println("Entrada inválida. Por favor, ingrese valores válidos.");
            return;
        }
        // Convertir la fila a un índice (0-8)
        int filaIndex = fila - 'A';
        // Convertir el número de asiento a un índice (0-9)
        int asientoIndex = numAsiento - 1;

        if (asientos[filaIndex][asientoIndex]) {
            System.out.println("Lo siento, ese asiento ya está ocupado. Por favor, elija otro.");
        } else {
            asientos[filaIndex][asientoIndex] = true;
            System.out.println("¡Asignación exitosa! Disfrute de su asiento en la fila " + fila + ", asiento " + numAsiento);
        }
    }

    static void cancelar(Scanner scanner) {
        // Lógica para cancelar un boleto
        System.out.println("Ingrese la fila (A-I) y el número de asiento (1-10) a cancelar separados por espacio:");
        char fila = scanner.next().charAt(0);
        int numAsiento = scanner.nextInt();

        if (!esValido(fila, numAsiento)) {
            System.out.println("Entrada inválida. Por favor, ingrese valores válidos.");
            return;
        }

        int filaIndex = fila - 'A'; // Convertir la fila a un índice (0-8)
        int asientoIndex = numAsiento - 1; // Convertir el número de asiento a un índice (0-9)

        if (!asientos[filaIndex][asientoIndex]) {
            System.out.println("Lo siento, ese asiento no está ocupado.");
        } else {
            asientos[filaIndex][asientoIndex] = false;
            System.out.println("¡Cancelación exitosa! El asiento en la fila " + fila + ", asiento " + numAsiento + " ha sido liberado.");
        }
    }

    static void mostrar() {
        // Muestra el mapa de asientos
        System.out.println("Mapa de asientos:");
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < FILAS; i++) {
            char fila = (char) ('A' + i);
            System.out.print(fila + " ");
            for (int j = 0; j < ASIENTOS_POR_FILA; j++) {
                if (asientos[i][j]) {
                    System.out.print("X "); // Asiento ocupado
                } else {
                    System.out.print("_ "); // Asiento disponible
                }
            }
            System.out.println();
        }
    }

    static void calcular() {
        // Precios de los boletos
        double precio1 = 1000;
        double precio2 = 750;
        double precio3 = 500;
        double precio4 = 300;
    
        // Contadores para cada tipo de boleto vendido
        int cantidadTipo1 = 0;
        int cantidadTipo2 = 0;
        int cantidadTipo3 = 0;
        int cantidadTipo4 = 0;
    
        // Contar la cantidad de boletos vendidos de cada tipo
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < ASIENTOS_POR_FILA; j++) {
                if (asientos[i][j]) {
                    // Determinar el tipo de boleto basado en la fila del asiento
                    if (i == 0) {
                        cantidadTipo1++;
                    } else if (i == 1) {
                        cantidadTipo2++;
                    } else if (i == 2) {
                        cantidadTipo3++;
                    } else {
                        cantidadTipo4++;
                    }
                }
            }
        }
    
        // Calcular el total de ventas
        double total = cantidadTipo1 * precio1 + cantidadTipo2 * precio2 + cantidadTipo3 * precio3 + cantidadTipo4 * precio4;
        System.out.println("El total de ventas es: $" + total);
    }

    static int contarBoletosVendidos() {
        // Contar el número de asientos ocupados
        int contador = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < ASIENTOS_POR_FILA; j++) {
                if (asientos[i][j]) {
                    contador++;
                }
            }
        }
        return contador;
    }

    static boolean esValido(char fila, int numAsiento) {
        // Verifica si la fila y el número de asiento son válidos
        return (fila >= 'A' && fila <= 'I') && (numAsiento >= 1 && numAsiento <= 10);
    }
}