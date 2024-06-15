/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Libro;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JEYCOB
 */
public interface ILibroService {
    
    public boolean add(String ISBN,String titulo, String sinopsis,
            Date fechaPublicacion, Integer cantidad, Integer idAutor,
            Integer idEditorial, String idGeneros, String error);
    
    public ArrayList<Libro> leer(String error);
}
