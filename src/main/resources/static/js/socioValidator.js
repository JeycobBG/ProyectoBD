document.addEventListener("DOMContentLoaded", function() {
        var form = document.getElementById("registrarForm");
    var mensajeError = document.getElementById('mensajeError'); // Asegúrate de tener este elemento en tu HTML para mostrar errores

    if (form) {
        form.addEventListener("submit", function(event) {
            var nombre = document.getElementById("nombre").value.trim();
            var primerApellido = document.getElementById("primer_apellido").value.trim();
            var segundoApellido = document.getElementById("segundo_apellido").value.trim();
            var identificacion = document.getElementById("identificacion").value.trim();
            var codigoPostal = document.getElementById("codigo_postal").value.trim();
            var fechaRegistro = document.getElementById("fecha_registro").value;
            var idDistrito = document.getElementById("id_distrito").value.trim();
            var valid = true;

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
                mensajeError.textContent = "El código postal debe contener solo números.";
                valid = false;
                event.preventDefault();
            }

            var fechaHoy = new Date().toISOString().split("T")[0]; 
            if (fechaRegistro > fechaHoy) {
                mensajeError.textContent = "La fecha de registro no puede ser en el futuro.";
                valid = false;
                event.preventDefault();
            }

            if (idDistrito === "") {
                mensajeError.textContent += (mensajeError.textContent.length ? " " : "") + "Por favor selecciona un distrito.";
                valid = false;
                event.preventDefault();
            }

            if (!valid && mensajeError) {
                mensajeError.style.display = 'block';
            }
       
        });
    }
});
