document.addEventListener("DOMContentLoaded", function () {
    var form = document.getElementById("actualizarEditorialForm");
    if (form) {
        form.addEventListener("submit", function (event) {
            var requiredFields = [
                { id: "nombre", message: "El nombre de la editorial no debe contener números." },
                { id: "fecha_fundacion", message: "Por favor ingrese la fecha de fundación." },
                { id: "codigo_postal", message: "El código postal debe contener solo números." },
                { id: "descripcion_direccion", message: "Por favor ingrese la descripción de la dirección." },
                { id: "id_distrito", message: "Por favor seleccione un distrito." }
            ];
            var valid = true;
            var mensajeExito = document.getElementById('mensajeExito'); 

            if (mensajeExito)
                mensajeExito.style.display = 'none';

            requiredFields.forEach(function(field) {
                var value = document.getElementById(field.id).value.trim();
                if (field.id === "fecha_fundacion") {
                    var today = new Date();
                    var inputDate = new Date(value);
                    if (value === "" || inputDate > today) {
                        alert(field.message);
                        valid = false;
                        event.preventDefault();
                    }
                } else {
                    if (field.id === "codigo_postal") {
                        if (!/^[0-9]+$/.test(value)) {
                            alert(field.message);
                            valid = false;
                            event.preventDefault();
                        }
                    } else {
                        if (value === "") {
                            alert(field.message);
                            valid = false;
                            event.preventDefault();
                        }
                    }
                }
            });

            if (valid && mensajeExito) {
                mensajeExito.innerText = "Actualizado con éxito.";
                mensajeExito.style.display = 'block';
            }
        });
    }
});
