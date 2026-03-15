from classes.MySingleton import MySingleton

# Intentamos crear 3 instancias diferentes
instancia1 = MySingleton()
instancia2 = MySingleton()
instancia3 = MySingleton()

# Verificamos que todas tengan el mismo ID
print(f"ID de instancia 1: {instancia1.getId()}")
print(f"ID de instancia 2: {instancia2.getId()}")
print(f"ID de instancia 3: {instancia3.getId()}")