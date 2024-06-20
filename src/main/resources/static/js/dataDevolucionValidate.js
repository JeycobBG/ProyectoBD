document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarDevolucionForm");
    if (form) {
        form.addEventListener("submit", function(event) {
            var fechaDevolucionEfectuada = document.getElementById("fecha_devolucion_efectuada").value.trim();
            var prestamo = document.getElementById("prestamo").value.trim();
            var valid = true;
            var mensajeExito = document.getElementById('mensajeExito'); 

            if (mensajeExito) mensajeExito.style.display = 'none';

            if (!fechaDevolucionEfectuada) {
                alert("Por favor ingrese la fecha de devolución efectuada.");
                valid = false;
                event.preventDefault();
            }

            if (!prestamo) {
                alert("Por favor seleccione un préstamo.");
                valid = false;
                event.preventDefault(); 
            }

            if (valid && mensajeExito) {
                mensajeExito.innerText = "Actualizado con éxito.";
                mensajeExito.style.display = 'block';
            }
        });
    }
});
