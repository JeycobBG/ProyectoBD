document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarLibroForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var isbn = document.getElementById("isbn").value.trim();
            var titulo = document.getElementById("titulo").value.trim();
            var sinopsis = document.getElementById("sinopsis").value.trim();
            var fechaPublicacion = document.getElementById("fecha_publicacion").value.trim();
            var cantidad = document.getElementById("cantidad").value.trim();
            var autor = document.getElementById("autor").value.trim();
            var editorial = document.getElementById("editorial").value.trim();
            var generos = document.getElementById("generos").selectedOptions;
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) {
                mensajeError.textContent = '';
                mensajeError.style.display = 'none';
            }

            if (isbn === "" || titulo === "" || sinopsis === "" || fechaPublicacion === "" ||
                cantidad === "" || autor === "" || editorial === "" || generos.length === 0) {
                mensajeError.textContent = "Por favor complete todos los campos.";
                valid = false;
                event.preventDefault();
            } else {
                if (isNaN(cantidad)) {
                    mensajeError.textContent = "La cantidad debe ser un número.";
                    valid = false;
                    event.preventDefault();
                }

                var currentDate = new Date().toISOString().split('T')[0];
                if (fechaPublicacion > currentDate) {
                    mensajeError.textContent = "La fecha de publicación no puede ser una fecha futura.";
                    valid = false;
                    event.preventDefault();
                }
            }

            if (!valid && mensajeError) {
                mensajeError.style.display = 'block';
            }

            if (valid && mensajeExito) {
                mensajeExito.textContent = "Actualizado con éxito.";
                mensajeExito.style.display = 'block';
            }
        });
    }
});
