public class MetodoEstatico {
    //Metodo Estatico
    public void instanciaMetodo() {
        System.out.println("Esta es una instancia del metodo.");
        int a = 5;
        int b = 5;
        int resultado = a + b;
        System.out.println("La suma es: " + resultado);
    }

    public static void main(String[] args) {
        //Creacion del objeto ejemplo del tipo MetodoEstatico
        MetodoEstatico ejemplo = new MetodoEstatico();
        //LLamada al metodo instanciaMetodo desde objeto ejemplo
        ejemplo.instanciaMetodo();
    }
}