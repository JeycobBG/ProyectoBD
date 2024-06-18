/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Autor;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
public interface IAutorRepositorio {
    
    String insertar(String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, String bibliografia,
            String error);
    
    String actualizar(Integer id_autor, String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, String bibliografia,
            String error);
    
    String eliminar(Integer id_autor, String error);
    
    public List<Autor> leer(String error);
}
