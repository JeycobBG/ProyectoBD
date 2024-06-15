/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.SocioRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class SocioService implements ISocioService{

    @Autowired
    SocioRepository socioRepo;
    
    @Override
    public boolean add(String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, Date fecha_registro,
            String error_message) {
        try {
            socioRepo.insertar(nombre, primer_apellido, segundo_apellido, identificacion,
                    codigo_postal, descripcion_direccion, id_distrito, numero_telefono, email,
                    fecha_registro, error_message);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    @Override
    public boolean update(Integer id, String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, Date fecha_registro,
            String error_message) {
        try {
            socioRepo.actualizar(id, nombre, primer_apellido, segundo_apellido, identificacion,
                    codigo_postal, descripcion_direccion, id_distrito, numero_telefono, email,
                    fecha_registro, error_message);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    @Override
    public boolean delete(Integer id_socio, String error_message) {
        try {
            socioRepo.eliminar(id_socio, error_message);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
