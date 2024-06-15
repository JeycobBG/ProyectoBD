/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Genero;
import jakarta.transaction.Transactional;
import java.util.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JEYCOB
 */
public interface GeneroRepository extends CrudRepository<Genero, Integer>{
    
    
    /*
    @nombre NVARCHAR(23),
    @descripcion NVARCHAR(127),
    @error NVARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_genero](:nombre,:descripcion,:error) }",
            nativeQuery = true)
    @Transactional
    public void insertar(
            @Param("nombre")String nombre, 
            @Param("descripcion")String descripcion,
            @Param("error")String error);
    //--------------------------------------------------------------------------
    /*
    @id_genero INT,
    @nombre NVARCHAR(23),
    @descripcion NVARCHAR(127),
    @error NVARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_actualizar_genero](:id,:nombre,:descripcion,:error) }",
            nativeQuery = true)
    @Transactional
    public void actualizar(
            @Param("id")Integer id,
            @Param("nombre")String nombre, 
            @Param("descripcion")String descripcion,
            @Param("error")String error);
    //--------------------------------------------------------------------------
}
