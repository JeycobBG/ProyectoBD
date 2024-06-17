document.getElementById('tipoFiltro').addEventListener('change', function() {
    var selectedOption = this.options[this.selectedIndex].text;
    var placeholderText = 'Ingrese ' + selectedOption.toLowerCase();
    if (selectedOption === 'Más Préstamos') {
        placeholderText = 'Ingrese la cantidad de libros';
    }
    document.getElementById('filtroInput').placeholder = placeholderText;
});