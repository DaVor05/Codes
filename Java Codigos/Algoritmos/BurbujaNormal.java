
public class BurbujaNormal {

    /*función burbuja (arreglo, n)
        para i desde 0 hasta n-1
            para j desde 0 hasta n-1
            si arreglo[j] > arreglo[j+1] entonces
    intercambiar arreglo[j] y arreglo[j+1]*/

    //Ordenamiento Burbuja
    public static void burbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    printArray(arreglo);
                }
            }
        }
    }

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

        burbuja(arreglo);
        System.out.println("Arreglo ordenado:");
        printArray(arreglo);
    }
}
