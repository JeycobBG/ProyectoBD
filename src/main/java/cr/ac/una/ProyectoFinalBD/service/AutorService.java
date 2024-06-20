/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Autor;
import cr.ac.una.ProyectoFinalBD.jpa.AutorRepository;
import cr.ac.una.ProyectoFinalBD.repositorio.IAutorRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class AutorService implements IAutorService{
    
    @Autowired
    IAutorRepositorio autorRepo;
    
    @Autowired
    AutorRepository autorRepository;

    @Override
    public String add(String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, String bibliografia,
            String error) {

  
        return autorRepo.insertar(nombre, primer_apellido, segundo_apellido, identificacion,
                    codigo_postal, descripcion_direccion, id_distrito, numero_telefono, email,
                    bibliografia, error);
    }
    
    @Override
    public String update(Integer id_autor, String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, String bibliografia,
            String error) {
        
        return autorRepo.actualizar(id_autor, nombre, primer_apellido, segundo_apellido, identificacion,
                    codigo_postal, descripcion_direccion, id_distrito, numero_telefono, email,
                    bibliografia, error);
    }

    @Override
    public String delete(Integer id_autor, String error) {
        return autorRepo.eliminar(id_autor, error);
    }

    @Override
    public List<Autor> leer(String error) {
        return autorRepo.leer(error);
    }
    
    @Override 
    public Autor buscar(Integer id){
        Optional<Autor> autorOptional = autorRepository.findById(id);
        return autorOptional.get(); 
    }
    
}
