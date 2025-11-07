// Mostrar nombre del archivo seleccionado
function mostrarNombreArchivo() {
    const input = document.getElementById("fileInput");
    const status = document.getElementById("statusMessage");
  
    if (input.files.length > 0) {
      status.textContent = "Archivo seleccionado: " + input.files[0].name;
    } else {
      status.textContent = "No se ha seleccionado ningún archivo.";
    }
  }
  
  // Guardar el contenido como archivo de texto
  function guardarArchivo() {
    const contenido = document.getElementById("textArea").value;
  
    if (!contenido) {
      alert("Por favor, escribe algo para guardar.");
      return;
    }
  
    const blob = new Blob([contenido], { type: "text/plain" });
    const url = URL.createObjectURL(blob);
  
    const enlace = document.createElement("a");
    enlace.href = url;
    enlace.download = "archivo_guardado.txt";
    document.body.appendChild(enlace);
    enlace.click();
    document.body.removeChild(enlace);
  
    document.getElementById("statusMessage").textContent = "Archivo guardado correctamente.";
  }
  