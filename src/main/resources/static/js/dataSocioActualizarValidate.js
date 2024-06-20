document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarSocioForm");
    var mensajeExito = document.getElementById('mensajeExito'); // Asegúrate de tener este elemento en tu HTML
    var mensajeError = document.getElementById('mensajeError'); // Para mostrar mensajes de error

    if (form) {
        form.addEventListener("submit", function(event) {
            var nombre = document.getElementById("nombre").value.trim();
            var primerApellido = document.getElementById("primer_apellido").value.trim();
            var segundoApellido = document.getElementById("segundo_apellido").value.trim();
            var identificacion = document.getElementById("identificacion").value.trim();
            var codigoPostal = document.getElementById("codigo_postal").value.trim();
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) {
                mensajeError.textContent = '';
                mensajeError.style.display = 'none';
            }
            
            if (!/^[a-zA-Z\s]+$/.test(nombre) || !/^[a-zA-Z\s]+$/.test(primerApellido) ||
                !/^[a-zA-Z\s]+$/.test(segundoApellido)) {
                mensajeError.textContent = "Nombre y apellidos deben contener solo letras.";
                valid = false;
                event.preventDefault();
            }

            if (!/^[0-9]+$/.test(codigoPostal)) {
                mensajeError.textContent += (mensajeError.textContent.length ? " " : "") + "El código postal debe contener solo números.";
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
