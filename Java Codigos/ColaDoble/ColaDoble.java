import java.util.LinkedList;

// Clase ColaDoble():
public class ColaDoble {
    private LinkedList<Integer> elementos;

    // Método inicializador():
    public ColaDoble() {
        elementos = new LinkedList<>();
    }

    // Método agregarFrente():
    public void agregarFrente(int elemento) {
        elementos.addFirst(elemento);
    }

    // Método agregarFinal():
    public void agregarFinal(int elemento) {
        elementos.addLast(elemento);
    }

    // Método eiminarFrente():
    public Integer eliminarFrente() {
        if (!elementos.isEmpty()) {
            return elementos.removeFirst();
        } else {
            System.out.println("La cola está vacía.");
            return null;
        }
    }

    // Método eiminarFinal():
    public Integer eliminarFinal() {
        if (!elementos.isEmpty()) {
            return elementos.removeLast();
        } else {
            System.out.println("La cola está vacía.");
            return null;
        }
    }

    // Método tamaño():
    public int tamaño() {
        return elementos.size();
    }

    public static void main(String[] args) {
        ColaDoble cola = new ColaDoble();
        cola.agregarFrente(8);
        cola.agregarFinal(5);
        cola.agregarFrente(2);

        System.out.println("Tamaño: " + cola.tamaño());
        System.out.println("Eliminar Frente: " + cola.eliminarFrente());
        System.out.println("Eliminar Final: " + cola.eliminarFinal());
        System.out.println("Tamaño: " + cola.tamaño());
    }
}
