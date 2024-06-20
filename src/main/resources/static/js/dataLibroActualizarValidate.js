document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarLibroForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var requiredFields = [
                { id: "isbn", message: "Por favor complete todos los campos." },
                { id: "titulo", message: "Por favor complete todos los campos." },
                { id: "sinopsis", message: "Por favor complete todos los campos." },
                { id: "fecha_publicacion", message: "Por favor complete todos los campos." },
                { id: "cantidad", message: "Por favor complete todos los campos." },
                { id: "autor", message: "Por favor complete todos los campos." },
                { id: "editorial", message: "Por favor complete todos los campos." },
                { id: "generos", message: "Por favor complete todos los campos." }
            ];
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) {
                mensajeError.textContent = '';
                mensajeError.style.display = 'none';
            }

            requiredFields.forEach(function(field) {
                var value = document.getElementById(field.id).value.trim();
                if (value === "") {
                    mensajeError.textContent = field.message;
                    valid = false;
                    event.preventDefault();
                }
            });

            var cantidad = document.getElementById("cantidad").value.trim();
            var fechaPublicacion = document.getElementById("fecha_publicacion").value.trim();

            if (!isNaN(cantidad) && fechaPublicacion !== "") {
                var currentDate = new Date().toISOString().split('T')[0];
                if (fechaPublicacion > currentDate) {
                    mensajeError.textContent = "La fecha de publicación no puede ser una fecha futura.";
                    valid = false;
                    event.preventDefault();
                }
            } else {
                mensajeError.textContent = "La cantidad debe ser un número.";
                valid = false;
                event.preventDefault();
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
