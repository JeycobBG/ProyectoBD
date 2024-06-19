
document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById('registrarAutorForm'); // Asegúrate de que este ID coincida con el ID de tu formulario
    if (form) {
        form.addEventListener('submit', function(e) {
            e.preventDefault(); // Previene el envío normal del formulario
            form.submit(); // Envía el formulario
            mostrarMensajeExito(); // Muestra el mensaje de éxito después de enviar el formulario
        });
    }
});

function mostrarMensajeExito() {
    alert("Agregado con éxito."); // Usa alert para un mensaje simple, o modifica para usar un elemento en el DOM
}
