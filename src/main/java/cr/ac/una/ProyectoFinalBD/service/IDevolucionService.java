/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Devolucion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
public interface IDevolucionService {

    public String[] insertar(Date fecha_devolucion_efectuada, Integer id_prestamo);
    public List<Devolucion> leer();
    public String[] actualizar(Integer id_prestamo, Date fecha_devolucion_efectuada);
    
}
