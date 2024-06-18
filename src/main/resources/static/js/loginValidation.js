/* 
    Created on : 16 jun 2024, 8:43:03
    Author     : jamel
*/

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('errorMessage');

    if (username === 'admin' && password === '1234') {
        alert('Inicio de sesión exitoso');
        window.location.href = '/menu'; // Redirige a la página del menú principal
    } else {
        errorMessage.textContent = 'Nombre de usuario o contraseña incorrectos';
    }
});



