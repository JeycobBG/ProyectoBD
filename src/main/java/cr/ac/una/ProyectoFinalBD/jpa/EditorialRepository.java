/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Editorial;
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
public interface EditorialRepository extends CrudRepository<Editorial, Integer> {
    
    /*
    @nombre NVARCHAR(63),
    @fecha_fundacion DATE,
    @codigo_postal NVARCHAR(5),
    @descripcion_direccion NVARCHAR(127),
    @id_distrito INT,
    @error NVARCHAR(127) OUT
    */
    
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_editorial](:nombre,:fecha_fundacion,"
                    + ":codigo_postal,:descripcion_direccion,"
                    + ":id_distrito,:error) }",
            nativeQuery = true)
    @Transactional
    public void insertar(
            @Param("nombre")String nombre,                     @Param("fecha_fundacion")Date fecha_fundacion,
            @Param("codigo_postal")String codigo_postal,       @Param("descripcion_direccion") String descripcion_direccion,
            @Param("id_distrito")Integer id_distrito,          @Param("error")String error);
}
