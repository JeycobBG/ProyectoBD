/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Multa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author JEYCOB
 */
public interface MultaRepository extends JpaRepository<Multa, Integer>{
    
    /*
        @monto DECIMAL(10,2),
	@dias_atraso INT,
	@cancelada BIT,
	@id_prestamo INT,
	@error VARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_insertar_multa](:monto,:dias_atraso,:cancelada,"
                    + ":id_prestamo,:error) }",
            nativeQuery = true)
    @Transactional
    public void insertar(
            @Param("monto")Double monto,
            @Param("dias_atraso")Integer dias_atraso,
            @Param("cancelada")Boolean cancelada,
            @Param("id_prestamo")Integer id_prestamo, 
            @Param("error")String error);
    //--------------------------------------------------------------------------
    
    /*
    @id_multa INT,
    @monto DECIMAL(10,2),
    @dias_atraso INT,
    @cancelada BIT,
    @error VARCHAR(127) OUT
    */
    
    @Modifying
    @Query(
            value = "{ call [dbo].[sp_actualizar_multa](:id_multa,:monto,:dias_atraso,:cancelada,:error) }",
            nativeQuery = true)
    @Transactional
    public void actualizar(
            @Param("id_multa")Integer id_multa,
            @Param("monto")Double monto,
            @Param("dias_atraso")Integer dias_atraso,
            @Param("cancelada")Boolean cancelada,
            @Param("error")String error);
}
