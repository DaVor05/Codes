// Ejemplo de cola simple con array
public class SimpleQueue {

    // Tamaño máximo de la cola
    private int maxSize;
    // Array que representa la cola
    private int[] queueArray;
    // Índice del frente de la cola
    private int front;
    // Índice del final de la cola
    private int rear;
    // Número de elementos en la cola
    private int nItems;

    // Constructor que inicializa la cola con un tamaño dado
    public SimpleQueue(int size) {
        // Establece el tamaño máximo de la cola
        maxSize = size;
        // Crea el array para la cola
        queueArray = new int[maxSize];
        // Inicializa el frente de la cola
        front = 0;
        // Inicializa el final de la cola
        rear = -1;
        // Inicializa el número de elementos en la cola
        nItems = 0;
    }

    // Método para encolar un elemento
    public void enqueue(int item) {
        // Si el final de la cola llega al último índice del array
        if (rear == maxSize - 1) {
            // Resetea el índice del final de la cola
            rear = -1;
        }
        // Incrementa el índice del final y agrega el elemento al array
        queueArray[++rear] = item;
        // Incrementa el número de elementos en la cola
        nItems++;
        // Imprime el elemento insertado
        System.out.println("Elemento insertado: " + item);
    }

    // Método para desencolar un elemento
    public int dequeue() {
        // Toma el elemento del frente y incrementa el índice del frente
        int temp = queueArray[front++];
        // Si el frente llega al último índice del array
        if (front == maxSize) {
            // Resetea el índice del frente
            front = 0;
        }
        // Decrementa el número de elementos en la cola
        nItems--;
        // Retorna el elemento removido
        return temp;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        // Retorna verdadero si no hay elementos en la cola
        return (nItems == 0);
    }

    // Método para verificar si la cola está llena
    public boolean isFull() {
        // Retorna verdadero si el número de elementos en la cola es igual al tamaño máximo
        return (nItems == maxSize);
    }

    // Método para ver el elemento en el frente de la cola
    public int peekFront() {
        // Retorna el elemento en el frente de la cola
        return queueArray[front];
    }
}
