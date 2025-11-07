import java.util.Scanner;
import java.util.Stack;

public class ExpresionMatematica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //ingrese la expresiones
        System.out.println("Ingrese la Expresion:");
        String Expresion = scanner.nextLine();
        scanner.close();

        System.out.println("La Expresion 1 está balanceada:");
        System.out.println(verificaParentesis(Expresion));
;
    }

    public static boolean verificaParentesis(String Expresion) {
        Stack<Character> pila = new Stack<>();

        // Recorre toda la expresion para saber los parentesis
        for (int i = 0; i < Expresion.length(); i++) {
            // Recorre toda la expresion para saber los parentesis, lo mismo de arriba
            char caracter = Expresion.charAt(i);

            if (caracter == '(') {
                pila.push('('); //Remueve el elemento
            } else if (caracter == ')') {
                if (!pila.isEmpty()) {
                    pila.pop(); //Remueve el elemento
                } else {
                    pila.push(')'); //Remueve el elemento
                    break;
                }
            }
        }

        return pila.isEmpty(); //Esto para sabes si esta balanceada la expresion, si no toda dar false
    }
}
