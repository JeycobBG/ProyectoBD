
function confirmarEliminacion(tipo, id) {
    let mensaje = "¿Está seguro de que desea eliminar este " + tipo + "?";
    if (confirm(mensaje)) {
        window.location.href = '/' + tipo + '/eliminar?id=' + id;
    }
}
