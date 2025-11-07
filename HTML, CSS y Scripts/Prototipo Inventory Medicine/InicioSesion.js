document.addEventListener("DOMContentLoaded", function() {
    const togglePassword = document.getElementById("togglePassword");
    const passwordField = document.getElementById("password");
    const loginButton = document.querySelector(".login-button");

    if (togglePassword && passwordField) {
        togglePassword.addEventListener("click", function() {
            passwordField.type = passwordField.type === "password" ? "text" : "password";
        });
    }

    if (loginButton) {
        loginButton.addEventListener("click", function() {
            const email = document.querySelector('input[type="email"]').value;
            const password = passwordField ? passwordField.value : "";

            if (email && password) {
                window.location.href = "Inventario.html";
            } else {
                alert("Por favor, completa todos los campos.");
            }
        });
    }
});
