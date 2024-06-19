
// Validación del formulario
document.getElementById("registrarSocioForm").addEventListener("submit", function (event) {
    var codigoPostal = document.getElementById("codigo_postal").value;
    var fechaRegistro = document.getElementById("fecha_registro").value;
    var idDistrito = document.getElementById("id_distrito").value;

    // Validar que el código postal solo contenga números
    if (!/^[0-9]+$/.test(codigoPostal)) {
        alert("El código postal debe contener solo números.");
        event.preventDefault();
        return;
    }

    // Validar que la fecha de registro no sea en el futuro
    var fechaHoy = new Date().toISOString().split("T")[0]; // Obtener la fecha de hoy en formato ISO
    if (fechaRegistro > fechaHoy) {
        alert("La fecha de registro no puede ser en el futuro.");
        event.preventDefault();
        return;
    }

    // Validar que se haya seleccionado un distrito
    if (idDistrito === "") {
        alert("Por favor selecciona un distrito.");
        event.preventDefault();
        return;
    }
});