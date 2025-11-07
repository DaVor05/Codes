package mexicano;
import java.util.Scanner;

public class Mexicano {

   
    public static void main(String[] args) {
 
    	
    	
    	Scanner crear = new Scanner(System.in);

        System.out.println("Ingrese su nombre:");
        String nombre = crear.nextLine();

        System.out.println("Ingresar Primer apellido:");
        String primerApellido = crear.nextLine();

        System.out.println("Ingresar Segundo apellido:");
        String segundoApellido = crear.nextLine();

        System.out.println("Ingresar fecha de nacimiento (AAAAMMDD):");
        String fechaNacimiento = crear.nextLine();

        System.out.println("Ingresar sexo (M/F):"); 
        String sexo = crear.nextLine().toUpperCase();

        System.out.println("Ingrese el Nombre de la Entidad Federativa:");
        String estado = crear.nextLine();

        ConsultaPersona solicitante = new ConsultaPersona(nombre, primerApellido, segundoApellido, fechaNacimiento, sexo, estado);

        String curp = Generar_CURP.generarCURP(solicitante);
        String rfc = Generar_RFC.generarRFC(solicitante);

        System.out.println("Los datos solicitado son:");
        
        System.out.println("CURP: " + curp);
        System.out.println("RFC: " + rfc);
    }

}