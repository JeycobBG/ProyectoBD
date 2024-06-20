document.addEventListener("DOMContentLoaded", function () {
    var fechaRegistroInput = document.getElementById("fecha_registro");
    var today = new Date().toISOString().split('T')[0];
    fechaRegistroInput.setAttribute('max', today);
});

document.getElementById("registrarSocioForm").addEventListener("submit", function (event) {
    var nombre = document.getElementById("nombre").value;
    var primerApellido = document.getElementById("primer_apellido").value;
    var segundoApellido = document.getElementById("segundo_apellido").value;
    var identificacion = document.getElementById("identificacion").value;
    var codigoPostal = document.getElementById("codigo_postal").value;
    var descripcionDireccion = document.getElementById("descripcion_direccion").value;
    var idDistrito = document.getElementById("id_distrito").value;
    var numeroTelefono = document.getElementById("numero_telefono").value;
    var email = document.getElementById("email").value;
    var fechaRegistro = document.getElementById("fecha_registro").value;

    if (nombre.trim() === "") {
        alert("Por favor ingrese el nombre.");
        event.preventDefault();
        return;
    }

    if (primerApellido.trim() === "") {
        alert("Por favor ingrese el primer apellido.");
        event.preventDefault();
        return;
    }

    if (segundoApellido.trim() === "") {
        alert("Por favor ingrese el segundo apellido.");
        event.preventDefault();
        return;
    }

    if (identificacion.trim() === "") {
        alert("Por favor ingrese la identificación.");
        event.preventDefault();
        return;
    }

    if (!/^[0-9]+$/.test(codigoPostal)) {
        alert("El código postal debe contener solo números.");
        event.preventDefault();
        return;
    }

    if (descripcionDireccion.trim() === "") {
        alert("Por favor ingrese la descripción de la dirección.");
        event.preventDefault();
        return;
    }

    if (idDistrito === "") {
        alert("Por favor selecciona un distrito.");
        event.preventDefault();
        return;
    }

    if (numeroTelefono.trim() === "") {
        alert("Por favor ingrese el número de teléfono.");
        event.preventDefault();
        return;
    }

    if (email.trim() === "") {
        alert("Por favor ingrese el correo electrónico.");
        event.preventDefault();
        return;
    }

    var fechaHoy = new Date().toISOString().split("T")[0]; 
    if (fechaRegistro > fechaHoy) {
        alert("La fecha de registro no puede ser en el futuro.");
        event.preventDefault();
        return;
    }
});
