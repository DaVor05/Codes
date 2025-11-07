public class CalcularElArreglo {
    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5};
        System.out.println("La suma de los elementos del arreglo es: " + sumaArreglo(arreglo, 0));
    }

    public static int sumaArreglo(int[] arreglo, int indice) {
        if (indice == arreglo.length) {
            return 0;
        } else {
            return arreglo[indice] + sumaArreglo(arreglo, indice + 1);
        }
    }
}
