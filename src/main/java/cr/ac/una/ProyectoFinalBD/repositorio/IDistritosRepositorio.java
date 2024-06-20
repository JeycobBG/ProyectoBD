/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Distrito;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
public interface IDistritosRepositorio {
    
    List<Distrito> cargarDistritos(String error);
}
