/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Socio;
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
public interface SocioRepository extends CrudRepository<Socio, Integer>{
    
    /*
    @primer_apellido NVARCHAR(63),
    @segundo_apellido NVARCHAR(63),
    @identificacion NVARCHAR(23),
    @codigo_postal NVARCHAR(5),
    @descripcion_direccion NVARCHAR(127),
    @id_distrito INT,
    @numero_telefono NVARCHAR(15),
    @email NVARCHAR(255),
    @fecha_registro DATE,
    @error_message NVARCHAR(255) OUTPUT
    */
    
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_socio](:nombre,:primer_apellido,"
                    + ":segundo_apellido,:identificacion,:codigo_postal,:descripcion_direccion,"
                    + ":id_distrito,:numero_telefono,:email,:fecha_registro,:error_message) }",
            nativeQuery = true)
    @Transactional
    public void insertar(
            @Param("nombre")String nombre,                     @Param("primer_apellido")String primer_apellido,
            @Param("segundo_apellido")String segundo_apellido, @Param("identificacion") String identificacion,
            @Param("codigo_postal")String codigo_postal,       @Param("descripcion_direccion") String descripcion_direccion,
            @Param("id_distrito")Integer id_distrito,          @Param("numero_telefono") String numero_telefono,
            @Param("email")String email,                       @Param("fecha_registro")Date fecha_registro,
            @Param("error_message")String error_message);
    //--------------------------------------------------------------------------
    /*
    @id_socio INT,
    @nombre NVARCHAR(47),
    @primer_apellido NVARCHAR(63),
    @segundo_apellido NVARCHAR(63),
    @identificacion NVARCHAR(23),
    @codigo_postal NVARCHAR(5),
    @descripcion_direccion NVARCHAR(127),
    @id_distrito INT,
    @numero_telefono NVARCHAR(15),
    @email NVARCHAR(255),
    @fecha_registro DATE,
    @error_message NVARCHAR(255) OUTPUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_actualizar_socio](:id,:nombre,:primer_apellido,"
                    + ":segundo_apellido,:identificacion,:codigo_postal,:descripcion_direccion,"
                    + ":id_distrito,:numero_telefono,:email,:fecha_registro,:error_message) }",
            nativeQuery = true)
    @Transactional
    public void actualizar(
            @Param("id")Integer id,
            @Param("nombre")String nombre,                     @Param("primer_apellido")String primer_apellido,
            @Param("segundo_apellido")String segundo_apellido, @Param("identificacion") String identificacion,
            @Param("codigo_postal")String codigo_postal,       @Param("descripcion_direccion") String descripcion_direccion,
            @Param("id_distrito")Integer id_distrito,          @Param("numero_telefono") String numero_telefono,
            @Param("email")String email,                       @Param("fecha_registro")Date fecha_registro,
            @Param("error_message")String error_message);
    //--------------------------------------------------------------------------
    
    /*
    @id_socio INT,
    @error_message NVARCHAR(255) OUTPUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_eliminar_socio](:id_socio,:error_message) }",
            nativeQuery = true)
    @Transactional
    public void eliminar(
            @Param("id_socio")Integer id_socio,
            @Param("error_message")String error_message);
}
