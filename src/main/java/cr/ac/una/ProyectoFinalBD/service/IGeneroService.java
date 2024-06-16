/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Genero;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
public interface IGeneroService {
    
    public String add(
            String nombre,                     
            String descripcion,
            String error);
    
    public String update(
            Integer id,
            String nombre,                     
            String descripcion,
            String error);
    
    public List<Genero> leer(String error);
    
    public String delete(Integer id_genero, String error);
    
    //filtros
    public List<Genero> filtrarConMasLibrosPublicados(Integer top_n, String error);
}
