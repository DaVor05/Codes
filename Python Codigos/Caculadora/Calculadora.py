print("Ingrese una serie de numeros, ingrese -1 para finalizar")
count = 0
total_sum = 0
valor_max = float('-inf')  
valor_min = float('inf')   

while True:
    try:
        numero = float(input("Ingrese un número, ingrese -1 para finalizar: "))
        if numero == -1:
            break
        count += 1
        total_sum += numero
        
        if numero > valor_max:  
            valor_max = numero
        
        if numero < valor_min:  
            valor_min = numero
    
    except ValueError:
        print("Ingrese un número válido.")
        continue

if count > 0:
    promedio = total_sum / count
    print("Estadísticas:")
    print("Número total de elementos:", count)
    print("Suma total de los elementos:", total_sum)
    print("Promedio de los elementos:", promedio)
    print("Número mayor:", valor_max)
    print("Número menor:", valor_min)