document.addEventListener("DOMContentLoaded", function () {
    // No es necesario establecer ninguna validación específica en el evento DOMContentLoaded para este formulario.
});

document.getElementById("actualizarSocioForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var nombre = document.getElementById("nombre").value;
    var primerApellido = document.getElementById("primer_apellido").value;
    var segundoApellido = document.getElementById("segundo_apellido").value;
    var identificacion = document.getElementById("identificacion").value;
    var codigoPostal = document.getElementById("codigo_postal").value;
    var descripcionDireccion = document.getElementById("descripcion_direccion").value;

    // Validar campos vacíos
    if (nombre.trim() === "" || primerApellido.trim() === "" || segundoApellido.trim() === "" ||
        identificacion.trim() === "" || codigoPostal.trim() === "" || descripcionDireccion.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que el código postal contenga solo números
    if (!/^\d+$/.test(codigoPostal)) {
        alert("El código postal debe contener solo números.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El socio se actualizó correctamente.");
    }
});
