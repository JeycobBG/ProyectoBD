/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Editorial;
import cr.ac.una.ProyectoFinalBD.repositorio.IEditorialRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class EditorialService implements IEditorialService{

    @Autowired
    IEditorialRepositorio editorialRepo;
    
    @Override
    public String add(String nombre, Date fecha_fundacion, String codigo_postal,
            String descripcion_direccion, Integer id_distrito, String error) {
        return editorialRepo.insertar(nombre, fecha_fundacion, codigo_postal, descripcion_direccion, id_distrito, error);
    }
    
    @Override
    public String update(Integer id_editorial, String nombre, Date fecha_fundacion, String codigo_postal,
            String descripcion_direccion, Integer id_distrito, String error) {
            return editorialRepo.actualizar(id_editorial, nombre, fecha_fundacion, codigo_postal, descripcion_direccion, id_distrito, error);
    }
    
    @Override
    public String delete(Integer id_editorial, String error) {
            return editorialRepo.eliminar(id_editorial, error);
    }

    @Override
    public List<Editorial> editorialConMasLibros(Integer top_n, String error) {
        return editorialRepo.editorialConMasLibros(top_n, error);
    }
}