/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import java.util.Date;

/**
 *
 * @author JEYCOB
 */
public interface ISocioService {
    
    public boolean add(
            String nombre,                     String primer_apellido,
            String segundo_apellido,String identificacion,
            String codigo_postal,       String descripcion_direccion,
            Integer id_distrito,          String numero_telefono,
            String email,                       Date fecha_registro,
            String error_message);
    
    public boolean update(
            Integer id,
            String nombre,                     String primer_apellido,
            String segundo_apellido,String identificacion,
            String codigo_postal,       String descripcion_direccion,
            Integer id_distrito,          String numero_telefono,
            String email,                       Date fecha_registro,
            String error_message);
}
