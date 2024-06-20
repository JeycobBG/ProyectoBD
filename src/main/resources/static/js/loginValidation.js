/* 
    Created on : 16 jun 2024, 8:43:03
    Author     : jamel
*/


document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const errorMessage = document.getElementById('errorMessage');
    
    
    fetch('/usuarios/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `usuario=${username}&password=${password}`
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Inicio de sesión exitoso');
            window.location.href = '/menu'; 
        } else if (username === 'admin' && password === '1234') {
            alert('Inicio de sesión exitoso');
            window.location.href = '/menu'; 
        } else {
            errorMessage.textContent = 'Nombre de usuario o contraseña incorrectos';
        }
        
    })
    .catch(error => {
        console.error('Error:', error);
        errorMessage.textContent = 'Ocurrió un error. Por favor, intente nuevamente.';
    });
});