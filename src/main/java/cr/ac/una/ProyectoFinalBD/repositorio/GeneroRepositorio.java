/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Genero;
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
public class GeneroRepositorio implements IGeneroRepositorio{

    @Autowired
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public String insertar(String nombre, String descripcion, String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_genero");
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("nombre", nombre);
        query.setParameter("descripcion", descripcion);

        query.execute();
        return error = (String) query.getOutputParameterValue("error");
    }

    @Override
    @Transactional
    public String actualizar(Integer id_genero, String nombre, String descripcion, String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_genero");
        query.registerStoredProcedureParameter("id_genero", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_genero", id_genero);
        query.setParameter("nombre", nombre);
        query.setParameter("descripcion", descripcion);

        query.execute();
        return error = (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public List<Genero> leer(String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_leer_genero", Genero.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.execute();
        System.out.print((String) query.getOutputParameterValue("error"));

        return query.getResultList();
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_genero, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_genero");
        query.registerStoredProcedureParameter("id_genero", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_genero", id_genero);

        query.execute();
        return error = (String) query.getOutputParameterValue("error");
    }
    
    // Filtro
    @Override
    @Transactional
    public List<Genero> filtrarConMasLibrosPublicados(Integer top_n, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_generos_mas_libros", Genero.class);
        query.registerStoredProcedureParameter("top_n", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("top_n", top_n);

        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
}
