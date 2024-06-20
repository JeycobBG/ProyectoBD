document.addEventListener("DOMContentLoaded", function () {
    var fechaPublicacionInput = document.getElementById("fecha_publicacion");
    var today = new Date().toISOString().split('T')[0];
    fechaPublicacionInput.setAttribute('max', today);
});

document.getElementById("registrarForm").addEventListener("submit", function (event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var ISBN = document.getElementById("ISBN").value;
    var titulo = document.getElementById("titulo").value;
    var sinopsis = document.getElementById("sinopsis").value;
    var fechaPublicacion = document.getElementById("fecha_publicacion").value;
    var cantidad = document.getElementById("cantidad").value;
    var idAutor = document.getElementById("id_autor").value;
    var idEditorial = document.getElementById("id_editorial").value;
    var idGeneros = document.getElementById("id_generos").value;

    // Validar campos vacíos
    if (ISBN.trim() === "" || titulo.trim() === "" || sinopsis.trim() === "" || fechaPublicacion.trim() === "" ||
        cantidad.trim() === "" || idAutor.trim() === "" || idEditorial.trim() === "" || idGeneros.trim() === "") {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    }

    // Validar que la fecha de publicación no sea futura
    var today = new Date().toISOString().split('T')[0];
    if (fechaPublicacion > today) {
        alert("La fecha de publicación no puede ser en el futuro.");
        event.preventDefault();
        valid = false;
    }

    // Validar que la cantidad sea un número entero positivo
    if (!/^\d+$/.test(cantidad)) {
        alert("La cantidad debe ser un número entero positivo.");
        event.preventDefault();
        valid = false;
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El libro se registró correctamente.");
    }
});


function concatenarIds() {
    const select = document.getElementById('generos');
    let selectedIds = [];
    for (let option of select.options) {
        if (option.selected) {
            selectedIds.push(option.value);
        }
    }
    document.getElementById('id_generos').value = selectedIds.join(',');
}
