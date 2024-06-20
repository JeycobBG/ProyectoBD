document.addEventListener("DOMContentLoaded", function () {
    var fechaRegistroInput = document.getElementById("fecha_registro");
    var today = new Date().toISOString().split('T')[0];
    fechaRegistroInput.setAttribute('max', today);
});

document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var nombre = document.getElementById("nombre").value;
    var primerApellido = document.getElementById("primer_apellido").value;
    var segundoApellido = document.getElementById("segundo_apellido").value;
    var identificacion = document.getElementById("identificacion").value;
    var codigoPostal = document.getElementById("codigo_postal").value;
    var descripcionDireccion = document.getElementById("descripcion_direccion").value;
    var distrito = document.getElementById("id_distrito").value;
    var numeroTelefono = document.getElementById("numero_telefono").value;
    var email = document.getElementById("email").value;
    var fechaRegistro = document.getElementById("fecha_registro").value;

    // Validar campos vacíos
    if (nombre.trim() === "" || primerApellido.trim() === "" || segundoApellido.trim() === "" || identificacion.trim() === "" ||
        codigoPostal.trim() === "" || descripcionDireccion.trim() === "" || distrito.trim() === "" || numeroTelefono.trim() === "" ||
        email.trim() === "" || fechaRegistro.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que la fecha de registro no sea futura
    var today = new Date().toISOString().split('T')[0];
    if (fechaRegistro > today) {
        alert("La fecha de registro no puede ser en el futuro.");
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
        alert("El socio se registró correctamente.");
    }
});
