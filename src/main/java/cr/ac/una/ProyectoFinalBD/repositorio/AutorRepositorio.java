/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Autor;
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
public class AutorRepositorio implements IAutorRepositorio{
    
    
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public String insertar(String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, String bibliografia,
            String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_autor");
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("primer_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("segundo_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("identificacion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("codigo_postal", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion_direccion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_distrito", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("numero_telefono", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("bibliografia", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("nombre", nombre);
        query.setParameter("primer_apellido", primer_apellido);
        query.setParameter("segundo_apellido", segundo_apellido);
        query.setParameter("identificacion", identificacion);
        query.setParameter("codigo_postal", codigo_postal);
        query.setParameter("descripcion_direccion", descripcion_direccion);
        query.setParameter("id_distrito", id_distrito);
        query.setParameter("numero_telefono", numero_telefono);
        query.setParameter("email", email);
        query.setParameter("bibliografia", bibliografia);

        query.execute();
        return error= (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public String actualizar(Integer id_autor, String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, String bibliografia,
            String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_autor");
        query.registerStoredProcedureParameter("id_autor", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("primer_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("segundo_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("identificacion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("codigo_postal", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion_direccion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_distrito", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("numero_telefono", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("bibliografia", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_autor", id_autor);
        query.setParameter("nombre", nombre);
        query.setParameter("primer_apellido", primer_apellido);
        query.setParameter("segundo_apellido", segundo_apellido);
        query.setParameter("identificacion", identificacion);
        query.setParameter("codigo_postal", codigo_postal);
        query.setParameter("descripcion_direccion", descripcion_direccion);
        query.setParameter("id_distrito", id_distrito);
        query.setParameter("numero_telefono", numero_telefono);
        query.setParameter("email", email);
        query.setParameter("bibliografia", bibliografia);

        query.execute();
        return error= (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_autor, String error_message){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_socio");
        query.registerStoredProcedureParameter("id_autor", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error_message", String.class, ParameterMode.OUT);
        
        query.setParameter("id_socio", id_autor);
        
        query.execute();
        return error_message = (String) query.getOutputParameterValue("error_message");
    }

    @Override
    public List<Autor> leer(String error) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_leer_autor", Autor.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.execute();
        System.out.print((String) query.getOutputParameterValue("error"));

        return query.getResultList();
    }
}
