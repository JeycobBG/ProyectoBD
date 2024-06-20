/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Socio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
public interface ISocioService {
    
    public String add(
            String nombre,                     String primer_apellido,
            String segundo_apellido,String identificacion,
            String codigo_postal,       String descripcion_direccion,
            Integer id_distrito,          String numero_telefono,
            String email,                       Date fecha_registro,
            String error_message);
    
    public String update(
            Integer id,
            String nombre,                     String primer_apellido,
            String segundo_apellido,String identificacion,
            String codigo_postal,       String descripcion_direccion,
            Integer id_distrito,          String numero_telefono,
            String email,                       Date fecha_registro,
            String error_message);
    
    public List<Socio> read(String error);
    
    public String delete(
            Integer id_socio,
            String error_message);
    
    public Socio buscar(Integer id);
    public List<Socio> sociosPorMasMultados(Integer top_n, String error);
    
}
