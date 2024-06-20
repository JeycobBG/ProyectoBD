document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarDevolucionForm");
    if (form) {
        form.addEventListener("submit", function(event) {
            var requiredFields = [
                { id: "fecha_devolucion_efectuada", message: "Por favor ingrese la fecha de devolución efectuada." },
                { id: "prestamo", message: "Por favor seleccione un préstamo." }
            ];
            var valid = true;
            var message = "";
            var mensajeExito = document.getElementById('mensajeExito'); 

            if (mensajeExito) mensajeExito.style.display = 'none';

            requiredFields.forEach(function(field) {
                var value = document.getElementById(field.id).value.trim();
                if (!value) {
                    alert(field.message);
                    valid = false;
                    event.preventDefault();
                }
            });

            if (valid && mensajeExito) {
                mensajeExito.innerText = "Actualizado con éxito.";
                mensajeExito.style.display = 'block';
            }
        });
    }
});
