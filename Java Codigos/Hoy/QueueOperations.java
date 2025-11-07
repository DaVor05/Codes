import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueOperations {
    public static void main(String[] args) {
        // Crear una cola
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue (Encolar)
        enqueue(queue, 10);
        enqueue(queue, 20);
        enqueue(queue, 30);
        System.out.println("Cola después de encolar: " + queue);

        // Dequeue (Desencolar)
        try {
            int removedElement = dequeue(queue);
            System.out.println("Elemento removido con dequeue: " + removedElement);
        } catch (NoSuchElementException e) {
            System.out.println("La cola está vacía, no se puede desencolar.");
        }
        System.out.println("Cola después de desencolar: " + queue);

        // Front (Frente)
        try {
            int frontElement = front(queue);
            System.out.println("Elemento en el frente con front: " + frontElement);
        } catch (NoSuchElementException e) {
            System.out.println("La cola está vacía, no se puede obtener el frente.");
        }

        // isEmpty (Está vacía)
        System.out.println("¿La cola está vacía?: " + isEmpty(queue));

        // Size (Tamaño)
        System.out.println("Tamaño de la cola: " + size(queue));
    }

    // Enqueue (Encolar)
    public static void enqueue(Queue<Integer> queue, int element) {
        queue.offer(element);
    }

    // Dequeue (Desencolar)
    public static int dequeue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return queue.poll();
    }

    // Front (Frente)
    public static int front(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return queue.peek();
    }

    // isEmpty (Está vacía)
    public static boolean isEmpty(Queue<Integer> queue) {
        return queue.isEmpty();
    }

    // Size (Tamaño)
    public static int size(Queue<Integer> queue) {
        return queue.size();
    }
}
