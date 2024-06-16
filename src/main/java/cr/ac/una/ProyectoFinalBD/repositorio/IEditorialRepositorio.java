/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Editorial;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
public interface IEditorialRepositorio {
    
        public String insertar(
            String nombre,                     
            Date fecha_fundacion,
            String codigo_postal,
            String descripcion_direccion,
            Integer id_distrito,
            String error);
    
    public String actualizar(
            Integer id,
            String nombre,                     
            Date fecha_fundacion,
            String codigo_postal,
            String descripcion_direccion,
            Integer id_distrito,
            String error);
    
    public String eliminar(Integer id_editorial, String error);
    
    public List<Editorial> editorialConMasLibros(Integer top_n, String error);
    
    public List<Editorial> leer(String error);
}
