import java.util.Random;

public class LosFocosDefectuosos {

    public static void main(String[] args) {
        int poblacionTotal = 5000;
        double porcentajeDefectuosos = 0.05; // 5% de focos defectuosos
        int focosDefectuosos = (int) (poblacionTotal * porcentajeDefectuosos);
        int[] poblacion = new int[poblacionTotal];

        // Generar la población: 5% defectuosos (1) y 95% no defectuosos (0)
        for (int i = 0; i < focosDefectuosos; i++) {
            poblacion[i] = 1; // 1 representa un foco defectuoso
        }
        for (int i = focosDefectuosos; i < poblacionTotal; i++) {
            poblacion[i] = 0; // 0 representa un foco sin defecto
        }

        Random random = new Random();
        for (int i = 0; i < poblacionTotal; i++) {
            int randomIndex = random.nextInt(poblacionTotal);
            int temp = poblacion[i];
            poblacion[i] = poblacion[randomIndex];
            poblacion[randomIndex] = temp;
        }

        int muestras = 200;
        int tamanoMuestra = 40;
        int[] limites = {4, 5, 6, 7, 8, 9}; // Porcentajes a evaluar
        int[] exitos = new int[limites.length]; // Contadores para cada límite

        for (int i = 0; i < muestras; i++) {
            int defectuososEnMuestra = 0;

            System.out.print("Muestra " + (i + 1) + ": ");
            for (int j = 0; j < tamanoMuestra; j++) {
                int indiceAleatorio = random.nextInt(poblacionTotal);
                if (poblacion[indiceAleatorio] == 1) {
                    defectuososEnMuestra++;
                }
                System.out.print(poblacion[indiceAleatorio] + " ");
            }

            double porcentajeDefectuososMuestra = (defectuososEnMuestra / (double) tamanoMuestra) * 100;
            System.out.printf(" | Defectuosos: %d (%.2f%%)\n", defectuososEnMuestra, porcentajeDefectuososMuestra);

            for (int k = 0; k < limites.length; k++) {
                if (porcentajeDefectuososMuestra < limites[k]) {
                    exitos[k]++;
                }
            }
        }

        for (int k = 0; k < limites.length; k++) {
            double probabilidad = (exitos[k] / (double) muestras) * 100;
            System.out.printf("Probabilidad de que la proporción sea menor a %d%%: %.2f%%\n", limites[k], probabilidad);
        }
    }
}
