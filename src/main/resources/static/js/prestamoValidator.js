
// Validación del formulario
document.getElementById("registrarPrestamoForm").addEventListener("submit", function (event) {
    var fechaPrestamo = document.getElementById("fecha_prestamo").value;
    var fechaDevolucionPrevista = document.getElementById("fecha_devolucion_prevista").value;

    // Obtener la fecha actual
    var fechaActual = new Date().toISOString().split('T')[0];

    // Validar que la fecha de préstamo no sea en el futuro
    if (fechaPrestamo > fechaActual) {
        alert("La fecha de préstamo no puede ser en el futuro.");
        event.preventDefault();
    }
});
