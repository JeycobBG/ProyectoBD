
document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarMultaForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var monto = document.getElementById("monto").value.trim();
            var diasAtraso = document.getElementById("dias_atraso").value.trim();
            var prestamo = document.getElementById("prestamo").value.trim();
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) {
                mensajeError.textContent = '';
                mensajeError.style.display = 'none';
            }

            if (monto === "" || diasAtraso === "" || prestamo === "") {
                mensajeError.textContent = "Por favor complete todos los campos.";
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
