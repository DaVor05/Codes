function saludarUsuario() {
    let nombre = document.getElementById("nombre").value.trim();
    if (nombre) {
        window.alert("Hola, " + nombre + "!");
    } else {
        window.alert("Por favor, escribe tu nombre");
    }
}

function cambiarColor(elemento, color) {
    elemento.style.backgroundColor = color;
}