document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarSocioForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var requiredFields = [
                { id: "nombre", message: "Nombre y apellidos deben contener solo letras." },
                { id: "primer_apellido", message: "Nombre y apellidos deben contener solo letras." },
                { id: "segundo_apellido", message: "Nombre y apellidos deben contener solo letras." },
                { id: "codigo_postal", message: "El código postal debe contener solo números." }
            ];
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) {
                mensajeError.textContent = '';
                mensajeError.style.display = 'none';
            }

            requiredFields.forEach(function(field) {
                var value = document.getElementById(field.id).value.trim();
                if (!/^[a-zA-Z\s]+$/.test(value) && field.id.includes("nombre")) {
                    mensajeError.textContent = field.message;
                    valid = false;
                    event.preventDefault();
                } else if (!/^[0-9]+$/.test(value) && field.id.includes("codigo_postal")) {
                    if (mensajeError.textContent.length > 0) {
                        mensajeError.textContent += " ";
                    }
                    mensajeError.textContent += field.message;
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
