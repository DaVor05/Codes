package mexicano;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Generar_CURP {
    
    private static final Map<String, String> estados;

    static {//Los datos fueron obtenidos en la pagina oficial de codigo de Estados unidos Mexicanos//
        estados = new HashMap<>();
        estados.put("AGUASCALIENTES", "AS");
        estados.put("BAJA CALIFORNIA", "BC");
        estados.put("BAJA CALIFORNIA SUR", "BS");
        estados.put("CAMPECHE", "CC");
        estados.put("COAHUILA", "CL");
        estados.put("COLIMA", "CM");
        estados.put("CHIAPAS", "CS");
        estados.put("CHIHUAHUA", "CH");
        estados.put("CIUDAD DE MEXICO", "DF");
        estados.put("DURANGO", "DG");
        estados.put("GUANAJUATO", "GT");
        estados.put("GUERRERO", "GR");
        estados.put("HIDALGO", "HG");
        estados.put("JALISCO", "JC");
        estados.put("MEXICO", "MC");
        estados.put("MICHOACAN", "MN");
        estados.put("MORELOS", "MS");
        estados.put("NAYARIT", "NT");
        estados.put("NUEVO LEON", "NL");
        estados.put("OAXACA", "OC");
        estados.put("PUEBLA", "PL");
        estados.put("QUERETARO", "QT");
        estados.put("QUINTANA ROO", "QR");
        estados.put("SAN LUIS POTOSI", "SP");
        estados.put("SINALOA", "SL");
        estados.put("SONORA", "SR");
        estados.put("TABASCO", "TC");
        estados.put("TAMAULIPAS", "TS");
        estados.put("TLAXCALA", "TL");
        estados.put("VERACRUZ", "VZ");
        estados.put("YUCATAN", "YN");
        estados.put("ZACATECAS", "ZS");
    }

    public static String generarCURP(ConsultaPersona persona) {
        String curp = "";
        // Primera letra del primer apellido
        curp += persona.getPrimerApellido().charAt(0); 
         // Primera vocal del primer apellido
        curp += primeraVocalInterna(persona.getPrimerApellido());
         // Primera letra del segundo apellido
        curp += persona.getSegundoApellido().charAt(0);
         // Primera letra del primer nombre
        curp += persona.getNombre().charAt(0);
        // Últimos dos dígitos del año de nacimiento
        curp += persona.getFechaNacimiento().substring(2, 4); 
        // Mes de nacimiento
        curp += persona.getFechaNacimiento().substring(4, 6); 
        // Día de nacimiento
        curp += persona.getFechaNacimiento().substring(6, 8); 
        // Sexo
        curp += persona.getSexo(); 
         // Estado de nacimiento
        curp += obtenerClaveEstado(persona.getEstado());
        // Primera consonante del primer apellido
        curp += primeraConsonanteInterna(persona.getPrimerApellido()); 
        // Primera consonante del segundo apellido
        curp += primeraConsonanteInterna(persona.getSegundoApellido()); 
        // Primera consonante del primer nombre
        curp += primeraConsonanteInterna(persona.getNombre()); 
         // Homoclave generada aleatoriamente
         curp += generarHomoclave(); 
        

        return curp.toUpperCase();
    }

    private static char primeraVocalInterna(String s) {
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (esVocal(c)) {
                return c;
            }
        }
        return 'X'; // En caso de no encontrar ninguna vocal
    }

    private static char primeraConsonanteInterna(String s) {
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!esVocal(c)) {
                return c;
            }
        }
        return 'X'; // En caso de no encontrar ninguna consonante 
    }

    private static boolean esVocal(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private static String obtenerClaveEstado(String estado) {
        // "NE" es para extranjeros
        return estados.getOrDefault(estado.toUpperCase(), "NE"); 
    }    
        private static String generarHomoclave() {
        Random random = new Random();
        char letra1 = (char) (random.nextInt(26) + 'A'); // Generar una letra aleatoria
        char letra2 = (char) (random.nextInt(26) + 'A'); // Generar otra letra aleatoria
        int digito = random.nextInt(10); // Generar un dígito aleatorio
        return "" + letra1 + letra2 + digito;
    }
}