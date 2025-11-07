public class CadenaRecursiva {
    public static void main(String[] args) {
        String Cadena = "Estructura de datos";
        String CadenaInvertida = InvertirCadena(Cadena);
        System.out.println("Cadena original: " + Cadena);
        System.out.println("Cadena invertida: " + CadenaInvertida);
    }

    public static String InvertirCadena(String Cadena) {

        if (Cadena.isEmpty() || Cadena.length() == 1) {
            return Cadena;
        }

        return InvertirCadena(Cadena.substring(1)) + Cadena.charAt(0);
    }
}