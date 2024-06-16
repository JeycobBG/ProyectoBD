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
public interface IEditorialService {
    
    public String add(
            String nombre,                     
            Date fecha_fundacion,
            String codigo_postal,
            String descripcion_direccion,
            Integer id_distrito,
            String error);
    
    public String update(
            Integer id_editorial,
            String nombre,                     
            Date fecha_fundacion,
            String codigo_postal,
            String descripcion_direccion,
            Integer id_distrito,
            String error);
    
    public String delete(
            Integer id_editorial,
            String error);
}
