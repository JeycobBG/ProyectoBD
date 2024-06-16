/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Multa;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
public interface IMultaService {

    public String guardar(
            Double monto,
            Integer dias_atraso,                     
            Boolean cancelada,
            Integer id_prestamo);
    
    public List<Multa> leer();
    
    public String actualizar(
            Integer id_multa,
            Double monto,
            Integer dias_atraso,                     
            Boolean cancelada);
    
    public String eliminar(Integer id_multa);
    
}
