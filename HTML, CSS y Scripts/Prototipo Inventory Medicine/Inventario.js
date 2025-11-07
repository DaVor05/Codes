document.addEventListener("DOMContentLoaded", function () {
    const addButton = document.querySelector(".add-btn");
    const importButton = document.querySelector(".import-btn");
    const productTable = document.querySelector("#productTable tbody") || document.getElementById("productTable");
    const searchInput = document.getElementById("searchInput");
    const inventoryButton = document.querySelector(".Inventory");
    const salesButton = document.querySelector(".Sales");
    const buyButton = document.querySelector(".Buy");
    const configurationButton = document.querySelector(".Configuration");
    const exitbutton = document.querySelector(".logout");

    inventoryButton.addEventListener("click", function () {
        window.location.href = "Inventario.html";
    });

    salesButton.addEventListener("click", function () {
        window.location.href = "Ventas.html";
    });

    buyButton.addEventListener("click", function () {
        window.location.href = "Compras.html";
    });

    configurationButton.addEventListener("click", function () {
        window.location.href = "Configuracion.html";
    });

    exitbutton.addEventListener("click", function () {
        window.location.href = "InicioSesion.html";
    });

    // Cargar datos guardados en localStorage
    function loadFromLocalStorage() {
        const savedData = localStorage.getItem("inventoryData");
        const stockData = JSON.parse(localStorage.getItem("stockData")) || {};

        if (savedData) {
            let tableData = JSON.parse(savedData);
            productTable.innerHTML = "";
            tableData.forEach(data => {
                let newRow = createRow(data);
                productTable.appendChild(newRow);
            });

            // Restaurar stock y estado individualmente
            document.querySelectorAll("#productTable tbody tr").forEach(row => {
                const productoID = row.cells[1].querySelector("input").value;
                if (stockData[productoID]) {
                    const stockInput = row.cells[3].querySelector("input");
                    const estadoSpan = row.cells[4].querySelector("span");

                    stockInput.value = stockData[productoID].stock;
                    estadoSpan.textContent = stockData[productoID].estado;
                    estadoSpan.classList.remove("estado-verde", "estado-rojo", "complete", "incomplete");

                    if (stockData[productoID].estado === "COMPLETADO") {
                        estadoSpan.classList.add("estado-verde", "complete");
                    } else {
                        estadoSpan.classList.add("estado-rojo", "incomplete");
                    }
                }
            });
        }
    }

    function saveToLocalStorage() {
        let tableData = [];
        document.querySelectorAll("#productTable tbody tr").forEach(row => {
            let rowData = {
                fecha: row.cells[0].querySelector("input").value,
                noProducto: row.cells[1].querySelector("input").value,
                costoUnitario: row.cells[2].querySelector("input").value,
                stock: row.cells[3].querySelector("input").value,
                estado: row.cells[4].querySelector("span").textContent
            };
            tableData.push(rowData);
        });
        localStorage.setItem("inventoryData", JSON.stringify(tableData));
    }

    function createRow(data = {}) {
        let newRow = document.createElement("tr");
        newRow.innerHTML = `
            <td><input type="text" value="${data.fecha || ''}"></td>
            <td><input type="text" value="${data.noProducto || ''}"></td>
            <td><input type="text" value="${data.costoUnitario || ''}"></td>
            <td><input type="text" value="${data.stock || ''}"></td>
            <td><span class="status ${data.estado === 'COMPLETADO' ? 'complete estado-verde' : 'incomplete estado-rojo'}">${data.estado || 'NO COMPLETADO'}</span></td>
            <td>
                <button class="sell-btn">Vender</button>
                <button class="buy-btn">Comprar</button>
                <button class="delete-row-btn">❌</button>
            </td>
        `;
        addEventListenersToRow(newRow);
        return newRow;
    }

    function addEventListenersToRow(row) {
        row.querySelector(".status").addEventListener("click", function () {
            this.classList.toggle("complete");
            this.classList.toggle("incomplete");
            this.classList.toggle("estado-verde");
            this.classList.toggle("estado-rojo");
            this.textContent = this.classList.contains("complete") ? "COMPLETADO" : "NO COMPLETADO";
            saveToLocalStorage();
        });

        row.querySelectorAll("input").forEach(input => {
            input.addEventListener("input", saveToLocalStorage);
        });

        row.querySelector(".delete-row-btn").addEventListener("click", function () {
            row.remove();
            saveToLocalStorage();
        });

        // BOTÓN VENDER
        row.querySelector(".sell-btn").addEventListener("click", function () {
            const estadoSpan = row.cells[4].querySelector("span");
            const estado = estadoSpan.textContent;

            if (estado !== "COMPLETADO") {
                alert("No puedes vender este producto porque no está COMPLETADO.");
                return;
            }

            const stockInput = row.cells[3].querySelector("input");
            let stock = parseInt(stockInput.value);
            let cantidad = parseInt(prompt(`¿Cuántas unidades deseas vender? (Stock disponible: ${stock})`));

            if (isNaN(cantidad) || cantidad <= 0) {
                alert("Por favor ingresa una cantidad válida.");
                return;
            }

            if (cantidad > stock) {
                alert("No puedes vender más de lo que tienes en stock.");
                return;
            }

            stock -= cantidad;
            stockInput.value = stock;

            if (stock === 0) {
                estadoSpan.textContent = "NO COMPLETADO";
                estadoSpan.classList.remove("estado-verde", "complete");
                estadoSpan.classList.add("estado-rojo", "incomplete");
            }

            const rowData = [
                row.cells[0].querySelector("input").value,
                row.cells[1].querySelector("input").value,
                row.cells[2].querySelector("input").value,
                cantidad,
                "VENDIDO"
            ];

            let salesData = JSON.parse(localStorage.getItem("salesData")) || [];
            salesData.push(rowData);
            localStorage.setItem("salesData", JSON.stringify(salesData));

            alert(`Producto ${rowData[1]}: ${cantidad} unidades marcadas como vendidas`);

            // Guardar nuevo stock y estado
            const productoID = row.cells[1].querySelector("input").value;
            let stockData = JSON.parse(localStorage.getItem("stockData")) || {};
            stockData[productoID] = {
                stock: stock,
                estado: estadoSpan.textContent
            };
            localStorage.setItem("stockData", JSON.stringify(stockData));
            saveToLocalStorage();
        });

        // BOTÓN COMPRAR
        row.querySelector(".buy-btn").addEventListener("click", function () {
            const estadoSpan = row.cells[4].querySelector("span");
            const estado = estadoSpan.textContent;

            if (estado !== "COMPLETADO") {
                alert("No puedes comprar este producto porque no está COMPLETADO.");
                return;
            }

            const stockInput = row.cells[3].querySelector("input");
            let stock = parseInt(stockInput.value);
            let cantidad = parseInt(prompt(`¿Cuántas unidades deseas comprar? (Stock actual: ${stock})`));

            if (isNaN(cantidad) || cantidad <= 0) {
                alert("Por favor ingresa una cantidad válida.");
                return;
            }

            stock += cantidad;
            stockInput.value = stock;

            if (estadoSpan.textContent === "NO COMPLETADO") {
                estadoSpan.textContent = "COMPLETADO";
                estadoSpan.classList.remove("estado-rojo", "incomplete");
                estadoSpan.classList.add("estado-verde", "complete");
            }

            const rowData = {
                fecha: row.cells[0].querySelector("input").value,
                noProducto: row.cells[1].querySelector("input").value,
                costoUnitario: row.cells[2].querySelector("input").value,
                stock: cantidad,
                estado: "COMPRADO"
            };

            let purchaseData = JSON.parse(localStorage.getItem("purchaseData")) || [];
            purchaseData.push(rowData);
            localStorage.setItem("purchaseData", JSON.stringify(purchaseData));

            alert(`Producto ${rowData.noProducto}: ${cantidad} unidades marcadas como compradas`);

            // Guardar nuevo stock y estado
            const productoID = row.cells[1].querySelector("input").value;
            let stockData = JSON.parse(localStorage.getItem("stockData")) || {};
            stockData[productoID] = {
                stock: stock,
                estado: estadoSpan.textContent
            };
            localStorage.setItem("stockData", JSON.stringify(stockData));
            saveToLocalStorage();
        });
    }

    addButton.addEventListener("click", function () {
        let newRow = createRow();
        productTable.appendChild(newRow);
        saveToLocalStorage();
    });

    searchInput.addEventListener("input", function () {
        const searchValue = searchInput.value.toLowerCase().trim();
        const rows = productTable.getElementsByTagName("tr");

        for (let row of rows) {
            let rowText = Array.from(row.cells)
                .map(cell => cell.querySelector("input") ? cell.querySelector("input").value.toLowerCase() : cell.textContent.toLowerCase())
                .join(" ");
            row.style.display = rowText.includes(searchValue) ? "" : "none";
        }
    });

    importButton.addEventListener("click", function () {
        exportToExcel();
    });

    function exportToExcel() {
        let wb = XLSX.utils.book_new();
        let rows = [];

        document.querySelectorAll("#productTable tbody tr").forEach(tr => {
            let row = [];
            tr.querySelectorAll("td").forEach(td => {
                let input = td.querySelector("input");
                row.push(input ? input.value : td.textContent);
            });
            if (row.length > 0) rows.push(row);
        });

        let ws = XLSX.utils.aoa_to_sheet(rows);
        XLSX.utils.book_append_sheet(wb, ws, "Inventario");
        XLSX.writeFile(wb, "inventario.xlsx");
    }

    // Iniciar
    loadFromLocalStorage();
});