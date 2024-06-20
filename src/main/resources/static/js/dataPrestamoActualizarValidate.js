
document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarPrestamoForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var fechaPrestamo = document.getElementById("fechaPrestamo").value;
            var fechaDevolucionPrevista = document.getElementById("fechaDevolucionPrevista").value;
            var fechaActual = new Date().toISOString().split('T')[0]; // Obtener la fecha actual
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) {
                mensajeError.textContent = '';
                mensajeError.style.display = 'none';
            }

            if (fechaPrestamo > fechaActual) {
                mensajeError.textContent = "La fecha de préstamo no puede ser en el futuro.";
                valid = false;
                event.preventDefault();
            }

            if (fechaDevolucionPrevista < fechaPrestamo) {
                mensajeError.textContent += (mensajeError.textContent.length ? " " : "") + "La fecha de devolución prevista no puede ser antes de la fecha de préstamo.";
                valid = false;
                event.preventDefault();
            }

            // Mostrar mensaje de error si hay errores
            if (!valid && mensajeError) {
                mensajeError.style.display = 'block';
            }

            // Mostrar mensaje de éxito si todo es válido
            if (valid && mensajeExito) {
                mensajeExito.textContent = "Actualizado con éxito.";
                mensajeExito.style.display = 'block';
            }
        });
    }
});
