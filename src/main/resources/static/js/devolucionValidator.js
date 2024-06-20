document.addEventListener("DOMContentLoaded", function () {
    var fechaDevolucionEfectuadaInput = document.getElementById("fecha_devolucion_efectuada");
    var today = new Date().toISOString().split('T')[0];
    fechaDevolucionEfectuadaInput.setAttribute('max', today);
});

document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario

    var fechaDevolucionEfectuada = document.getElementById("fecha_devolucion_efectuada").value;
    var idPrestamo = document.getElementById("id_prestamo").value;

    if (idPrestamo === "") {
        alert("Por favor seleccione un préstamo.");
        valid = false;
        event.preventDefault();
    }

    var fechaHoy = new Date().toISOString().split('T')[0];
    if (fechaDevolucionEfectuada > fechaHoy) {
        alert("La fecha de devolución efectuada no puede ser en el futuro.");
        valid = false;
        event.preventDefault();
    }

    if (valid) {
        alert("Formulario enviado correctamente.");
    }
});
