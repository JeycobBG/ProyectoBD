document.addEventListener("DOMContentLoaded", function () {
    // No es necesario establecer ninguna validación específica en el evento DOMContentLoaded para este formulario.
});

document.getElementById("actualizarPrestamoForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var fechaPrestamo = document.getElementById("fecha_prestamo").value;
    var fechaDevolucionPrevista = document.getElementById("fecha_devolucion_prevista").value;
    var idLibro = document.getElementById("libro").value;
    var idSocio = document.getElementById("socio").value;

    // Validar campos vacíos
    if (fechaPrestamo.trim() === "" || fechaDevolucionPrevista.trim() === "" || idLibro.trim() === "" || idSocio.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que la fecha de devolución prevista sea posterior a la fecha de préstamo
    if (fechaPrestamo >= fechaDevolucionPrevista) {
        alert("La fecha de devolución prevista debe ser posterior a la fecha de préstamo.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El préstamo se actualizó correctamente.");
    }
});
