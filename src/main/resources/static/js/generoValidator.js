
// Validación del formulario
document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;

    // Validar que el nombre del género no esté vacío
    if (nombre.trim() === "") {
        alert("Por favor ingrese el nombre del género.");
        event.preventDefault();
    }


    if (/[\d]/.test(nombre)) {
        alert("El nombre de la editorial no debe contener números.");
        valid = false;
        event.preventDefault();
    }

    // Validar que la descripción no esté vacía
    if (descripcion.trim() === "") {
        alert("Por favor ingrese la descripción del género.");
        event.preventDefault();
    }
});