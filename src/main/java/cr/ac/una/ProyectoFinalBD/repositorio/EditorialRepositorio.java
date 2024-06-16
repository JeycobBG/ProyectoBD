/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Editorial;
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
 * @author JEYCOB
 */
@Repository
public class EditorialRepositorio implements IEditorialRepositorio{
    
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public String insertar(String nombre, Date fecha_fundacion, String codigo_postal,
            String descripcion_direccion, Integer id_distrito, String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_editorial");
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_fundacion", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("codigo_postal", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion_direccion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_distrito", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("nombre", nombre);
        query.setParameter("fecha_fundacion", fecha_fundacion);
        query.setParameter("codigo_postal", codigo_postal);
        query.setParameter("descripcion_direccion", descripcion_direccion);
        query.setParameter("id_distrito", id_distrito);

        query.execute();
        return error = (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public String actualizar(Integer id_editorial, String nombre, Date fecha_fundacion, String codigo_postal,
            String descripcion_direccion, Integer id_distrito, String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_editorial");
        query.registerStoredProcedureParameter("id_editorial", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_fundacion", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("codigo_postal", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion_direccion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_distrito", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_editorial", id_editorial);
        query.setParameter("nombre", nombre);
        query.setParameter("fecha_fundacion", fecha_fundacion);
        query.setParameter("codigo_postal", codigo_postal);
        query.setParameter("descripcion_direccion", descripcion_direccion);
        query.setParameter("id_distrito", id_distrito);

        query.execute();
        return error = (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_editorial, String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_editorial");
        query.registerStoredProcedureParameter("id_editorial", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_editorial", id_editorial);

        query.execute();
        return error = (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public List<Editorial> editorialConMasLibros(Integer top_n, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_editoriales_mas_libros");
        query.registerStoredProcedureParameter("top_n", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("top_n", top_n);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
}
