// Selecciona el botón
const scrollTopButton = document.getElementById("scrollTop");

// Evento de scroll para mostrar/ocultar el botón
window.addEventListener("scroll", () => {
    if (window.scrollY > 300) { // Muestra el botón si el scroll es mayor a 300px
        scrollTopButton.classList.add("show");
    } else {
        scrollTopButton.classList.remove("show");
    }
});

// Evento de clic para regresar al inicio
scrollTopButton.addEventListener("click", () => {
    window.scrollTo({
        top: 0,
        behavior: "smooth" // Desplazamiento suave
    });
});

function toggleTheme() {
    document.body.classList.toggle('dark-mode');
    document.querySelector('header').classList.toggle('dark-mode');
    document.querySelector('footer').classList.toggle('dark-mode');
    document.querySelectorAll('section').forEach(section => {
        section.classList.toggle('dark-mode');
    });
    document.querySelector('nav').classList.toggle('dark-mode');
    document.querySelector('form').classList.toggle('dark-mode');
}