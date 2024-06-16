// validacion.js

function validarFormulario() {
    var fechaDevolucionEfectuada = new Date(document.getElementById("fechaDevolucionEfectuada").value);
    var prestamo = document.getElementById("prestamo").value;
    var fechaActual = new Date();
    var errorDiv = document.getElementById("errorMessage");
    var exitoDiv = document.getElementById("exitoMessage");
    
    if (fechaDevolucionEfectuada === "" || prestamo.trim() === "") {
        errorDiv.innerText = "Por favor complete todos los campos.";
        errorDiv.style.display = "block";
        exitoDiv.style.display = "none";
        return false;
    } else if (fechaDevolucionEfectuada > fechaActual) {
        errorDiv.innerText = "La fecha de devolución efectuada no puede ser una fecha futura.";
        errorDiv.style.display = "block";
        exitoDiv.style.display = "none";
        return false;
    }
    errorDiv.style.display = "none";
    exitoDiv.style.display = "none";
    return true;
}
