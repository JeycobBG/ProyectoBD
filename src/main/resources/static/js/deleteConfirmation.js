// Método que funciona para la confirmación al eliminar

function confirmarEliminacion(tipo, id) {
    let mensaje = "¿Está seguro de que desea eliminar este " + tipo + "?";
    let redireccion = "/"+tipo+"/leer";
    if (confirm(mensaje)) {
        fetch('/' + tipo + '/eliminar?id=' + id, { method: 'GET' })
            .then(response => {
                if (response.ok) {
                    mostrarMensajeExito(tipo);
                    window.location=redireccion;
                } else {
                    alert("Hubo un error al eliminar el " + tipo);
                }
            })
            .catch(error => {
                alert("Error en la red: " + error.message);
            });
    }
}

// Método que muestra el mensaje de Éxito!

function mostrarMensajeExito(tipo) {
    const mensajeExito = "El " + tipo + " ha sido eliminado con éxito.";
    const divExito = document.getElementById('mensajeExito');
    divExito.textContent = mensajeExito;
    divExito.style.display = 'block'; 
    setTimeout(() => {
        divExito.style.display = 'none';
    }, 5000);
}
