let products = [];
let productId = 1;

document.getElementById('productForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    let name = document.getElementById('name').value;
    let price = document.getElementById('price').value;
    let quantity = document.getElementById('quantity').value;
    
    let product = { id: productId++, name, price, quantity };
    products.push(product);
    updateTable();
    this.reset();
});

function updateTable() {
    let tbody = document.getElementById('productTableBody');
    tbody.innerHTML = '';
    products.forEach(product => {
        let row = tbody.insertRow();
        row.innerHTML = `
            <td>${product.id}</td>
            <td contenteditable="true" oninput="updateProduct(${product.id}, 'name', this.textContent)">${product.name}</td>
            <td contenteditable="true" oninput="updateProduct(${product.id}, 'price', this.textContent)">${product.price}</td>
            <td contenteditable="true" oninput="updateProduct(${product.id}, 'quantity', this.textContent)">${product.quantity}</td>
            <td><button class="delete-btn" onclick="deleteProduct(${product.id})">Eliminar</button></td>
        `;
    });
}

function updateProduct(id, field, value) {
    let product = products.find(p => p.id === id);
    if (product) {
        product[field] = value;
    }
}

function deleteProduct(id) {
    products = products.filter(p => p.id !== id);
    updateTable();
}