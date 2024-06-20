document.addEventListener("DOMContentLoaded", function () {
    var fechaFundacionInput = document.getElementById("fecha_fundacion");
    var today = new Date().toISOString().split('T')[0];
    fechaFundacionInput.setAttribute('max', today);
});

document.getElementById("registrarEditorialForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var nombre = document.getElementById("nombre").value;
    var fechaFundacion = document.getElementById("fecha_fundacion").value;
    var codigoPostal = document.getElementById("codigo_postal").value;
    var descripcionDireccion = document.getElementById("descripcion_direccion").value;
    var distrito = document.getElementById("id_distrito").value;

    // Validar campos vacíos
    if (nombre.trim() === "" || fechaFundacion.trim() === "" || codigoPostal.trim() === "" ||
        descripcionDireccion.trim() === "" || distrito.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que la fecha de fundación no sea futura
    var today = new Date().toISOString().split('T')[0];
    if (fechaFundacion > today) {
        alert("La fecha de fundación no puede ser en el futuro.");
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
        alert("La editorial se registró correctamente.");
    }
});
