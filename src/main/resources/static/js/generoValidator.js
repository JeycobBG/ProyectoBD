document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var nombre = document.getElementById("nombre").value;
    var descripcion = document.getElementById("descripcion").value;

    // Validar que el nombre del género no esté vacío
    if (nombre.trim() === "") {
        alert("Por favor ingrese el nombre del género.");
        valid = false;
        event.preventDefault();
    }

    // Validar que el nombre del género no contenga números
    if (/[\d]/.test(nombre)) {
        alert("El nombre del género no debe contener números.");
        valid = false;
        event.preventDefault();
    }

    // Validar que la descripción no esté vacía
    if (descripcion.trim() === "") {
        alert("Por favor ingrese la descripción del género.");
        valid = false;
        event.preventDefault();
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El formulario se envió correctamente.");
    }
});
