console.log("Hola Mundo con Desde Archivo Externo");

function calcularArea0(){
    let Radio = prompt("Ingrese el radio: ");
    const pi = 3.1416;
    var Area = pi*Radio*Radio;
    window.alert("El Área del Circulo es: " + Area);
}

function calcularArea1() {
    let Base = prompt("Ingrese la base del rectángulo: ");
    let Altura = prompt("Ingrese la altura del rectángulo: ");
    var Area = Base * Altura;
    window.alert("El Área del Rectángulo es: " + Area);
}


function calcularArea2(){
    let Base = prompt("Ingrese la base del triángulo: ");
    let Altura = prompt("Ingrese la altura del triángulo: ");
    var Area = Base * Altura / 2;
    window.alert("El Área del Triángulo es: " + Area);
}

function calcularArea3(){
    let Lado = prompt("Ingrese la longitud de un lado del hexágono: ");
    const RaizTres = Math.sqrt(3);
    var Area = 3 * RaizTres * Lado * Lado / 2;
    window.alert("El Área del Hexágono es: " + Area);
}