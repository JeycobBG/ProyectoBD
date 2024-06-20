
document.addEventListener("DOMContentLoaded", function () {
    var form = document.getElementById("actualizarEditorialForm");
    if (form) {
        form.addEventListener("submit", function (event) {
            var valid = true;
            var mensajeExito = document.getElementById('mensajeExito'); 

            if (mensajeExito)
                mensajeExito.style.display = 'none';

            var nombre = document.getElementById("nombre").value.trim();
            var fechaFundacion = document.getElementById("fechaFundacion").value.trim();
            var codigoPostal = document.getElementById("codigoPostal").value.trim();
            var descripcionDireccion = document.getElementById("descripcionDireccion").value.trim();
            var distrito = document.getElementById("distrito").value.trim();

            if (/[\d]/.test(nombre)) {
                alert("El nombre de la editorial no debe contener números.");
                valid = false;
                event.preventDefault();
            }

            if (!/^[0-9]+$/.test(codigoPostal)) {
                alert("El código postal debe contener solo números.");
                valid = false;
                event.preventDefault();
            }

            if (fechaFundacion === "") {
                alert("Por favor ingrese la fecha de fundación.");
                valid = false;
                event.preventDefault();
            } else {
                var today = new Date();
                var inputDate = new Date(fechaFundacion);
                if (inputDate > today) {
                    alert("La fecha de fundación no puede ser en el futuro.");
                    valid = false;
                    event.preventDefault();
                }
            }

            if (descripcionDireccion === "") {
                alert("Por favor ingrese la descripción de la dirección.");
                valid = false;
                event.preventDefault();
            }

            if (distrito === "") {
                alert("Por favor seleccione un distrito.");
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
