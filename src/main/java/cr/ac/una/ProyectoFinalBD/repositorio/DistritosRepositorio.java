/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Distrito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JEYCOB
 */
@Repository
public class DistritosRepositorio implements IDistritosRepositorio{
    
    @Autowired
    private EntityManager entityManager;
    
    
    @Override
    @Transactional
    public List<Distrito> cargarDistritos(String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_cargar_provincias", Distrito.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.execute();
        System.out.print((String) query.getOutputParameterValue("error"));

        return query.getResultList();
    }
}
