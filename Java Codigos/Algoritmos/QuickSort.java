import java.util.Random;

public class QuickSort {

    /*_# choose pivot_
    swap a[1,rand(1,n)]

    _# 2-way partition_
    k = 1
    for i = 2:n, if a[i] < a[1], swap a[++k,i]
    swap a[1,k]
    _→ invariant: a[1..k-1] < a[k] <= a[k+1..n]_

    _# recursive sorts_
    sort a[1..k-1]
    sort a[k+1,n] */

    //Ordenamiento QuickSort
   public static void quickSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int pivotIndex = particion(arreglo, inicio, fin);
            
            //Recursividad
            quickSort(arreglo, inicio, pivotIndex - 1); 
            quickSort(arreglo, pivotIndex + 1, fin);  
        }
    }

    // Método la partición del arreglo
    public static int particion(int[] arreglo, int inicio, int fin) {
        Random rand = new Random();
        int randomPivotIndex = inicio + rand.nextInt(fin - inicio + 1);
        swap(arreglo, inicio, randomPivotIndex);
        
        int pivote = arreglo[inicio];
        int k = inicio;

        for (int i = inicio + 1; i <= fin; i++) {
            if (arreglo[i] < pivote) {
                k++;
                swap(arreglo, k, i);
            }
        }

        swap(arreglo, inicio, k);

        return k;
    }

    // Método intercambiar dos elementos
    public static void swap(int[] arreglo, int i, int j) {
        if (i != j) {
            int temp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = temp;

            printArray(arreglo);
        }
    }

    // Método imprimir el recorrido de arreglo
    public static void printArray(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 5, 8, 6, 2}; 
        System.out.println("Arreglo original:");
        printArray(arreglo);

        quickSort(arreglo, 0, arreglo.length - 1);

        System.out.println("Arreglo ordenado:");
        printArray(arreglo);
    }
}