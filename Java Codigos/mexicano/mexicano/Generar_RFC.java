package mexicano;
import java.util.Random;


public class Generar_RFC {
  
 
    public static String generarRFC(ConsultaPersona persona) {
        String rfc = "";
        rfc += persona.getPrimerApellido().substring(0, Math.min(2, persona.getPrimerApellido().length())); // Primeras dos letras del primer apellido
        rfc += persona.getSegundoApellido().substring(0, Math.min(1, persona.getSegundoApellido().length())); // Primera letra del segundo apellido
        rfc += persona.getNombre().substring(0, Math.min(1, persona.getNombre().length())); // Primera letra del primer nombre
        rfc += persona.getFechaNacimiento().substring(2, 4); // Últimos dos dígitos del año de nacimiento
        rfc += persona.getFechaNacimiento().substring(4, 6); // Mes de nacimiento
        rfc += persona.getFechaNacimiento().substring(6, 8); // Día de nacimiento
        rfc += generarHomoclave(); // Homoclave generada aleatoriamente

        return rfc.toUpperCase();
    }

    private static String generarHomoclave() {
        Random random = new Random();
        char letra1 = (char) (random.nextInt(26) + 'A'); // Generar una letra aleatoria
        char letra2 = (char) (random.nextInt(26) + 'A'); // Generar otra letra aleatoria
        int digito = random.nextInt(10); // Generar un dígito aleatorio
        return "" + letra1 + letra2 + digito;
    }
}
