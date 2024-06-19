
 // Validación del formulario
        document.getElementById("registrarMultaForm").addEventListener("submit", function(event) {
            var monto = document.getElementById("monto").value;
            var diasAtraso = document.getElementById("dias_atraso").value;
            var prestamo = document.getElementById("id_prestamo").value;
            
            // Validaciones
            if (monto.trim() === "" || diasAtraso.trim() === "" || prestamo === "") {
                alert("Por favor complete todos los campos.");
                event.preventDefault();
            }
        });
