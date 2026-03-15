document.addEventListener("DOMContentLoaded", function() {
  const inputNombre = document.getElementById("nombre");
  const btnSaludar = document.getElementById("btnSaludar");

  btnSaludar.addEventListener("click", function() {
    const nombre = inputNombre.value.trim();

    if (nombre) {
      alert("Hola, " + nombre);
    } else {
      alert("Por favor escribe tu nombre");
    }
  });
});