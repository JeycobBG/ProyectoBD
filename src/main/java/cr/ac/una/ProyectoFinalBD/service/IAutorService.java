/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;


/**
 *
 * @author JEYCOB
 */
public interface IAutorService {
    
    public boolean add(
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
}
