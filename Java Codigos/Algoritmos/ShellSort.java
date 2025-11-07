public class ShellSort {

    /*h = 1
    while h < n, h = 3*h + 1
    while h > 0,
        h = h / 3
    for k = 1:h, insertion sort a[k:h:n]
    → invariant: each h-sub-array is sorted
    end */

    //Ordenamiento Shell Sort
    public static void shellSort(int[] arreglo) {
        int n = arreglo.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                int temp = arreglo[i];
                int j = i;

                while (j >= h && arreglo[j - h] > temp) {
                    arreglo[j] = arreglo[j - h];
                    j -= h;
                    printArray(arreglo);
                }

                arreglo[j] = temp;
            }

            h = h / 3;
        }
    }

    //Imprimir el arreglo
    public static void printArray(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    //Main Principal
    public static void main(String[] args) {
        int[] arreglo = {10, 15, 5, 3, 1};
        System.out.println("Arreglo original:");
        printArray(arreglo);

        shellSort(arreglo);

        System.out.println("Arreglo ordenado:");
        printArray(arreglo);
    }
}
