document.addEventListener("DOMContentLoaded", function () {
    var fechaPublicacionInput = document.getElementById("fecha_publicacion");
    var today = new Date().toISOString().split('T')[0];
    fechaPublicacionInput.setAttribute('max', today);
});

document.getElementById("registrarForm").addEventListener("submit", function(event) {
    var valid = true; // Variable para rastrear la validez del formulario
    
    var isbn = document.getElementById("ISBN").value;
    var titulo = document.getElementById("titulo").value;
    var sinopsis = document.getElementById("sinopsis").value;
    var fechaPublicacion = document.getElementById("fecha_publicacion").value;
    var cantidad = document.getElementById("cantidad").value;
    var autor = document.getElementById("id_autor").value;
    var editorial = document.getElementById("id_editorial").value;
    var generos = document.getElementById("generos").selectedOptions;

    if (isbn.trim() === "" || titulo.trim() === "" || sinopsis.trim() === "" || 
        fechaPublicacion.trim() === "" || cantidad.trim() === "" || autor === "" || 
        editorial === "" || generos.length === 0) {
        alert("Por favor complete todos los campos.");
        event.preventDefault();
        valid = false;
    } else {
        if (isNaN(cantidad)) {
            alert("La cantidad debe ser un número.");
            event.preventDefault();
            valid = false;
        }

        var today = new Date().toISOString().split('T')[0];
        if (fechaPublicacion > today) {
            alert("La fecha de publicación no puede ser una fecha futura.");
            event.preventDefault();
            valid = false;
        }
    }

    // Mostrar mensaje de éxito si el formulario es válido
    if (valid) {
        alert("El formulario se envió correctamente.");
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
