/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
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
public class PrestamoRepositorio implements IPrestamoRepositorio {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public String insertar(Date fecha_prestamo, Date fecha_devolucion_prevista, Integer id_libro, Integer id_socio) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_prestamo");
        query.registerStoredProcedureParameter("fecha_prestamo", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_devolucion_prevista", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_libro", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_socio", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("fecha_prestamo", fecha_prestamo);
        query.setParameter("fecha_devolucion_prevista", fecha_devolucion_prevista);
        query.setParameter("id_libro", id_libro);
        query.setParameter("id_socio", id_socio);

        query.execute();
        return (String) query.getOutputParameterValue("error");
    }

    @Transactional
    @Override
    public List<Prestamo> leer() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_leer_prestamo", Prestamo.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.execute();
        
        System.out.print((String) query.getOutputParameterValue("error"));
        return query.getResultList();
    }

    @Transactional
    @Override
    public String actualizar(Integer id_prestamo, Date fecha_prestamo, Date fecha_devolucion_prevista, Integer id_libro, Integer id_socio) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_prestamo");
        query.registerStoredProcedureParameter("id_prestamo", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_prestamo", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_devolucion_prevista", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_libro", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_socio", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_prestamo", id_prestamo);
        query.setParameter("fecha_prestamo", fecha_prestamo);
        query.setParameter("fecha_devolucion_prevista", fecha_devolucion_prevista);
        query.setParameter("id_libro", id_libro);
        query.setParameter("id_socio", id_socio);

        query.execute();
        return (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_prestamo){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_prestamo");
        query.registerStoredProcedureParameter("id_prestamo", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("id_prestamo", id_prestamo);
        
        query.execute();
        return (String) query.getOutputParameterValue("error");
    }
    
}
