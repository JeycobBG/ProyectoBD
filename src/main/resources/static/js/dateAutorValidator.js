 // Validación del formulario
        document.getElementById("registrarAutorForm").addEventListener("submit", function(event) {
            var requiredFields = ["nombre", "primer_apellido", "primer_apellido", "identificacion", "codigo_postal", "descripcion_direccion", "id_distrito", "numero_telefono", "email", "bibliografia"];
            var valid = true;

            requiredFields.forEach(function(field) {
                var value = document.getElementById(field).value.trim();
                if (value === "") {
                    valid = false;
                }
            });

            if (!valid) {
                alert("Por favor complete todos los campos.");
                event.preventDefault();
            }
        });

