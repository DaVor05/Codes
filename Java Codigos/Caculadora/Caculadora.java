import java.util.Scanner;

public class Caculadora{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarOperacion(scanner, "suma");
                    break;
                case 2:
                    realizarOperacion(scanner, "resta");
                    break;
                case 3:
                    realizarOperacion(scanner, "multiplicacion");
                    break;
                case 4:
                    realizarOperacion(scanner, "division");
                    break;
                case 5:
                    System.out.println("Gracias");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");
        System.out.print("Seleccionar una opción: ");
    }

    public static void realizarOperacion(Scanner scanner, String operacion) {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();
        double resultado = 0;

        switch (operacion) {
            case "suma":
                resultado = sumar(num1, num2);
                break;
            case "resta":
                resultado = restar(num1, num2);
                break;
            case "multiplicacion":
                resultado = multiplicar(num1, num2);
                break;
            case "division":
                if (num2 != 0) {
                    resultado = dividir(num1, num2);
                } else {
                    System.out.println("No se puede dividir por 0");
                    return;
                }
                break;
        }
        System.out.println("Resultado: " + resultado);
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }
}
