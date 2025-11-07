// Crear un arbol
class Nodo {
    int valor;
    Nodo derecho, izquierdo;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Método para agregar un elemento al árbol
    public void agregarElemento(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierdo = agregarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = agregarRecursivo(actual.derecho, valor);
        }
        return actual;
    }

    // Método para recorrer el árbol en orden
    void PreOrden(Nodo nodo) {
        if (nodo != null)
        {   
            System.out.print(nodo.valor + " ");
            PreOrden(nodo.izquierdo);
            PreOrden(nodo.derecho);
        }
    }

    // Método para buscar un elemento en el árbol
    public boolean buscarElemento(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return false;
        }
        if (valor == actual.valor) {
            return true;
        }
        if (valor < actual.valor) {
            return buscarRecursivo(actual.izquierdo, valor);
        } else {
            return buscarRecursivo(actual.derecho, valor);
        }
    }

    // Método principal para que funcione el árbol
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.agregarElemento(5);
        arbol.agregarElemento(3);
        arbol.agregarElemento(7);
        arbol.agregarElemento(1);
        arbol.agregarElemento(4);
        arbol.agregarElemento(9);

        System.out.println("Recorrido en orden:");
        arbol.PreOrden(arbol.raiz);

        int buscarValor = 4;
        System.out.println("\n¿El valor " + buscarValor + " está en el árbol? " + arbol.buscarElemento(buscarValor));

        buscarValor = 6;
        System.out.println("¿El valor " + buscarValor + " está en el árbol? " + arbol.buscarElemento(buscarValor));
    }
}
