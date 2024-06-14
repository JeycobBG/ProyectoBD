/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class AutorService implements IAutorService{
    
    @Autowired
     AutorRepository autorRepo;

    @Override
    public boolean add(String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, String bibliografia,
            String error) {

        try {
            autorRepo.insertar(nombre, primer_apellido, segundo_apellido, identificacion,
                    codigo_postal, descripcion_direccion, id_distrito, numero_telefono, email,
                    bibliografia, error);
            return true;
        } catch (Exception e) {
        }
        
        return false;
    }
    
    
}
