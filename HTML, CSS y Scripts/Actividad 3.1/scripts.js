const datosGuardados = JSON.parse(localStorage.getItem('datosGuardados')) || [];
const formulario = document.getElementById('formulario');
const datosGuardadosList = document.getElementById('datosGuardados');

formulario.addEventListener('submit', (e) => {
    e.preventDefault();
    const nombre = document.getElementById('nombre').value;
    const email = document.getElementById('email').value;
    const edad = document.getElementById('edad').value;
    const nuevoDatos = { nombre, email, edad };
    datosGuardados.push(nuevoDatos);
    localStorage.setItem('datosGuardados', JSON.stringify(datosGuardados));
    actualizarDatosGuardados();
    formulario.reset();
});

function actualizarDatosGuardados() {
    datosGuardadosList.innerHTML = '';
    datosGuardados.forEach((datos, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${datos.nombre}</td>
            <td>${datos.email}</td>
            <td>${datos.edad} años</td>
            <td>
                <button class="edit-btn" onclick="editarRegistro(${index})">Editar</button>
                <button class="delete-btn" onclick="eliminarRegistro(${index})">Eliminar</button>
            </td>
        `;
        datosGuardadosList.appendChild(row);
    });
}

function eliminarRegistro(index) {
    datosGuardados.splice(index, 1);
    localStorage.setItem('datosGuardados', JSON.stringify(datosGuardados));
    actualizarDatosGuardados();
}

function editarRegistro(index) {
    const datos = datosGuardados[index];
    document.getElementById('nombre').value = datos.nombre;
    document.getElementById('email').value = datos.email;
    document.getElementById('edad').value = datos.edad;
    eliminarRegistro(index);
}

document.getElementById('limpiarStorage').addEventListener('click', () => {
    localStorage.clear();
    actualizarDatosGuardados();
    alert('Los datos han sido limpiados del Local Storage.');
});

document.querySelectorAll('input').forEach(input => {
    input.addEventListener('input', () => {
        if (!input.checkValidity()) {
            input.style.borderColor = 'red';
        } else {
            input.style.borderColor = '';
        }
    });
});

actualizarDatosGuardados();