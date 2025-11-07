// Definición de la clase QueueDemo
public class QueueDemo {

    // Método principal para empezar la ejecución
    public static void main(String[] args) {
        // Creación de una instancia de la cola con capacidad de 5 elementos
        SimpleQueue myQueue = new SimpleQueue(5);

        // Insertar el elemento 10 a 40 en la cola y se repite el proceso en la linea 26 y 27 agregando el elemento 50 y 60
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);

        // Imprimir el elemento en el frente de la cola y repite el proceso en la linea 20
        System.out.println("Frente de la cola: " + myQueue.peekFront());
        
        // Desencolar elementos
        // Eliminar e imprimir el elemento en el frente de la cola y luego se repite el proceso en la linea 33
        System.out.println("Elemento desencolado: " + myQueue.dequeue());
        System.out.println("Elemento desencolado: " + myQueue.dequeue());
        
        // Verificar el frente de la cola nuevamente
        System.out.println("Frente de la cola: " + myQueue.peekFront());

        myQueue.enqueue(50);
        myQueue.enqueue(60);

        // Verificar e imprimir si la cola está llena
        System.out.println("¿La cola está llena? " + myQueue.isFull());
        
        // Mientras la cola no esté vacía
        while (!myQueue.isEmpty()) {
            System.out.println("Elemento desencolado: " + myQueue.dequeue());
        }
        
        // Verificar si la cola está vacía
        System.out.println("¿La cola está vacía? " + myQueue.isEmpty());
    }
}

