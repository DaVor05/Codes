# Nombre de Alumno: David Hernandez Vidriales
# Grupo: 08IDPRMA
# Nombre de práctica: Menú
# Fecha: 17 de Enero de 2026

import os

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def esNumero(valor):
    try:
        int(valor)
        return True
    except:
        return False

def menu(opciones):
    clear_screen()
    # Recorremos la lista para imprimir las opciones dinámicamente
    for i, opcion in enumerate(opciones, start=1):
        print(f"{i}. {opcion}")
    print("0. Salir")
    
    capturado = input("Seleccione una opción: ") 
    
    if not esNumero(capturado):
        print("Opción inválida. Debe ser un número.")
        input("Presiona ENTER para continuar...")
        return menu(opciones)
    else:
        return int(capturado)

if __name__ == "__main__":
    # Definimos la lista de opciones como pide la Imagen 3
    opciones = ["Suma", "Resta", "Division"]
    
    seleccion = menu(opciones)
    
    while seleccion != 0:
        if seleccion == 1:
            print("Fue sumar")
            input("Presiona ENTER para continuar...")
        elif seleccion == 2:
            print("Fue la resta")
            input("Presiona ENTER para continuar...")
        elif seleccion == 3:
            print("Fue la division")
            input("Presiona ENTER para continuar...")
        else:
            print("No es una opcion válida")
            input("Presiona ENTER para continuar...") 
        
        # Volvemos a llamar pasando la lista de opciones
        seleccion = menu(opciones)
        
    print("Programa finalizado...")