/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Devolucion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jamyr
 */
@Repository
public class DevolucionRepositorio implements IDevolucionRepositorio{

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public String[] insertar(Date fecha_devolucion_efectuada, Integer id_prestamo) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_devolucion");
        query.registerStoredProcedureParameter("fecha_devolucion_efectuada", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_prestamo", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("advertencia_multa", String.class, ParameterMode.OUT);

        query.setParameter("fecha_devolucion_efectuada", fecha_devolucion_efectuada);
        query.setParameter("id_prestamo", id_prestamo);

        query.execute();
        String error = (String) query.getOutputParameterValue("error");
        String advertencia_multa = (String) query.getOutputParameterValue("advertencia_multa");
        String[] resultado = {error, advertencia_multa};
        return resultado;
    }
    
    @Transactional
    @Override
    public List<Devolucion> leer() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_leer_devolucion", Devolucion.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.execute();
        System.out.print((String) query.getOutputParameterValue("error"));

        return query.getResultList();
    }

    @Transactional
    @Override
    public String[] actualizar(Integer id_prestamo, Date fecha_devolucion_efectuada){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_devolucion");
        query.registerStoredProcedureParameter("id_prestamo", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_devolucion_efectuada", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("advertencia_multa", String.class, ParameterMode.OUT);

        query.setParameter("id_prestamo", id_prestamo);
        query.setParameter("fecha_devolucion_efectuada", fecha_devolucion_efectuada);

        query.execute();
        String error = (String) query.getOutputParameterValue("error");
        String advertencia_multa = (String) query.getOutputParameterValue("advertencia_multa");
        String[] resultado = {error, advertencia_multa};
        return resultado;
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_prestamo){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_devolucion");
        query.registerStoredProcedureParameter("id_prestamo", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("id_prestamo", id_prestamo);
        
        query.execute();
        return (String) query.getOutputParameterValue("error");
    }

}
