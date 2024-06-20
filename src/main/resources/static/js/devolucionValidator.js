document.addEventListener("DOMContentLoaded", function () {
    var fechaDevolucionInput = document.getElementById("fecha_devolucion_efectuada");
    var today = new Date().toISOString().split('T')[0];
    fechaDevolucionInput.setAttribute('max', today);
});

document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var fechaDevolucion = document.getElementById("fecha_devolucion_efectuada").value;
    var idPrestamo = document.getElementById("id_prestamo").value;

    // Validar campos vacíos
    if (fechaDevolucion.trim() === "" || idPrestamo.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que la fecha de devolución no sea futura
    var today = new Date().toISOString().split('T')[0];
    if (fechaDevolucion > today) {
        alert("La fecha de devolución no puede ser en el futuro.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("La devolución se registró correctamente.");
    }
});
