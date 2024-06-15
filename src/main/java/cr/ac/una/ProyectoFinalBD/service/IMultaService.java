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
public interface IMultaService {

    public boolean add(
            Double monto,
            Integer dias_atraso,                     
            Boolean cancelada,
            Integer id_prestamo,
            String error);
    
    public boolean update(
            Integer id_multa,
            Double monto,
            Integer dias_atraso,                     
            Boolean cancelada,
            String error);
}
