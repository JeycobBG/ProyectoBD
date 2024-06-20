document.addEventListener("DOMContentLoaded", function() {
    var form = document.getElementById("actualizarGeneroForm");
    var mensajeExito = document.getElementById('mensajeExito'); 
    var mensajeError = document.getElementById('mensajeError'); 

    if (form) {
        form.addEventListener("submit", function(event) {
            var requiredFields = [
                { id: "nombre", message: "Por favor ingrese el nombre del género." },
                { id: "descripcion", message: "Por favor ingrese la descripción del género." }
            ];
            var valid = true;

            if (mensajeExito) mensajeExito.style.display = 'none';
            if (mensajeError) mensajeError.textContent = '';

            requiredFields.forEach(function(field) {
                var value = document.getElementById(field.id).value.trim();
                if (field.id === "nombre") {
                    if (value === "") {
                        if (mensajeError) mensajeError.textContent = field.message;
                        valid = false;
                        event.preventDefault();
                    } else if (/[\d]/.test(value)) {
                        alert("El nombre del género no debe contener números.");
                        valid = false;
                        event.preventDefault();
                    }
                } else {
                    if (value === "") {
                        if (mensajeError) mensajeError.textContent = field.message;
                        valid = false;
                        event.preventDefault();
                    }
                }
            });

            if (valid && mensajeExito) {
                mensajeExito.textContent = "Actualizado con éxito.";
                mensajeExito.style.display = 'block';
            }
        });
    }
});
