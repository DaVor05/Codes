public class BurbujaMejorada {

    // Método burbuja
    public void burbuja(int[] arreglo, int n) {
        System.out.println("--- METODO BURBUJA ---");
        for (int i = 0; i < n - 1; i++) {
            boolean ordenado = true; // Metodo Burbuja mejorada
            for (int j = 0; j < n - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    ordenado = false;
                }
            }
            //el arreglo después de cada iteración
            imprimirArreglo(arreglo);

            if (ordenado) break;
        }
    }

    // Método para imprimir el arreglo
    public void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Crear un arreglo de tamaño 7
        int[] arreglo = {5, 1, 6, 2, 3, 7, 4, 0};
        int n = arreglo.length;

        // Llamar al método burbuja desde el método main
        BurbujaMejorada obj = new BurbujaMejorada();
        obj.burbuja(arreglo, n);
    }
}