from p5 import *

class Personaje:
    def __init__(self):
        # Valores por defecto
        self.posicion_x = 100
        self.posicion_y = 100
        self.colorRelleno = (255, 0, 0)
        self.esJefe = False
        self.alto = 50
        self.ancho = 50
        self.anchoBorde = 2
        self.colorBorde = (0, 0, 0)

    def dibujar(self):
        #stroke(29, 52, 224)
        #stroke_weight(5)
        #fill(self.colorRellenoR, self.colorRellenoG, self.colorRellenoB)
        stroke(*self.colorBorde) 
        stroke_weight(self.anchoBorde)
        
        # Lo mismo para el relleno
        fill(*self.colorRelleno)
        
        if self.esJefe:
            rect(self.posicion_x, self.posicion_y, self.ancho, self.alto)
        else:
            ellipse(self.posicion_x, self.posicion_y, self.ancho, self.alto)

class FactoryPersonaje:
    def __init__(self):
        # La factoría crea una instancia limpia de Personaje
        self.personaje = Personaje()

    def set_posicion(self, x, y):
        self.personaje.posicion_x = x
        self.personaje.posicion_y = y
        return self

    def set_borde(self, color=(0,0,0), ancho=7):
        self.personaje.colorBorde = color
        self.personaje.anchoBorde = ancho
        return self
    
    def set_color(self, r, g, b):
        self.personaje.colorRelleno = (r, g, b)
        return self
    
    def set_jefe(self):
        self.personaje.esJefe = True
        return self
        
    def build(self):
        return self.personaje

def setup():
    size(400, 400)
    
def draw():
    background(100, 0, 10)
    
    # Creamos un personaje normal azul
    personaje1 = (FactoryPersonaje().set_posicion(100, 200).set_color(0, 100, 255).set_borde(color=(10, 102, 15), ancho=7)
                  .build())
    
    # Creamos un jefe verde
    jefe = (FactoryPersonaje().set_posicion(250, 150).set_color(0, 255, 0).set_borde(color=(100, 0, 200)).set_jefe()
            .build())
    
    personaje1.dibujar()
    jefe.dibujar()
    
    #background(200 , 220, 255) # Color de fondo azul claro
    #stroke(0 , 0, 0) # Color del contorno
    #stroke_weight(5) # Anchiura del contorno
    #fill(255, 0, 0) # Color de relleno rojo
    # rect(50, 50, 100, 100) # Dibuja un rectángulo en el centro de la ventana
    #ellipse(50, 50, 100, 100) # Dibuja un círculo en el centro de la ventana

run()