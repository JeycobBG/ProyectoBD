/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Socio;
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
public class SocioRepositorio implements ISocioRepositorio{

    @Autowired
    private EntityManager entityManager;
    
    /*
    
    @Param("nombre")String nombre,                     @Param("primer_apellido")String primer_apellido,
            @Param("segundo_apellido")String segundo_apellido, @Param("identificacion") String identificacion,
            @Param("codigo_postal")String codigo_postal,       @Param("descripcion_direccion") String descripcion_direccion,
            @Param("id_distrito")Integer id_distrito,          @Param("numero_telefono") String numero_telefono,
            @Param("email")String email,                       @Param("fecha_registro")Date fecha_registro,
            @Param("error_message")String error_message
    */
    @Override
    @Transactional
    public String insertar(String nombre, String primer_apellido, String segundo_apellido, String identificacion, String codigo_postal, String descripcion_direccion, Integer id_distrito, String numero_telefono, String email, Date fecha_registro, String error_message) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_socio");
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("primer_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("segundo_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("identificacion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("codigo_postal", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion_direccion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_distrito", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("numero_telefono", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_registro", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error_message", String.class, ParameterMode.OUT);

        query.setParameter("nombre", nombre);
        query.setParameter("primer_apellido", primer_apellido);
        query.setParameter("segundo_apellido", segundo_apellido);
        query.setParameter("identificacion", identificacion);
        query.setParameter("codigo_postal", codigo_postal);
        query.setParameter("descripcion_direccion", descripcion_direccion);
        query.setParameter("id_distrito", id_distrito);
        query.setParameter("numero_telefono", numero_telefono);
        query.setParameter("email", email);
        query.setParameter("fecha_registro", fecha_registro);

        query.execute();
        return error_message = (String) query.getOutputParameterValue("error_message");
    }

    @Override
    @Transactional
    public String actualizar(Integer id_socio, String nombre, String primer_apellido, String segundo_apellido, String identificacion, String codigo_postal, String descripcion_direccion, Integer id_distrito, String numero_telefono, String email, Date fecha_registro, String error_message) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_socio");
        query.registerStoredProcedureParameter("id_socio", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("primer_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("segundo_apellido", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("identificacion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("codigo_postal", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("descripcion_direccion", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_distrito", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("numero_telefono", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_registro", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error_message", String.class, ParameterMode.OUT);

        query.setParameter("id_socio", id_socio);
        query.setParameter("nombre", nombre);
        query.setParameter("primer_apellido", primer_apellido);
        query.setParameter("segundo_apellido", segundo_apellido);
        query.setParameter("identificacion", identificacion);
        query.setParameter("codigo_postal", codigo_postal);
        query.setParameter("descripcion_direccion", descripcion_direccion);
        query.setParameter("id_distrito", id_distrito);
        query.setParameter("numero_telefono", numero_telefono);
        query.setParameter("email", email);
        query.setParameter("fecha_registro", fecha_registro);

        query.execute();
        return error_message = (String) query.getOutputParameterValue("error_message");
    }
    
    @Override
    @Transactional
    public List<Socio> leer(){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_leer_socio", Socio.class);
        query.execute();
        return query.getResultList();
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_socio, String error_message){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_socio");
        query.registerStoredProcedureParameter("id_socio", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error_message", String.class, ParameterMode.OUT);
        
        query.setParameter("id_socio", id_socio);
        
        query.execute();
        return error_message = (String) query.getOutputParameterValue("error_message");
    }
    
}
