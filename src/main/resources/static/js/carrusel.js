document.addEventListener('DOMContentLoaded', function() {
    var carrusel = document.getElementById('carrusel');
    var imagenes = Array.from(carrusel.getElementsByClassName('imagen'));
    var indiceActual = 0;

    // Mostrar la primera imagen
    imagenes[indiceActual].style.display = 'block';

    // Función para mostrar la siguiente imagen
    function siguienteImagen() {
        imagenes[indiceActual].style.display = 'none';
        indiceActual = (indiceActual + 1) % imagenes.length;
        imagenes[indiceActual].style.display = 'block';
    }

    // Función para mostrar la imagen anterior
    function imagenAnterior() {
        imagenes[indiceActual].style.display = 'none';
        indiceActual = (indiceActual - 1 + imagenes.length) % imagenes.length;
        imagenes[indiceActual].style.display = 'block';
    }

    // Eventos de flechas para navegar
    var btnSiguiente = document.createElement('button');
    btnSiguiente.innerHTML = 'Siguiente';
    btnSiguiente.onclick = siguienteImagen;
    carrusel.appendChild(btnSiguiente);

    var btnAnterior = document.createElement('button');
    btnAnterior.innerHTML = 'Anterior';
    btnAnterior.onclick = imagenAnterior;
    carrusel.insertBefore(btnAnterior, btnSiguiente);
});
