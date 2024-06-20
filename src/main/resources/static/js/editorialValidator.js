document.addEventListener("DOMContentLoaded", function () {
    var fechaFundacionInput = document.getElementById("fecha_fundacion");
    var today = new Date().toISOString().split('T')[0];
    fechaFundacionInput.setAttribute('max', today);
});

document.getElementById("registrarEditorialForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario

    var nombre = document.getElementById("nombre").value;
    var fechaFundacion = document.getElementById("fecha_fundacion").value;
    var codigoPostal = document.getElementById("codigoPostal").value;
    var descripcionDireccion = document.getElementById("descripcionDireccion").value;
    var distrito = document.getElementById("distrito").value;

    if (/[\d]/.test(nombre)) {
        alert("El nombre de la editorial no debe contener números.");
        valid = false;
        event.preventDefault();
    }

    if (fechaFundacion.trim() === "") {
        alert("Por favor ingrese la fecha de fundación.");
        valid = false;
        event.preventDefault();
    } else {
        var today = new Date().toISOString().split('T')[0];

        if (fechaFundacion > today) {
            alert("La fecha de fundación no puede ser en el futuro.");
            valid = false;
            event.preventDefault();
        }
    }

    if (!/^[0-9]+$/.test(codigoPostal)) {
        alert("El código postal debe contener solo números.");
        valid = false;
        event.preventDefault();
    }

    if (descripcionDireccion.trim() === "") {
        alert("Por favor ingrese la descripción de la dirección.");
        valid = false;
        event.preventDefault();
    }

    if (distrito === "") {
        alert("Por favor seleccione un distrito.");
        valid = false;
        event.preventDefault();
    }

    if (valid) {
        alert("Editorial registrado correctamente.");
    }
});
