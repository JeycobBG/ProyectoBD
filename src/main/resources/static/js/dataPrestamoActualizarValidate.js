document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarPrestamoForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var fechaPrestamo = document.getElementById("fecha_prestamo").value;
            var fechaDevolucionPrevista = document.getElementById("fecha_devolucion_prevista").value;
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
                if (mensajeError.textContent.length > 0) {
                    mensajeError.textContent += " ";
                }
                mensajeError.textContent += "La fecha de devolución prevista no puede ser antes de la fecha de préstamo.";
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
