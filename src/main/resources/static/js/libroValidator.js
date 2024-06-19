
 // Validación del formulario
        document.getElementById("registrarLibroForm").addEventListener("submit", function(event) {
            var isbn = document.getElementById("ISBN").value;
            var titulo = document.getElementById("titulo").value;
            var sinopsis = document.getElementById("sinopsis").value;
            var fechaPublicacion = document.getElementById("fecha_publicacion").value;
            var cantidad = document.getElementById("cantidad").value;
            var autor = document.getElementById("id_autor").value;
            var editorial = document.getElementById("id_editorial").value;
            var generos = document.getElementById("id_generos").selectedOptions;
            
            // Validaciones
            if (isbn.trim() === "" || titulo.trim() === "" || sinopsis.trim() === "" || 
                fechaPublicacion.trim() === "" || cantidad.trim() === "" || autor === "" || 
                editorial === "" || generos.length === 0) {
                alert("Por favor complete todos los campos.");
                event.preventDefault();
            } else {
                // Validar que la cantidad sea un número
                if (isNaN(cantidad)) {
                    alert("La cantidad debe ser un número.");
                    event.preventDefault();
                }

                // Validar que la fecha de publicación no sea una fecha futura
                var currentDate = new Date().toISOString().split('T')[0];
                if (fechaPublicacion > currentDate) {
                    alert("La fecha de publicación no puede ser una fecha futura.");
                    event.preventDefault();
                }
            }
        });
        
        //Concatenar ids:
        function concatenarIds() {
            const select = document.getElementById('generos');
            let selectedIds = [];
            for (let option of select.options) {
                if (option.selected) {
                    selectedIds.push(option.value);
                }
            }
            document.getElementById('id_generos').value = selectedIds.join(',');
        }
