/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JEYCOB
 */
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{
    
    /*
    @fecha_prestamo DATE, 
	@fecha_devolucion_prevista DATE,
	@id_libro INT,
	@id_socio INT,
	@error VARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_prestamo](:fecha_prestamo,:fecha_devolucion_prevista,:id_libro,"
                    + ":id_socio,:error) }",
            nativeQuery = true)
    @Transactional
    public void insertar(
            @Param("fecha_prestamo")Date fecha_prestamo,
            @Param("fecha_devolucion_prevista")Date fecha_devolucion_prevista,
            @Param("id_libro")Integer id_libro,
            @Param("id_socio")Integer id_socio, 
            @Param("error")String error);
    
    @Query(
            value = "{ call [dbo].[sp_leer_prestamo](:error) }",
            nativeQuery = true)
    @Transactional
    public ArrayList<Prestamo> leer(@Param("error") String error);
    
    //--------------------------------------------------------------------------
    /*
    @id_prestamo INT,
    @fecha_prestamo DATE, 
    @fecha_devolucion_prevista DATE,
    @id_libro INT,
    @id_socio INT,
    @error VARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_actualizar_prestamo](:id_prestamo,:fecha_prestamo,"
                    + ":fecha_devolucion_prevista,:id_libro,"
                    + ":id_socio,:error) }",
            nativeQuery = true)
    @Transactional
    public void actualizar(
            @Param("id_prestamo")Integer id_prestamo,
            @Param("fecha_prestamo")Date fecha_prestamo,
            @Param("fecha_devolucion_prevista")Date fecha_devolucion_prevista,
            @Param("id_libro")Integer id_libro,
            @Param("id_socio")Integer id_socio, 
            @Param("error")String error);
    //--------------------------------------------------------------------------
}
