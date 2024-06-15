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
public interface IPrestamoService {
    
    public boolean add(
            Date fecha_prestamo,
            Date fecha_devolucion_prevista,                     
            Integer id_libro,
            Integer id_socio,
            String error);
    
    public boolean update(
            Integer id_prestamo,
            Date fecha_prestamo,
            Date fecha_devolucion_prevista,                     
            Integer id_libro,
            Integer id_socio,
            String error);
}
