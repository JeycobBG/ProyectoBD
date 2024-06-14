/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class GeneroService implements IGeneroService{

    @Autowired
    GeneroRepository generoRepo;
    @Override
    public boolean add(String nombre, String descripcion, String error) {
        
        try {
            generoRepo.insertar(nombre, descripcion, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
