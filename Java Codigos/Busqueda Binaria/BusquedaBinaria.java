import java.util.Scanner;

public class BusquedaBinaria {

    // Método para realizar la búsqueda binaria con visualización de interacciones
    public static int buscarBinaria(int[] arreglo, int dato) {
        int inicio = 0;
        int fin = arreglo.length - 1;
        int interaccion = 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            // Imprimir el estado actual de la búsqueda
            System.out.println("Interacción " + interaccion + ":");
            System.out.println("  Inicio = " + inicio + ", Fin = " + fin + ", Medio = " + medio);
            System.out.println("  Valor en posición medio = " + arreglo[medio]);

            // Verificar si el dato está en la posición actual
            if (arreglo[medio] == dato) {
                System.out.println("  ¡Elemento encontrado!");
                return medio; // Retornar la posición del dato
            } else if (arreglo[medio] < dato) {
                inicio = medio + 1; // Buscar en la mitad derecha
            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }

            interaccion++; // Incrementar el contador de interacciones
        }

        System.out.println("  El elemento no se encuentra en el arreglo.");
        return -1; // Dato no encontrado
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicialización del arreglo
        int[] arreglo = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        // Pedir al usuario que ingrese el número a buscar
        System.out.println("Ingrese el número que desea buscar: ");
        int numero = scanner.nextInt();

        // Llamar al método de búsqueda
        int resultado = buscarBinaria(arreglo, numero);

        // Imprimir el resultado
        if (resultado != -1) {
            System.out.println("El número " + numero + " está en la posición: " + resultado);
        } else {
            System.out.println("El número " + numero + " no se encuentra en el arreglo.");
        }

        scanner.close();
    }
}

/*Links:
- Este me base para buscar el nuemro que quiero encontrar
https://codegym.cc/es/groups/posts/es.394.busqueda-binaria-en-java-colecciones-recursivas-iterativas-y-java
- Este me base para el codigo principal y tambien con las intrucciones de la maestra tona claudia (Los audios)
https://codigomaldito.blogspot.com/
https://codigojava.online/busqueda-binaria-java/