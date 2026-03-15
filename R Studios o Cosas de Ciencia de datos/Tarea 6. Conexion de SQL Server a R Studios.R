# ============================================================
# Tarea 6. Análisis estadístico de base de datos mtcars (SQL Server) en R
# ============================================================

# Instalación de paquetes (solo la primera vez)
install.packages(c("odbc", "DBI", "ggplot2", "class", "caret"))

# Cargar librerías
library(DBI)
library(odbc)
library(ggplot2)
library(class)
library(caret)

# Conexión a SQL Server (ajusta tu instancia si cambia)
con <- dbConnect(odbc(),
                 Driver = "SQL Server",
                 Server = "DESKTOP-DMGS1A5\\SQLEXPRESS01", # tu instancia real
                 Database = "master",
                 Trusted_Connection = "Yes")

# Verificar conexión (listar bases de datos)
dbGetQuery(con, "SELECT name FROM sys.databases")

# Crear base de datos si no existe
dbExecute(con, "IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'mtcars_db') CREATE DATABASE mtcars_db")

# Reconectar a la nueva base
con <- dbConnect(odbc(),
                 Driver = "SQL Server",
                 Server = "DESKTOP-DMGS1A5\\SQLEXPRESS01",
                 Database = "mtcars_db",
                 Trusted_Connection = "Yes")

# Verificar conexión a la nueva base (listar tablas)
dbListTables(con)

# Subir dataset mtcars a SQL Server
dbWriteTable(con, "mtcars", mtcars, overwrite = TRUE)

# Leer datos desde SQL Server
mtcars_db <- dbReadTable(con, "mtcars")

# ============================================================
# ANÁLISIS ESTADÍSTICO
# ============================================================

# Medidas de tendencia central y dispersión
summary(mtcars_db)                  # media, mediana, cuartiles
sapply(mtcars_db, sd, na.rm = TRUE) # desviación estándar
sapply(mtcars_db, var, na.rm = TRUE)# varianza

# ============================================================
# VISUALIZACIONES
# ============================================================

# Histograma de consumo (mpg)
ggplot(mtcars_db, aes(x = mpg)) +
  geom_histogram(binwidth = 2, fill = "steelblue", color = "black") +
  labs(title = "Histograma de MPG", x = "Millas por galón", y = "Frecuencia")

# Boxplot de caballos de fuerza (hp)
ggplot(mtcars_db, aes(y = hp)) +
  geom_boxplot(fill = "tomato") +
  labs(title = "Boxplot de Caballos de Fuerza", y = "HP")

# Dispersión entre peso (wt) y consumo (mpg)
ggplot(mtcars_db, aes(x = wt, y = mpg, color = as.factor(cyl))) +
  geom_point(size = 3) +
  labs(title = "Relación Peso vs Consumo", x = "Peso (1000 lbs)", y = "MPG", color = "Cilindros")

# ============================================================
# MACHINE LEARNING: KNN
# ============================================================

set.seed(123)

# Partición de datos (70% entrenamiento, 30% prueba)
trainIndex <- createDataPartition(mtcars_db$cyl, p = 0.7, list = FALSE)
trainData <- mtcars_db[trainIndex, ]
testData  <- mtcars_db[-trainIndex, ]

# Entrenar modelo KNN para predecir número de cilindros
modelo_knn <- train(as.factor(cyl) ~ mpg + hp + wt + disp,
                    data = trainData,
                    method = "knn",
                    trControl = trainControl(method = "cv", number = 5),
                    tuneLength = 5)

# Predicciones
pred <- predict(modelo_knn, newdata = testData)

# Matriz de confusión
confusionMatrix(pred, as.factor(testData$cyl))

# =================================================================================
# Fin de la Tarea 6. Análisis estadístico de base de datos mtcars (SQL Server) en R
# =================================================================================