document.addEventListener("DOMContentLoaded", function () {
    var fechaDevolucionEfectuadaInput = document.getElementById("fecha_devolucion_efectuada");
    var today = new Date().toISOString().split('T')[0];
    fechaDevolucionEfectuadaInput.setAttribute('max', today);
});

document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var fechaDevolucionEfectuada = document.getElementById("fecha_devolucion_efectuada").value;
    var idPrestamo = document.getElementById("id_prestamo").value;

    if (idPrestamo === "") {
        alert("Por favor seleccione un préstamo.");
        event.preventDefault();
        return;
    }

    var fechaHoy = new Date().toISOString().split('T')[0];
    if (fechaDevolucionEfectuada > fechaHoy) {
        alert("La fecha de devolución efectuada no puede ser en el futuro.");
        event.preventDefault();
        return;
    }
});
