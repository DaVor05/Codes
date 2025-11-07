import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        double sum = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        System.out.println("Ingrese una serie de numeros, cuando quiera terminar ingrese el -1: ");
        while (true) {
            System.out.print("Ingrese el numero: ");
            String input = scanner.nextLine();

            double number;
            DoubleWrapper numberWrapper = new DoubleWrapper();
            if (input.equals("-1")) {
                break;
            } else if (tryParseDouble(input, numberWrapper)) {
                number = numberWrapper.value;
                count++;
                sum += number;
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            } else {
                System.out.println("ingrese un nummero valido.");
            }
        }

        if (count > 0) {
            double average = sum / count;
            System.out.println("\nEstadisticas:");
            System.out.println("Numero total de elementos: " + count);
            System.out.println("Suma de los elementos: " + sum);
            System.out.println("Promedio de los elementos: " + average);
            System.out.println("Numero mas grande: " + max);
            System.out.println("Numero mas pequeño: " + min);
        } else {
            System.out.println("No se ingresaron numeros.");
        }

        scanner.close();
    }

    private static boolean tryParseDouble(String input, DoubleWrapper numberWrapper) {
        try {
            numberWrapper.value = Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    static class DoubleWrapper {
        double value;
    }
}