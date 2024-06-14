/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.LibroRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class LibroService implements ILibroService {
    @Autowired
    private LibroRepository libroRepo;
    
    @Override
    public boolean add(String ISBN,String titulo, String sinopsis,
            Date fechaPublicacion, Integer cantidad, Integer idAutor,
            Integer idEditorial, String idGeneros, String error){
        try {
            libroRepo.insertarLibro(ISBN, titulo, sinopsis, fechaPublicacion,
                cantidad, idAutor, idEditorial, idGeneros, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
