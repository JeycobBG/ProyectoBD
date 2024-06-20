document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarMultaForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var requiredFields = [
                { id: "monto", message: "Por favor complete todos los campos." },
                { id: "dias_atraso", message: "Por favor complete todos los campos." },
                { id: "prestamo", message: "Por favor complete todos los campos." }
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
