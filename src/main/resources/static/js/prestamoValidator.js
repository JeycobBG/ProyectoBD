document.addEventListener("DOMContentLoaded", function () {
    var fechaPrestamoInput = document.getElementById("fecha_prestamo");
    var today = new Date().toISOString().split('T')[0];
    fechaPrestamoInput.setAttribute('max', today);
});

document.getElementById("registrarPrestamoForm").addEventListener("submit", function (event) {
    var fechaPrestamo = document.getElementById("fecha_prestamo").value;
    var fechaDevolucionPrevista = document.getElementById("fecha_devolucion_prevista").value;

    var fechaHoy = new Date().toISOString().split('T')[0];
    if (fechaPrestamo > fechaHoy) {
        alert("La fecha de préstamo no puede ser en el futuro.");
        event.preventDefault();
        return;
    }

    if (fechaDevolucionPrevista < fechaPrestamo) {
        alert("La fecha de devolución prevista no puede ser antes de la fecha de préstamo.");
        event.preventDefault();
        return;
    }
});
