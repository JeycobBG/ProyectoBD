/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

@Service
public class UsuariosServices implements IUsuariosServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean login(String nombre, String contrasena) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(nombre, contrasena).isPresent();
    }

    @Override
    public String encriptar(String passwordSinEncriptar) {
        return DigestUtils.md5Hex(passwordSinEncriptar);
    }
}
