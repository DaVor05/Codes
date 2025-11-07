import java.util.Scanner;

public class MenuRecursiva {
public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Recursiva");

        while (true) {
            System.out.println("-------- MENU --------");
            System.out.println("[1] Funcion Fibronacci ");
            System.out.println("[2] Potencia Numerica ");
            System.out.println("[3] Calcular El Arreglo ");
            System.out.println("[4] Cadena Recursiva ");
            System.out.println("[5] Salir");
            System.out.println("Ingrese una opción:");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    FuncionFibronacci(scanner);
                    break;
                case 2:
                PotenciaNumerica(scanner);
                    break;
                case 3:
                CalcularElArreglo(scanner);
                    break;
                case 4:
                CadenaRecursiva();
                    break;
                case 5:
                    System.out.println("¡Gracias por utilizar!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    static void FuncionFibronacci(Scanner scanner) 
        {
            int n = 10; // Cambia este valor para calcular más números de la secuencia de Fibonacci
            System.out.println("Secuencia de Fibonacci hasta el término " + n + ":");
            for (int i = 0; i < n; i++) {
                System.out.print(fibonacci(i) + " ");
            }
        }
    
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
    }

    static void PotenciaNumerica(Scanner scanner) {
        int base = 2; // Base
        int exponente = 5; // Exponente
        System.out.println(base + " elevado a la potencia " + exponente + " es: " + potencia(base, exponente));
    }

    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente == 1) {
            return base;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    static void CalcularElArreglo(Scanner scanner) {
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

    static void CadenaRecursiva() {
        String Cadena = "Estructura de datos";
        String CadenaInvertida = InvertirCadena(Cadena);
        System.out.println("Cadena original: " + Cadena);
        System.out.println("Cadena invertida: " + CadenaInvertida);
    }

    public static String InvertirCadena(String Cadena) {

        if (Cadena.isEmpty() || Cadena.length() == 1) {
            return Cadena;
        }

        return InvertirCadena(Cadena.substring(1)) + Cadena.charAt(0);
    }
}

