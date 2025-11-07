public class SumatoriaRecursiva {
    public static void main(String[] args) {
      
        int number = 10; 
        int result = factorial(number);
        System.out.println("El factorial de " + number + " es " + result);
    }
    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
