// Validación del formulario
        document.getElementById("registrarEditorialForm").addEventListener("submit", function(event) {
            var nombre = document.getElementById("nombre").value;
            var fechaFundacion = document.getElementById("fechaFundacion").value;
            var codigoPostal = document.getElementById("codigoPostal").value;
            var descripcionDireccion = document.getElementById("descripcionDireccion").value;
            var distrito = document.getElementById("distrito").value;
            
            // Validar que el nombre de la editorial no esté vacío
            if (nombre.trim() === "") {
                alert("Por favor ingrese el nombre de la editorial.");
                event.preventDefault();
            }
            s
            // Validar que la fecha de fundación no esté vacía
            if (fechaFundacion.trim() === "") {
                alert("Por favor ingrese la fecha de fundación.");
                event.preventDefault();
            } else {
                // Obtener la fecha actual
                var today = new Date();
                var yyyy = today.getFullYear();
                var mm = String(today.getMonth() + 1).padStart(2, '0'); // Enero es 0
                var dd = String(today.getDate()).padStart(2, '0');
                var currentDate = yyyy + '-' + mm + '-' + dd;
                
                // Validar que la fecha de fundación no sea en el futuro
                if (fechaFundacion > currentDate) {
                    alert("La fecha de fundación no puede ser en el futuro.");
                    event.preventDefault();
                }
            }
            
            // Validar que el código postal no esté vacío
            if (codigoPostal.trim() === "") {
                alert("Por favor ingrese el código postal.");
                event.preventDefault();
            }

            // Validar que la descripción de la dirección no esté vacía
            if (descripcionDireccion.trim() === "") {
                alert("Por favor ingrese la descripción de la dirección.");
                event.preventDefault();
            }

            // Validar que se haya seleccionado un distrito
            if (distrito === "") {
                alert("Por favor seleccione un distrito.");
                event.preventDefault();
            }
        });

