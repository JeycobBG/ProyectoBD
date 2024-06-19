/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Multa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jamyr
 */
@Repository
public class MultaRepositorio implements IMultaRepositorio {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public String insertar(Double monto, Integer dias_atraso, Boolean cancelada, Integer id_prestamo) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_multa");
        query.registerStoredProcedureParameter("monto", Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("dias_atraso", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("cancelada", Boolean.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_prestamo", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("monto", monto);
        query.setParameter("dias_atraso", dias_atraso);
        query.setParameter("cancelada", cancelada);
        query.setParameter("id_prestamo", id_prestamo);

        query.execute();
        return (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public List<Multa> leer() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_leer_multa", Multa.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.execute();
        System.out.print((String) query.getOutputParameterValue("error"));

        return query.getResultList();
    }

    @Transactional
    @Override
    public String actualizar(Integer id_multa, Double monto, Integer dias_atraso, Boolean cancelada) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_multa");
        query.registerStoredProcedureParameter("id_multa", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("monto", Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("dias_atraso", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("cancelada", Boolean.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_multa", id_multa);
        query.setParameter("monto", monto);
        query.setParameter("dias_atraso", dias_atraso);
        query.setParameter("cancelada", cancelada);

        query.execute();
        return (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_multa){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_multa");
        query.registerStoredProcedureParameter("id_multa", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("id_multa", id_multa);
        
        query.execute();
        return (String) query.getOutputParameterValue("error");
    }

    @Override
    @Transactional
    public List<Multa> multasPorSociosMasMultados(Integer top_n, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_multa_por_socio_mas_multados", Multa.class);
        query.registerStoredProcedureParameter("top_n", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("top_n", top_n);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
}