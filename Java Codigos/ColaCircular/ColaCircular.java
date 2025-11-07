import java.io.*;

public class ColaCircular {
    public static class ClaseColaCircular {
        // Tamaño máximo de la cola circular
        static int max = 5;
        // Array que representa la cola circular
        static int colacirc[] = new int[max];
        // Índices del frente y fin de la cola
        static int frente, fin;

        // Constructor de la clase, inicializa los índices
        ClaseColaCircular() {
            frente = -1;
            fin = -1;
            System.out.println("Cola circular inicializada !!!");
        }

        // Método para mostrar el contenido de la cola
        public static void Mostrar() {
            int i = 0;
            System.out.println("\n\n-----MOSTRAR COLA CIRCULAR-----");
            if (frente == -1) {
                // La cola está vacía
                System.out.println("Cola vacía");
            } else {
                // Recorre y muestra los elementos de la cola
                i = frente;
                do {
                    System.out.println("elemento [" + i + "]=" + colacirc[i]);
                    i++;
                    // Si llega al final del array y la cola es circular, reinicia el índice
                    if (i == max && frente > fin) i = 0;
                } while (i != fin + 1);
            }

            // Muestra los índices del frente y fin
            System.out.println("frente =" + frente);
            System.out.println("fin =" + fin);
            System.out.println("max =" + max);
        }

        // Método para insertar un dato en la cola
        public static void Insertar(int dato) {
            // Verifica si la cola está llena
            if ((fin == max - 1 && frente == 0) || (fin + 1 == frente)) {
                System.out.println("Cola llena");
                return;
            }
            // Inserta el dato en la posición correcta
            if (fin == max - 1 && frente != 0) fin = 0;
            else fin++;
            colacirc[fin] = dato;
            if (frente == -1) frente = 0;
        }

        // Método para eliminar un dato de la cola
        public static void Eliminar() {
            // Verifica si la cola está vacía
            if (frente == -1) {
                System.out.println("Cola vacía");
                return;
            }
            // Muestra y elimina el dato del frente de la cola
            System.out.println("Dato eliminado = " + colacirc[frente]);
            if (frente == fin) {
                // Si la cola queda vacía, reinicia los índices
                frente = -1;
                fin = -1;
                return;
            }
            // Mueve el índice del frente
            if (frente == max) frente = 0;
            else frente++;
        }
    }

    // Instancia de la clase ColaCircular
    static ClaseColaCircular ColaCircular = new ClaseColaCircular();

    // Método principal que controla el menú de opciones
    public static void main(String[] args) throws IOException {
        int op = 0;

        do {
            // Muestra el menú de opciones
            System.out.println("-----COLAS CIRCULARES-----");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Mostrar");
            System.out.println("4. Salir");

            System.out.print("Ingrese opción: ");
            op = getInt();

            // Ejecuta la opción seleccionada
            switch (op) {
                case 1:
                    Altas();
                    break;
                case 2:
                    ColaCircular.Eliminar();
                    break;
                case 3:
                    ColaCircular.Mostrar();
                    break;
            }
        } while (op != 4);
    }

    // Método para insertar un nuevo dato en la cola
    public static void Altas() throws IOException {
        int dato;
        System.out.print("\n\n-----ALTAS-----");
        System.out.print("Ingrese un dato: ");
        dato = getInt();
        ColaCircular.Insertar(dato);
    }

    // Método para leer una cadena desde la consola
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // Método para leer un entero desde la consola
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
