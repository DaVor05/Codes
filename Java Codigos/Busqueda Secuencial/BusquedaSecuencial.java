import java.util.Scanner;

class Producto {
    String nombre;
    int codigo;

    public Producto(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
}

public class BusquedaSecuencial {
    public static void main(String[] args) {
        Producto[] productos = {
            new Producto("Computadora", 0),
            new Producto("Mouse", 1),
            new Producto("Teclado", 2),
            new Producto("Monitor", 3),
            new Producto("Impresora", 4),
            new Producto("Altavoces", 5),
            new Producto("Cámara", 6),
            new Producto("Tablet", 7),
            new Producto("Smartphone", 8),
            new Producto("Auriculares", 9)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código del producto que desea buscar: ");
        int codigoBuscado = scanner.nextInt();

        buscarProductoPorCodigo(productos, codigoBuscado);
    }
    
    public static void buscarProductoPorCodigo(Producto[] productos, int codigo) {
        for (Producto producto : productos) {
            if (producto.codigo == codigo) {
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + producto.nombre);
                System.out.println("Código: " + producto.codigo);
                return;
            }
        }
        System.out.println("El producto con código " + codigo + " no existe.");
    }
}
