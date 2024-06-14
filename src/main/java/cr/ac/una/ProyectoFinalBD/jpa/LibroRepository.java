/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Libro;
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
public interface LibroRepository extends CrudRepository<Libro, Integer>{
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_libro](:ISBN,:titulo,:sinopsis,:fecha_publicacion,:cantidad,:id_autor,:id_editorial,:id_generos,:error) }",
            nativeQuery = true)
    @Transactional
    public void insertarLibro(
            @Param("ISBN")String ISBN,               @Param("titulo")String titulo,
            @Param("sinopsis")String sinopsis,       @Param("fecha_publicacion") Date fechaPublicacion,
            @Param("cantidad")Integer cantidad,      @Param("id_autor") Integer idAutor,
            @Param("id_editorial")Integer idEditorial,@Param("id_generos") String idGeneros,
            @Param("error")String error);
}
