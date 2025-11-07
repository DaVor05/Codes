//Ejemplo de Memoria dinamica con variable de istancia */
public class VariableInstancia {
    //Creamos una variable global
    public int instanceVariable = 40;

    public static void main(String[] args) {
        //Creamos un objeto "example" de la plantilla (clase) VariableInstancia
        VariableInstancia example = new VariableInstancia();

        //Creamos una variable de instancia llamada "value" y se le asigna el valor de instancieVariable
        int value = example.instanceVariable;
        System.out.println("El valor de la variable de instance es: " + value);
    }
}