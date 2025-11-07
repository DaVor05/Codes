// Función para cambiar al modo oscuro o claro
if (localStorage.getItem('modoOscuro') === 'true') {
    document.body.classList.add('modo-oscuro');
    document.querySelector('#modo-oscuro').checked = true;
}

document.querySelector('#modo-oscuro').addEventListener('change', function() {
    if (this.checked) {
        document.body.classList.add('modo-oscuro');
        localStorage.setItem('modoOscuro', 'true');
    } else {
        document.body.classList.remove('modo-oscuro');
        localStorage.setItem('modoOscuro', 'false');
    }
});