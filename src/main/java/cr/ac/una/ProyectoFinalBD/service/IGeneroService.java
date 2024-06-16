/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

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
    
    public String delete(Integer id_genero, String error);
}
