public class SelecionDirecta{
    
    /*for i = 1:n,
        k = i
        for j = i+1:n, if a[j] < a[k], k = j
        → invariant: a[k] smallest of a[i..n]
        swap a[i,k]
        → invariant: a[1..i] in final position
    end*/

    //Ordenamiento Seleccion Directa
    public static void seleccionDirecta(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[k]) {
                    k = j;
                }
            }

            if (k != i) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[k];
                arreglo[k] = temp;

                printArray(arreglo);
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

        seleccionDirecta(arreglo);

        System.out.println("Arreglo ordenado:");
        printArray(arreglo);
    }
}