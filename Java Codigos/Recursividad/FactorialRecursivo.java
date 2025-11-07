public class FactorialRecursivo {

    public static void main(String[] args) {
      
        int number = 5; 
        int result = factorial(number);
        System.out.println("Factorial de " + number + " es igual a " + result);
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}