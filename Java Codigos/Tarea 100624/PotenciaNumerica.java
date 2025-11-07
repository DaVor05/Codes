public class PotenciaNumerica {
    public static void main(String[] args) {
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
}