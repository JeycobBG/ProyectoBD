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
public interface IDevolucionService {

    public boolean add(
            Date fecha_devolucion_efectuada,
            Integer id_prestamo,
            String error,
            String advertencia_multa);
}
