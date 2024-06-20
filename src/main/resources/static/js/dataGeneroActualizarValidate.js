document.addEventListener("DOMContentLoaded", function () {
    // No es necesario establecer ninguna validación específica en el evento DOMContentLoaded para este formulario.
});

document.getElementById("actualizarGeneroForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    // Obtener los valores de los campos
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;

    // Validar campos vacíos
    if (nombre.trim() === "" || descripcion.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El género se actualizó correctamente.");
    }
});
