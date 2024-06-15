/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.EditorialRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class EditorialService implements IEditorialService{

    @Autowired
    EditorialRepository editorialRepo;
    
    @Override
    public boolean add(String nombre, Date fecha_fundacion, String codigo_postal,
            String descripcion_direccion, Integer id_distrito, String error) {
        
        try {
            editorialRepo.insertar(nombre, fecha_fundacion, codigo_postal, descripcion_direccion, id_distrito, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    @Override
    public boolean update(Integer id, String nombre, Date fecha_fundacion, String codigo_postal,
            String descripcion_direccion, Integer id_distrito, String error) {
        
        try {
            editorialRepo.update(id, nombre, fecha_fundacion, codigo_postal, descripcion_direccion, id_distrito, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
}
