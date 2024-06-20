
document.addEventListener("DOMContentLoaded", function () {
    var fechaFundacionInput = document.getElementById("fecha_fundacion");
    var today = new Date().toISOString().split('T')[0];
    fechaFundacionInput.setAttribute('max', today);
});

document.getElementById("registrarEditorialForm").addEventListener("submit", function (event) {
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
        event.preventDefault();
    } else {
        var today = new Date().toISOString().split('T')[0];

        if (fechaFundacion > today) {
            alert("La fecha de fundación no puede ser en el futuro.");
            event.preventDefault();
        }
    }

    if (!/^[0-9]+$/.test(codigoPostal)) {
        mensajeError.textContent = "El código postal debe contener solo números.";
        valid = false;
        event.preventDefault();
    }


    if (descripcionDireccion.trim() === "") {
        alert("Por favor ingrese la descripción de la dirección.");
        event.preventDefault();
    }

    if (distrito === "") {
        alert("Por favor seleccione un distrito.");
        event.preventDefault();
    }
});
