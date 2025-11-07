public class RadixSort{

    /*RadixSort(arreglo, n, d):
    d <- número máximo de dígitos en los números del arreglo
    para j <- 1 hasta d:
        CountingSortPorDigito(arreglo, n, j)
    fin para
    devolver arreglo
    Fin RadixSort

    CountingSortPorDigito(arreglo, n, digito):
    arregloAux[0..9] <- {0}
    salida[0..n-1] <- {0}
    para j <- 0 hasta n-1:
        valor_digito <- obtener el dígito en la posición digito del arreglo[j]
        arregloAux[valor_digito] <- arregloAux[valor_digito] + 1
    fin para

    para k <- 1 hasta 9:
        arregloAux[k] <- arregloAux[k] + arregloAux[k-1]
    fin para

    para j <- n-1 hasta 0:
        valor_digito <- obtener el dígito en la posición digito del arreglo[j]
        salida[arregloAux[valor_digito] - 1] <- arreglo[j]
        arregloAux[valor_digito] <- arregloAux[valor_digito] - 1
    fin para
    para j <- 0 hasta n-1:
        arreglo[j] <- salida[j]
    fin para
    devolver arreglo
    Fin CountingSortPorDigito
     */

     // Radix Sort
    
     public static void radixSort(int[] arreglo, int n) {
        int max = getMax(arreglo, n);

        for (int digito = 1; max / digito > 0; digito *= 10) {
            countingSortPorDigito(arreglo, n, digito);
            printArray(arreglo);  // Imprime el arreglo en cada paso
        }
    }

    // Método para encontrar el valor máximo
    public static int getMax(int[] arreglo, int n) {
        int max = arreglo[0];
        for (int i = 1; i < n; i++) {
            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        return max;
    }

    // Implementación de Counting Sort por dígito
    public static void countingSortPorDigito(int[] arreglo, int n, int digito) {
        int[] salida = new int[n];
        int[] arregloAux = new int[10];

        for (int i = 0; i < 10; i++) {
            arregloAux[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int valor_digito = (arreglo[i] / digito) % 10;
            arregloAux[valor_digito]++;
        }

        for (int i = 1; i < 10; i++) {
            arregloAux[i] += arregloAux[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int valor_digito = (arreglo[i] / digito) % 10;
            salida[arregloAux[valor_digito] - 1] = arreglo[i];
            arregloAux[valor_digito]--;
        }

        for (int i = 0; i < n; i++) {
            arreglo[i] = salida[i];
        }
    }

    // Método para imprimir el arreglo
    public static void printArray(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
