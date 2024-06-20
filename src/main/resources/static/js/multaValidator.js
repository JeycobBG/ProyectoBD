// Validación del formulario
document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var monto = document.getElementById("monto").value;
    var diasAtraso = document.getElementById("dias_atraso").value;
    var prestamo = document.getElementById("id_prestamo").value;

    // Validación de monto: solo números
    if (!/^\d+$/.test(monto)) {
        alert("El monto debe contener solo números.");
        event.preventDefault();
        valid = false;
    }

    // Validación de días de atraso: solo números
    if (!/^\d+$/.test(diasAtraso)) {
        alert("Los días de atraso deben contener solo números.");
        event.preventDefault();
        valid = false;
    }

    // Validaciones adicionales
    if (monto.trim() === "" || diasAtraso.trim() === "" || prestamo === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("La multa se registro correctamente.");
    }
});
