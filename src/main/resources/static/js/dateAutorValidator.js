// Validación del formulario
document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var requiredFields = ["nombre", "primer_apellido", "primer_apellido", "identificacion", "codigo_postal", "descripcion_direccion", "id_distrito", "numero_telefono", "email", "bibliografia"];
    var valid = true;

    requiredFields.forEach(function (field) {
        var value = document.getElementById(field).value.trim();
        if (value === "") {
            valid = false;
        }
    });

    if (!valid) {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
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

document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true;
    var requiredFields = ["nombre", "primer_apellido", "segundo_apellido", "identificacion", "codigo_postal", "descripcion_direccion", "id_distrito", "numero_telefono", "email", "bibliografia"];

    // Validación de completitud
    requiredFields.forEach(function (field) {
        var value = document.getElementById(field).value.trim();
        if (value === "") {
            valid = false;
        }
    });

    // Validaciones de formato específicas
    if (!validateName(document.getElementById('nombre').value) ||
            !validateName(document.getElementById('primer_apellido').value) ||
            !validateName(document.getElementById('segundo_apellido').value) ||
            !validatePostalCode(document.getElementById('codigo_postal').value) ||
            !validatePhoneNumber(document.getElementById('numero_telefono').value)) {
        alert("Hay errores en el formato de los datos.");
        valid = false;
    }

    if (!valid) {
        event.preventDefault();
        alert("Por favor complete todos los campos correctamente.");
    }
});
