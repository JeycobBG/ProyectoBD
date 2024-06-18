/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Autor;
import java.util.List;


/**
 *
 * @author JEYCOB
 */
public interface IAutorService {
    
    public String add(
            String nombre,                     
            String primer_apellido,
            String segundo_apellido,
            String identificacion,
            String codigo_postal,
            String descripcion_direccion,
            Integer id_distrito,          
            String numero_telefono,
            String email,                  
            String bibliografia,
            String error);
    
    public String update(
            Integer id_autor,
            String nombre,                     
            String primer_apellido,
            String segundo_apellido,
            String identificacion,
            String codigo_postal,
            String descripcion_direccion,
            Integer id_distrito,          
            String numero_telefono,
            String email,                  
            String bibliografia,
            String error);
    
    public String delete(Integer id_autor, String error);
    
    public List<Autor> leer(String error);
    
    public Autor buscar(Integer id);
            
}