document.addEventListener("DOMContentLoaded", function () {
});

document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var monto = document.getElementById("monto").value;
    var diasAtraso = document.getElementById("dias_atraso").value;
    var idPrestamo = document.getElementById("id_prestamo").value;

    // Validar campos vacíos
    if (monto.trim() === "" || diasAtraso.trim() === "" || idPrestamo.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que el monto sea un número válido
    if (isNaN(monto) || parseFloat(monto) <= 0) {
        alert("El monto de la multa debe ser un número válido y mayor que cero.");
        event.preventDefault();
        valid = false;
    }

    // Validar que los días de atraso sean un número entero positivo
    if (!/^\d+$/.test(diasAtraso)) {
        alert("Los días de atraso deben ser un número entero positivo.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("La multa se registró correctamente.");
    }
});
