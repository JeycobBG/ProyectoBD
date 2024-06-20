document.addEventListener("DOMContentLoaded", function () {
    // No es necesario establecer ninguna validación específica en el evento DOMContentLoaded para este formulario.
});

document.getElementById("actualizarLibroForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    // Obtener los valores de los campos
    var isbn = document.getElementById("ISBN").value;
    var titulo = document.getElementById("titulo").value;
    var sinopsis = document.getElementById("sinopsis").value;
    var fechaPublicacion = document.getElementById("fecha_publicacion").value;
    var cantidad = document.getElementById("cantidad").value;

    // Validar campos vacíos
    if (isbn.trim() === "" || titulo.trim() === "" || sinopsis.trim() === "" || fechaPublicacion.trim() === "" || cantidad.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que la cantidad contenga solo números
    if (!/^\d+$/.test(cantidad)) {
        alert("La cantidad debe contener solo números.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El libro se actualizó correctamente.");
    }
});
