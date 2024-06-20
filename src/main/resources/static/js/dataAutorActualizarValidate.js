// Validación del formulario
document.getElementById("actualizarAutorForm").addEventListener("submit", function(event) {
    var requiredFields = [
        { id: "nombre", validator: validateName },
        { id: "primer_apellido", validator: validateName },
        { id: "segundo_apellido", validator: validateName },
        { id: "identificacion", validator: function(input) { return input.trim() !== ''; } },
        { id: "codigo_postal", validator: validatePostalCode },
        { id: "descripcion_direccion", validator: function(input) { return input.trim() !== ''; } },
        { id: "id_distrito", validator: function(input) { return input.trim() !== ''; } },
        { id: "numero_telefono", validator: validatePhoneNumber },
        { id: "email", validator: function(input) { return input.trim() !== ''; } },
        { id: "bibliografia", validator: function(input) { return input.trim() !== ''; } }
    ];
    var valid = true;
    var message = "";

    requiredFields.forEach(function(field) {
        var value = document.getElementById(field.id).value;
        if (!field.validator(value)) {
            valid = false;
            message += "Por favor revise el campo: " + field.id.replace(/_/g, " ") + ".\n";
        }
    });

    if (!valid) {
        alert(message); // Se muestra una alerta con todos los errores de validación
        event.preventDefault();
    } else {
        alert("Actualizado con éxito."); // Mensaje de éxito si todo es válido
    }
});

function validatePostalCode(input) {
    const re = /^[0-9]+$/;
    return re.test(input);
}

function validatePhoneNumber(input) {
    const re = /^[0-9]+$/;
    return re.test(input);
}

function validateName(input) {
    const re = /^[a-zA-Z\s]+$/;
    return re.test(input);
}


document.addEventListener("DOMContentLoaded", function() {
    var generosAsociados = '';
    var selectGeneros = document.getElementById("generos");

    for (var i = 0; i < selectGeneros.options.length; i++) {
        var option = selectGeneros.options[i];
        if (generosAsociados.includes(option.value)) {
            option.selected = true;
        }
    }
});