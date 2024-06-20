document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var fechaPrestamo = document.getElementById("fecha_prestamo").value;
    var fechaDevolucionPrevista = document.getElementById("fecha_devolucion_prevista").value;

    var fechaHoy = new Date().toISOString().split('T')[0];
    if (fechaPrestamo > fechaHoy) {
        alert("La fecha de préstamo no puede ser en el futuro.");
        event.preventDefault();
        valid = false;
    }

    if (fechaDevolucionPrevista < fechaPrestamo) {
        alert("La fecha de devolución prevista no puede ser antes de la fecha de préstamo.");
        event.preventDefault();
        valid = false;
    }

    // Validar campos vacíos
    var inputs = document.querySelectorAll("input[type=date], select");
    inputs.forEach(function(input) {
        if (!input.value.trim()) {
            alert("Por favor complete todos los campos.");
            event.preventDefault();
            valid = false;
        }
    });

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El préstamo se registró correctamente.");
    }
});
