import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


class Individuo {
    int id;
    double peso;

    public Individuo(int id, double peso) {
        this.id = id;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Individuo ID: " + id + ", Peso: " + peso;
    }
}

// Clase que simula la toma de muestra de la población
public class MuestraDeLaPoblacion {
    private static final int TAMANIO_POBLACION = 500;  // Total de individuos
    private static final int TAMANIO_MUESTRA = 50;     // Tamaño de la muestra

    public static void main(String[] args) {
        // Crear la población de individuos
        List<Individuo> poblacion = crearPoblacion();

        // Tomar 1 muestras aleatorias de la población, se le puede cambiar el numero para tener mas muestras
        for (int i = 1; i <= 10; i++) {
            System.out.println("Muestra " + i + ":");
            List<Individuo> muestra = obtenerMuestra(poblacion);
            for (Individuo individuo : muestra) {
                System.out.println(individuo);
            }
            System.out.println();
        }
    }

    // Generar la población con individuos de peso aleatorio
    private static List<Individuo> crearPoblacion() {
        List<Individuo> poblacion = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= TAMANIO_POBLACION; i++) {
            double peso = 50 + random.nextDouble() * 50; // Peso entre 50 y 100
            poblacion.add(new Individuo(i, peso));
        }
        return poblacion;
    }

    // Mezcla la población y toma una muestra de 50 individuos
    private static List<Individuo> obtenerMuestra(List<Individuo> poblacion) {
        List<Individuo> copiaPoblacion = new ArrayList<>(poblacion);
        Collections.shuffle(copiaPoblacion);
        return copiaPoblacion.subList(0, TAMANIO_MUESTRA);
    }
}
