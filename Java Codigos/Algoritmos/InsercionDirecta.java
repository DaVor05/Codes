public class InsercionDirecta  {

    /*for i = 2:n,
        for (k = i; k > 1 and a[k] < a[k-1]; k--)
            swap a[k,k-1]
        → invariant: a[1..i] is sorted
    end*/
    
    //Ordenamiento Insercion Directa
    public static void Inserciondirecta(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 1; i < n; i++) {
            for (int k = i; k > 0 && arreglo[k] < arreglo[k - 1]; k--) {
                int temp = arreglo[k];
                arreglo[k] = arreglo[k - 1];
                arreglo[k - 1] = temp;

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
        int[] arreglo = {1, 5, 8, 6, 2};  // Ejemplo de arreglo a ordenar
        System.out.println("Arreglo original:");
        printArray(arreglo);

        Inserciondirecta(arreglo);  // Llama al método inserción directa

        System.out.println("Arreglo ordenado:");
        printArray(arreglo);
    }
}