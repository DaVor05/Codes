//Ejemplo de Memoria dinamica: Instancia de Metodo */
public class MetodoInstancia {
    //Creamos el metodo "InstanciaMetodo", el cual imprime una cadena. 
    public void instanciaMetodo() {
        System.out.println("Este es la Instancia de un metodo");
    }

    //Funcion principal
    public static void main(String[] args) {
        //Creamos un objeto "ejemplo" a partir de la plantilla (clase) "MetodoInstancia".
        MetodoInstancia ejemplo = new MetodoInstancia();
        //Mandamos a llamar el metodo "InstanciaMetodo" de nuestro objeto "ejemplo"
        ejemplo.instanciaMetodo();
    }
}