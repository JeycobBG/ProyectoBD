/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Genero;
import cr.ac.una.ProyectoFinalBD.repositorio.IGeneroRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class GeneroService implements IGeneroService{

    @Autowired
    IGeneroRepositorio generoRepo;
    
    @Override
    public String add(String nombre, String descripcion, String error) {
        
        return generoRepo.insertar(nombre, descripcion, error);

    }
    
    @Override
    public String update(Integer id, String nombre, String descripcion, String error) {

        return generoRepo.actualizar(id, nombre, descripcion, error);
 
    }
    
    @Override
    public String delete(Integer id, String error) {

        return generoRepo.eliminar(id, error);
 
    }

    @Override
    public List<Genero> filtrarConMasLibrosPublicados(Integer top_n, String error) {
        return generoRepo.filtrarConMasLibrosPublicados(top_n, error);
    }
}
