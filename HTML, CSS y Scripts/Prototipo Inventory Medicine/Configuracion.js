document.addEventListener("DOMContentLoaded", function () {
    const inventoryButton = document.querySelector(".Inventory");
    const salesButton = document.querySelector(".Sales");
    const buyButton = document.querySelector(".Buy");
    const configurationButton = document.querySelector(".Configuration");
    const exitbutton = document.querySelector(".logout")

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

});
