let contacts = [];

function addContact() {
    const name = document.getElementById("name").value.trim();
    const phone = document.getElementById("phone").value.trim();
    const email = document.getElementById("email").value.trim();

    if (!name || !phone || !email) {
        alert("Todos los campos son obligatorios");
        return;
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phonePattern = /^\d{10}$/;

    if (!emailPattern.test(email)) {
        alert("Correo inválido");
        return;
    }

    if (!phonePattern.test(phone)) {
        alert("Teléfono inválido (10 dígitos requeridos)");
        return;
    }

    contacts.push({ name, phone, email });
    displayContacts();
    document.getElementById("name").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("email").value = "";
}

function displayContacts() {
    const contactList = document.getElementById("contact-list");
    contactList.innerHTML = "";
    contacts.forEach((contact, index) => {
        contactList.innerHTML += `
            <tr>
                <td>${contact.name}</td>
                <td>${contact.phone}</td>
                <td>${contact.email}</td>
                <td>
                    <button class="edit-btn" onclick="editContact(${index})">Editar</button>
                    <button class="delete-btn" onclick="deleteContact(${index})">Eliminar</button>
                </td>
            </tr>`;
    });
}

function deleteContact(index) {
    contacts.splice(index, 1);
    displayContacts();
}

function editContact(index) {
    const contact = contacts[index];
    document.getElementById("name").value = contact.name;
    document.getElementById("phone").value = contact.phone;
    document.getElementById("email").value = contact.email;
    deleteContact(index);
}

function filterContacts() {
    const searchValue = document.getElementById("search").value.toLowerCase();
    const filteredContacts = contacts.filter(contact =>
        contact.name.toLowerCase().includes(searchValue) ||
        contact.email.toLowerCase().includes(searchValue)
    );
    
    const contactList = document.getElementById("contact-list");
    contactList.innerHTML = "";
    filteredContacts.forEach((contact, index) => {
        contactList.innerHTML += `
            <tr>
                <td>${contact.name}</td>
                <td>${contact.phone}</td>
                <td>${contact.email}</td>
                <td>
                    <button class="edit-btn" onclick="editContact(${index})">Editar</button>
                    <button class="delete-btn" onclick="deleteContact(${index})">Eliminar</button>
                </td>
            </tr>`;
    });
}