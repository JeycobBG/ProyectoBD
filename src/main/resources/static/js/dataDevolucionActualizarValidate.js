document.addEventListener("DOMContentLoaded", function () {
    // No se necesita ninguna acción específica en el evento DOMContentLoaded para este formulario.
});

document.getElementById("actualizarDevolucionForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    // Obtener los valores de los campos
    var fechaDevolucionEfectuada = document.getElementById("fecha_devolucion_efectuada").value;
    var idPrestamo = document.getElementById("prestamo").value;

    // Validar campos vacíos
    if (fechaDevolucionEfectuada.trim() === "" || idPrestamo.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    if (valid) {
        alert("La devolución se actualizó correctamente.");
    }
});
