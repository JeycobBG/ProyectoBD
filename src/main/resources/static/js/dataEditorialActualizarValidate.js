document.addEventListener("DOMContentLoaded", function () {
    // No se necesita ninguna acción específica en el evento DOMContentLoaded para este formulario.
});

document.getElementById("actualizarEditorialForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    // Obtener los valores de los campos
    var nombre = document.getElementById("nombre").value;
    var fechaFundacion = document.getElementById("fecha_fundacion").value;
    var codigoPostal = document.getElementById("codigo_postal").value;
    var descripcionDireccion = document.getElementById("descripcion_direccion").value;
    var idDistrito = document.getElementById("id_distrito").value;

    // Validar campos vacíos
    if (nombre.trim() === "" || fechaFundacion.trim() === "" || codigoPostal.trim() === "" || descripcionDireccion.trim() === "" || idDistrito.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar formato de código postal (solo dígitos)
    var codigoPostalPattern = /^\d+$/;
    if (!codigoPostalPattern.test(codigoPostal)) {
        alert("El código postal debe contener solo números.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("La editorial se actualizó correctamente.");
    }
});
