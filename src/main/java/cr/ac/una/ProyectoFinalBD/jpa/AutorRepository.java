/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Autor;
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
public interface AutorRepository extends CrudRepository<Autor, Integer>{
    
    
    /*
    @nombre NVARCHAR(47),
    @primer_apellido NVARCHAR(63),
    @segundo_apellido NVARCHAR(63),
    @identificacion NVARCHAR(23),
    @codigo_postal NVARCHAR(5),
    @descripcion_direccion NVARCHAR(127),
    @id_distrito INT,
    @numero_telefono NVARCHAR(15),
    @email NVARCHAR(255),
    @bibliografia NVARCHAR(191),
    @error NVARCHAR(127) OUT
    */
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_autor](:nombre,:primer_apellido,"
                    + ":segundo_apellido,:identificacion,:codigo_postal,:descripcion_direccion,"
                    + ":id_distrito,:numero_telefono,:email,:bibliografia,:error) }",
            nativeQuery = true)
    @Transactional
    public void insertar(
            @Param("nombre")String nombre,                     @Param("primer_apellido")String primer_apellido,
            @Param("segundo_apellido")String segundo_apellido, @Param("identificacion") String identificacion,
            @Param("codigo_postal")String codigo_postal,       @Param("descripcion_direccion") String descripcion_direccion,
            @Param("id_distrito")Integer id_distrito,          @Param("numero_telefono") String numero_telefono,
            @Param("email")String email,                       @Param("bibliografia")String bibliografia,
            @Param("error")String error);
    //--------------------------------------------------------------------------
    
    /*
    @id_autor INT,
    @nombre NVARCHAR(47),
    @primer_apellido NVARCHAR(63),
    @segundo_apellido NVARCHAR(63),
    @identificacion NVARCHAR(23),
    @codigo_postal NVARCHAR(5),
    @descripcion_direccion NVARCHAR(127),
    @id_distrito INT,
    @numero_telefono NVARCHAR(15),
    @email NVARCHAR(255),
    @bibliografia NVARCHAR(191),
    @error NVARCHAR(127) OUT
    */
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_actualizar_autor](:id_autor,:nombre,:primer_apellido,"
                    + ":segundo_apellido,:identificacion,:codigo_postal,:descripcion_direccion,"
                    + ":id_distrito,:numero_telefono,:email,:bibliografia,:error) }",
            nativeQuery = true)
    @Transactional
    public void actualizar(
            @Param("id_autor")Integer id_autor,
            @Param("nombre")String nombre,                     @Param("primer_apellido")String primer_apellido,
            @Param("segundo_apellido")String segundo_apellido, @Param("identificacion") String identificacion,
            @Param("codigo_postal")String codigo_postal,       @Param("descripcion_direccion") String descripcion_direccion,
            @Param("id_distrito")Integer id_distrito,          @Param("numero_telefono") String numero_telefono,
            @Param("email")String email,                       @Param("bibliografia")String bibliografia,
            @Param("error")String error);
    //--------------------------------------------------------------------------
    
    
}
