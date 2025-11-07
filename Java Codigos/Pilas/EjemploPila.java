import java.util.Stack;
public class EjemploPila {
    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();
        //Operaciones Push
        pila.push("Hot cake 1");
        pila.push("Hot cake 2");
        pila.push("Hot cake 3");
        //Operacion Pop
        System.out.println("Elemento Removido: " + pila.pop());
        //Operacion Peek
        System.out.println("El ultimo elemento de la pila es: " + pila.peek());
        //Operacion Pop
        System.out.println("Elemento Removido: " + pila.pop());
        //Peek
        System.out.println("El ultimo es: " + pila.peek());
        //Operacion Pop
        System.out.println("Elemento Removido: " + pila.pop());
        //Verifica si esta vacia
        System.out.println("La pila esta vacia: " + pila.isEmpty());
    }
}