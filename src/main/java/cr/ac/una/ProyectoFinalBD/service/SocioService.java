/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Socio;
import cr.ac.una.ProyectoFinalBD.repositorio.ISocioRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class SocioService implements ISocioService{

    @Autowired
    ISocioRepositorio socioRepo;
    
    @Override
    public String add(String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, Date fecha_registro,
            String error_message) {

        return socioRepo.insertar(nombre, primer_apellido, segundo_apellido, identificacion,
                    codigo_postal, descripcion_direccion, id_distrito, numero_telefono, email,
                    fecha_registro, error_message);
    }
    
    @Override
    public String update(Integer id, String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, Date fecha_registro,
            String error_message) {
        
        return socioRepo.actualizar(id, nombre, primer_apellido, segundo_apellido, identificacion,
                    codigo_postal, descripcion_direccion, id_distrito, numero_telefono, email,
                    fecha_registro, error_message);
    }
    
    @Override
    public String delete(Integer id_socio, String error_message) {
 
        return socioRepo.eliminar(id_socio, error_message);
    }

    @Override
    public List<Socio> read() {
        return socioRepo.leer();
    }
}
