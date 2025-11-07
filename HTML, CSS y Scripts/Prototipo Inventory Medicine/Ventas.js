document.addEventListener("DOMContentLoaded", function () {
    const inventoryButton = document.querySelector(".Inventory");
    const salesButton = document.querySelector(".Sales");
    const buyButton = document.querySelector(".Buy");
    const configurationButton = document.querySelector(".Configuration");
    const exitbutton = document.querySelector(".logout");

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
    });

    exitbutton.addEventListener("click", function() {
        window.location.href = "InicioSesion.html";
    });
    
    function cargarVentas() {
        console.log("Cargando ventas...");
        const salesData = JSON.parse(localStorage.getItem("salesData")) || [];
        const salesTable = document.querySelector("#productTable tbody");
    
        salesTable.innerHTML = "";
    
        if (salesData.length === 0) {
            console.warn("No hay datos guardados en localStorage.");
            salesTable.innerHTML = "<tr><td colspan='5'>No hay ventas registradas</td></tr>";
        } else {
            salesData.forEach((rowData, index) => {
                console.log(`Insertando fila ${index + 1}:`, rowData);
    
                const newRow = document.createElement("tr");
                newRow.innerHTML = `
                    <td>${rowData[0]}</td>
                    <td>${rowData[1]}</td>
                    <td>${rowData[2]}</td>
                    <td>${rowData[3]}</td>
                    <td class="status">${rowData[4]}</td>
                `;
                salesTable.appendChild(newRow);
            });
        }
    }
    cargarVentas();
});