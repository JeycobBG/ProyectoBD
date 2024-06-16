/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

/**
 *
 * @author JEYCOB
 */
public interface IGeneroRepositorio {
    
    public String insertar(
            String nombre,                     
            String descripcion,
            String error);
    
    public String actualizar(
            Integer id_genero,
            String nombre,                     
            String descripcion,
            String error);
    
    public String eliminar(Integer id_genero, String error);
}
