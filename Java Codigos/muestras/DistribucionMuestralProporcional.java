import java.util.Random;

public class DistribucionMuestralProporcional {
    
    // Método para generar una muestra de tamaño 'tamanoMuestra' a partir de una población 'poblacion'
    public static void main(String[] args) {
        // Definición de parámetros
        int tamanoPoblacion = 5000;
        double media = 207;
        double desviacionEstandar = 30;
        int numeroMuestras = 200;
        int tamanoMuestra = 35;
        double alpha = 200; // Valor de alpha (se puedes cambiarlo)
        
        // Generar población con una distribución normal
        double[] poblacion = generarPoblacion(tamanoPoblacion, media, desviacionEstandar);
        
        // Realizar el muestreo y contar cuántas muestras cumplen con X̄ < α
        int contadorMuestrasCumplen = contarMuestrasQueCumplen(poblacion, numeroMuestras, tamanoMuestra, alpha);
        
        // Calcular la proporción de muestras que cumplen la condición
        double proporcion = (double) contadorMuestrasCumplen / numeroMuestras;
        
        System.out.println("Proporción de muestras que cumplen con X̄ < α: " + proporcion);
    }

    // Método para generar una población con distribución normal
    public static double[] generarPoblacion(int tamano, double media, double desviacionEstandar) {
        Random random = new Random();
        double[] poblacion = new double[tamano];
        for (int i = 0; i < tamano; i++) {
            // Generar valores aleatorios con distribución normal
            poblacion[i] = media + random.nextGaussian() * desviacionEstandar;
        }
        return poblacion;
    }

    // Método para contar las muestras que cumplen con X̄ < α
    public static int contarMuestrasQueCumplen(double[] poblacion, int numeroMuestras, int tamanoMuestra, double alpha) {
        Random random = new Random();
        int contador = 0;

        for (int i = 0; i < numeroMuestras; i++) {
            double sumaMuestra = 0;
            // Seleccionar una muestra aleatoria de la población
            for (int j = 0; j < tamanoMuestra; j++) {
                int indiceAleatorio = random.nextInt(poblacion.length);
                sumaMuestra += poblacion[indiceAleatorio];
            }
            // Calcular la media de la muestra
            double mediaMuestral = sumaMuestra / tamanoMuestra;

            // Verificar si la media muestral cumple con X̄ < α
            if (mediaMuestral < alpha) {
                contador++;
            }
        }
        return contador;
    }
}