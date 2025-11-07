document.addEventListener("DOMContentLoaded", function () {
    const tabs = document.querySelectorAll('.tab');
    const contents = document.querySelectorAll('.tab-content');
  
    tabs.forEach(tab => {
      tab.addEventListener('click', () => {
        const index = parseInt(tab.getAttribute('data-index'));
  
        tabs.forEach(t => t.classList.remove('active'));
        contents.forEach(c => c.classList.remove('active'));
  
        tab.classList.add('active');
        contents[index].classList.add('active');
      });
    });
  });
  
  function enviarFormulario() {
    const nombre = document.getElementById('nombre').value;
    const correo = document.getElementById('correo').value;
  
    if (nombre && correo) {
      alert(`Formulario enviado:\nNombre: ${nombre}\nCorreo: ${correo}`);
    } else {
      alert('Por favor, completa todos los campos.');
    }
  }
  
  function actualizarDatos() {
    alert('Datos actualizados correctamente.');
  }  