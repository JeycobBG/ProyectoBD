
// Validación del formulario
document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarGeneroForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var nombre = document.getElementById("nombre").value.trim();
            var descripcion = document.getElementById("descripcion").value.trim();
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) mensajeError.textContent = '';

            if (nombre === "") {
                if (mensajeError) mensajeError.textContent = "Por favor ingrese el nombre del género.";
                valid = false;
                event.preventDefault();
            }
            
            if (/[\d]/.test(nombre)) {
                alert("El nombre del género no debe contener números.");
                valid = false;
                event.preventDefault();
            }

            if (descripcion === "") {
                if (mensajeError) mensajeError.textContent = "Por favor ingrese la descripción del género.";
                valid = false;
                event.preventDefault();
            }

            if (valid && mensajeExito) {
                mensajeExito.textContent = "Actualizado con éxito.";
                mensajeExito.style.display = 'block';
            }
        });
    }
});
