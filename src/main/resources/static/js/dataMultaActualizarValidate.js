document.addEventListener("DOMContentLoaded", function () {
    // No es necesario establecer ninguna validación específica en el evento DOMContentLoaded para este formulario.
});

document.getElementById("actualizarMultaForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var monto = document.getElementById("monto").value;
    var diasAtraso = document.getElementById("dias_atraso").value;

    // Validar campos vacíos
    if (monto.trim() === "" || diasAtraso.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que el monto y los días de atraso contengan solo números
    if (!/^\d+$/.test(monto)) {
        alert("El monto debe contener solo números.");
        event.preventDefault();
        valid = false;
    }

    if (!/^\d+$/.test(diasAtraso)) {
        alert("Los días de atraso deben contener solo números.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("La multa se actualizó correctamente.");
    }
});
