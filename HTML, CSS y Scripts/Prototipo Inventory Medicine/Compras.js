document.addEventListener("DOMContentLoaded", function () {
    const inventoryButton = document.querySelector(".Inventory");
    const salesButton = document.querySelector(".Sales");
    const buyButton = document.querySelector(".Buy");
    const configurationButton = document.querySelector(".Configuration");
    const exitButton = document.querySelector(".logout");

    inventoryButton.addEventListener("click", function() {
        window.location.href = "Inventario.html";
    });

    salesButton.addEventListener("click", function() {
        window.location.href = "Ventas.html";
    });

    buyButton.addEventListener("click", function() {
        window.location.href = "Compras.html";
    });

    configurationButton.addEventListener("click", function() {
        window.location.href = "Configuracion.html";
    })

    exitButton.addEventListener("click", function() {
        window.location.href = "InicioSesion.html";
    });

    function cargarCompras() {
        console.log("Cargando compras...");
        const purchaseData = JSON.parse(localStorage.getItem("purchaseData")) || [];
        const purchaseTable = document.querySelector("#purchaseTable tbody");
    
        purchaseTable.innerHTML = "";
    
        if (purchaseData.length === 0) {
            console.warn("No hay datos guardados en localStorage.");
            purchaseTable.innerHTML = "<tr><td colspan='5'>No hay compras registradas</td></tr>";
        } else {
            purchaseData.forEach((rowData, index) => {
                console.log(`Insertando fila ${index + 1}:`, rowData);
    
                const newRow = document.createElement("tr");
                newRow.innerHTML = `
                    <td>${rowData.fecha}</td>
                    <td>${rowData.noProducto}</td>
                    <td>${rowData.costoUnitario}</td>
                    <td>${rowData.stock}</td>
                    <td class="status">${rowData.estado}</td>
                `;
                purchaseTable.appendChild(newRow);
            });
        }
    }
    
    cargarCompras();
    
});

