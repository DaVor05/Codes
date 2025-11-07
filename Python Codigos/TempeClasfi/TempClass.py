#Ingresa una temperatura en grados Celsius
temperatura = float(input("Ingresa una temperatura en grados Celsius: "))
#Clasificar la temperatura usando control de flujo
if temperatura < 15:
    clasificacion = "Frío"
elif 15 <= temperatura <= 30:
    clasificacion = "Cálido"
else:
    clasificacion = "Caliente"
#Mostrar el mensaje según la clasificación
print(f"La temperatura de {temperatura}°C es considerada: {clasificacion}.")