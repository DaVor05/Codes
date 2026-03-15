# ==============================================================================
# 1. CARGA DE LIBRERÍAS
# ==============================================================================
# Necesitarás estas librerías para la manipulación de datos y la visualización.
# Si no las tienes, instálalas con: install.packages(c("dplyr", "ggplot2", "tidyr"))

library(dplyr)    # Para manipulación de datos
library(ggplot2)  # Para visualización
library(tidyr)    # Para reordenar datos (para la gráfica)
library(odbc)     # Para la función dbGetQuery (ya deberías tenerla cargada)

# ==============================================================================
# 2. EXTRACCIÓN Y PREPROCESAMIENTO DE DATOS
# ==============================================================================

# 2.1. Extraer las variables solicitadas desde SQL Server
# (Asegúrate de que el nombre 'mtcars_db.dbo.mtcars' es correcto)
sql_query <- "SELECT mpg, hp, wt, qsec FROM mtcars_db.dbo.mtcars"

# Usamos tu conexión 'con' para ejecutar la consulta
datos_coches <- dbGetQuery(con, sql_query)

# 2.2. Preprocesamiento: Estandarización de datos
# K-Means se basa en distancias, por lo que las variables con escalas
# muy diferentes (como 'hp' [100s] vs 'wt' [1-5]) deben ser estandarizadas.
# 'scale()' las convierte a z-scores (media=0, desviación estándar=1).
datos_escalados <- scale(datos_coches)

# ==============================================================================
# 3. DETERMINACIÓN DEL NÚMERO ÓPTIMO DE CLÚSTERES (Método del Codo)
# ==============================================================================
# Es una buena práctica no "adivinar" el número de clústeres (k).
# Usamos el método del codo (Elbow Method).

set.seed(123) # Para reproducibilidad
wss <- numeric(10) # Vector para guardar la suma de cuadrados (within-cluster sum of squares)

for (k in 1:10) {
  kmeans_model <- kmeans(datos_escalados, centers = k, nstart = 25)
  wss[k] <- kmeans_model$tot.withinss
}

# 3.1. Gráfica del Codo
plot(1:10, wss, type = "b", 
     xlab = "Número de Clústeres (k)",
     ylab = "Suma de Cuadrados Intra-Clúster (WSS)",
     main = "Método del Codo para K Óptimo")
abline(v = 3, lty = 2, col = "red") # Ejemplo de línea en k=3

# **Instrucción:** Mira la gráfica. El "codo" (donde la línea deja de caer
# tan abruptamente) es el k óptimo. Para 'mtcars', suele ser 3 o 4.
# Asumiremos k=3 para este ejemplo.

# ==============================================================================
# 4. APLICACIÓN DEL ALGORITMO K-MEANS
# ==============================================================================

# Ajusta 'k_optimo' según tu gráfica del codo
k_optimo <- 3 

set.seed(123) # Usar la misma semilla para reproducibilidad
kmeans_final <- kmeans(datos_escalados, centers = k_optimo, nstart = 25)

# 4.1. Añadir la asignación de clústeres a los datos ORIGINALES
# (Usamos los datos originales, no los escalados, para la interpretación)
datos_coches$cluster <- factor(kmeans_final$cluster)

# ==============================================================================
# 5. CREACIÓN DE GRÁFICA DE BARRAS (Perfil de Agrupamiento)
# ==============================================================================

# 5.1. Calcular el perfil (promedio de cada variable) por clúster
perfil_clusters <- datos_coches %>%
  group_by(cluster) %>%
  summarise(
    mpg_promedio = mean(mpg),
    hp_promedio = mean(hp),
    wt_promedio = mean(wt),
    qsec_promedio = mean(qsec)
  )

# Imprimir la tabla de perfiles (clave para la interpretación)
print("--- Perfil Promedio de Clústeres ---")
print(perfil_clusters)

# 5.2. Reestructurar datos para ggplot (Formato "Largo" o "Tidy")
perfil_largo <- perfil_clusters %>%
  tidyr::pivot_longer(
    cols = !cluster, # Selecciona todas las columnas EXCEPTO 'cluster'
    names_to = "Caracteristica",
    values_to = "Valor_Promedio"
  )

# 5.3. Generar la Gráfica de Barras
ggplot(perfil_largo, aes(x = Caracteristica, y = Valor_Promedio, fill = cluster)) +
  geom_bar(stat = "identity", position = "dodge") +
  facet_wrap(~ cluster, scales = "free_x") + # Un panel por cada clúster
  labs(
    title = "Perfil de Agrupamiento de Clústeres (K-Means)",
    x = "Característica del Coche",
    y = "Valor Promedio",
    fill = "Clúster"
  ) +
  theme_minimal() +
  theme(axis.text.x = element_text(angle = 45, hjust = 1)) # Rotar etiquetas