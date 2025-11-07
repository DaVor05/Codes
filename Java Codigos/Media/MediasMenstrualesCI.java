import java.util.Random;

public class MediasMenstrualesCI {
    // Parámetros de la población
    private static final int TOTAL_POBLACION = 5000;
    private static final double MEDIA_POBLACION = 100;
    private static final double DESVIACION_POBLACION = 15;
    
    // Parámetros de la muestra
    private static final int TAMANIO_MUESTRA = 30;
    private static final int NUMERO_MUESTRAS = 200;
    
    public static void main(String[] args) {
        Random random = new Random();
        double[] poblacion = new double[TOTAL_POBLACION];
        
        // Generar la población completa de 5000 individuos
        for (int i = 0; i < TOTAL_POBLACION; i++) {
            poblacion[i] = MEDIA_POBLACION + DESVIACION_POBLACION * random.nextGaussian();
        }
        
        double[] mediasMuestrales = new double[NUMERO_MUESTRAS];
        
        // Tomar 200 muestras de 30 personas cada una de la población
        for (int i = 0; i < NUMERO_MUESTRAS; i++) {
            double sumaMuestra = 0;
            for (int j = 0; j < TAMANIO_MUESTRA; j++) {
                // Seleccionar una persona aleatoria de la población
                int indiceAleatorio = random.nextInt(TOTAL_POBLACION);
                sumaMuestra += poblacion[indiceAleatorio];
            }
            mediasMuestrales[i] = sumaMuestra / TAMANIO_MUESTRA;
        }
        
        // Calcular la media de todas las muestras
        double sumaMedias = 0;
        for (double media : mediasMuestrales) {
            sumaMedias += media;
        }
        double mediaGeneral = sumaMedias / NUMERO_MUESTRAS;
        System.out.println("Media General de las Muestras: " + mediaGeneral);
        
        // Valores de comparación (Cualquier numero)
        double[] valoresObjetivo = {95,97,99,101,103,105};
        
        // Calcular la proporción de medias muestrales por debajo de cada valor
        for (double valor : valoresObjetivo) {
            int conteoPorDebajo = 0;
            for (double media : mediasMuestrales) {
                if (media < valor) {
                    conteoPorDebajo++;
                }
            }
            double proporcion = (double) conteoPorDebajo / NUMERO_MUESTRAS;
            System.out.println("La Proporción de Medias Muestrales por Debajo de " + valor + ": " + proporcion);
        }
    }
}