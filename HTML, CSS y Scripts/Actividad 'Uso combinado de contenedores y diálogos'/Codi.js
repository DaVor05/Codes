function guardarArchivo() {
    const texto = document.getElementById("textData").value;
    const blob = new Blob([texto], { type: "text/plain" });
    const url = URL.createObjectURL(blob);
  
    const a = document.createElement("a");
    a.href = url;
    a.download = "archivo.txt";
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);
  }  