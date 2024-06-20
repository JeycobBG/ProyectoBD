/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Devolucion;
import jakarta.transaction.Transactional;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JEYCOB
 */
public interface DevolucionRepository extends JpaRepository<Devolucion, Integer>{
    
    /*
    @fecha_devolucion_efectuada DATE,
    @id_prestamo INT,
    @error VARCHAR(127) OUT,
    @advertencia_multa VARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_devolucion](:fecha_devolucion_efectuada,:id_prestamo,:error,"
                    + ":advertencia_multa) }",
            nativeQuery = true)
    @Transactional
    public void insertar(
            @Param("fecha_devolucion_efectuada")Date fecha_devolucion_efectuada,
            @Param("id_prestamo")Integer id_prestamo,
            @Param("error")String error,
            @Param("advertencia_multa")String advertencia_multa);
    
    //--------------------------------------------------------------------------
    /*
    @id_prestamo INT,
    @fecha_devolucion_efectuada DATE,
    @error VARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_actualizar_devolucion](:id_prestamo,:fecha_devolucion,:error) }",
            nativeQuery = true)
    @Transactional
    public void actualizar(
            @Param("id_prestamo")Integer id_prestamo,
            @Param("fecha_devolucion")Date fecha_devolucion,
            @Param("error")String error);
}
