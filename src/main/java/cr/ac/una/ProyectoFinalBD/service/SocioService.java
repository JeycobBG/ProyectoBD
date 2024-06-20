/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Socio;
import cr.ac.una.ProyectoFinalBD.jpa.SocioRepository;
import cr.ac.una.ProyectoFinalBD.repositorio.ISocioRepositorio;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    
    @Autowired
    SocioRepository socioRepository;
    
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
    public Socio buscar(Integer id){
        Optional<Socio> socioOptional = socioRepository.findById(id);
        return socioOptional.get();
    }

    @Override
    public List<Socio> read(String error) {
        return socioRepo.leer(error);
    }
    
    @Override
    public List<Socio> sociosPorMasMultados(Integer top_n, String error) {
        return socioRepo.sociosPorMasMultados(top_n, error);
    }
    
}
