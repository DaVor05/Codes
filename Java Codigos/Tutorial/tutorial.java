import java.util.Scanner;

class HolaMundo{

    public static void main(String[] args) {

            String name = "";
            int grade1 = 0; 
            float grade2 = 0; 
    
            System.out.println("Ingresa tu nombre: ");  
            Scanner inName = new Scanner(System.in);
            name = inName.next();
            System.out.println("Ingresa numero entero: "); 
            Scanner inGrade1 = new Scanner(System.in); 
            grade1 = inGrade1.nextInt();
            System.out.println("Ingresa numero flotante: "); 
            Scanner inGrade2 = new Scanner(System.in); 
            grade2 = inGrade2.nextFloat();
            System.out.println("\nNombre: " + name);  
            System.out.println("Numero entero: " + grade1);  
            System.out.println("Numero flotante: " + grade2); 
    
            inName.close();
            inGrade1.close();
            inGrade2.close();
    }
}