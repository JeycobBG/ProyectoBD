/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Libro;
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
 *
 */
@Repository
public class LibroRepositorio implements ILibroRepositorio{
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public String insertar(String ISBN, String titulo, String sinopsis, Date fecha_publicacion, Integer cantidad, Integer id_autor, Integer id_editorial, String id_generos) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_insertar_libro");
        query.registerStoredProcedureParameter("ISBN", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("titulo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("sinopsis", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_publicacion", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("cantidad", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_autor", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_editorial", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_generos", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("ISBN", ISBN);
        query.setParameter("titulo", titulo);
        query.setParameter("sinopsis", sinopsis);
        query.setParameter("fecha_publicacion", fecha_publicacion);
        query.setParameter("cantidad", cantidad);
        query.setParameter("id_autor", id_autor);
        query.setParameter("id_editorial", id_editorial);
        query.setParameter("id_generos", id_generos);

        query.execute();
        return (String) query.getOutputParameterValue("error");
    }

    @Override
    @Transactional
    public List<Libro> leer() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_leer_libro", Libro.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.execute();
        System.out.print((String) query.getOutputParameterValue("error"));

        return query.getResultList();
    }
    
    @Override
    @Transactional
    public String actualizar(Integer id_libro, String ISBN, String titulo, String sinopsis, Date fecha_publicacion, Integer cantidad, Integer id_autor, Integer id_editorial, String id_generos) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_actualizar_libro");
        query.registerStoredProcedureParameter("id_libro", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("ISBN", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("titulo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("sinopsis", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("fecha_publicacion", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("cantidad", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_autor", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_editorial", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("id_generos", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);

        query.setParameter("id_libro", id_libro);
        query.setParameter("ISBN", ISBN);
        query.setParameter("titulo", titulo);
        query.setParameter("sinopsis", sinopsis);
        query.setParameter("fecha_publicacion", fecha_publicacion);
        query.setParameter("cantidad", cantidad);
        query.setParameter("id_autor", id_autor);
        query.setParameter("id_editorial", id_editorial);
        query.setParameter("id_generos", id_generos);

        query.execute();
        return (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public String eliminar(Integer id_libro){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_eliminar_libro");
        query.registerStoredProcedureParameter("id_libro", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("id_libro", id_libro);
        
        query.execute();
        return (String) query.getOutputParameterValue("error");
    }
    
    @Override
    @Transactional
    public List<Libro> librosPorEditorial(String editorial, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_libro_por_editorial", Libro.class);
        query.registerStoredProcedureParameter("editorial", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("editorial", editorial);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
    
    @Override
    @Transactional
    public List<Libro> librosPorGenero(String genero, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_libro_por_genero", Libro.class);
        query.registerStoredProcedureParameter("genero", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("genero", genero);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
    
    @Override
    @Transactional
    public List<Libro> librosPorISBN(String ISBN, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_libro_por_ISBN", Libro.class);
        query.registerStoredProcedureParameter("ISBN", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("ISBN", ISBN);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
    
    @Override
    @Transactional
    public List<Libro> librosPorMasPrestamos(String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_libro_por_mas_prestamos", Libro.class);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
    
    @Override
    @Transactional
    public List<Libro> librosPorTitulo(String titulo, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_libro_por_titulo", Libro.class);
        query.registerStoredProcedureParameter("titulo", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("titulo", titulo);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
    
    @Override
    @Transactional
    public List<Libro> librosPorAutor(String nombre_autor, String primer_apellido_autor, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_libro_por_autor", Libro.class);
        query.registerStoredProcedureParameter("nombre_autor", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("primer_apellido_autor", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("nombre_autor", nombre_autor);
        query.setParameter("primer_apellido_autor", primer_apellido_autor);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
    
    @Override
    @Transactional
    public List<Libro> librosPorAnioPublicacion(Integer anio_publicacion, String error){
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_filtrar_libro_por_anio_publicacion", Libro.class);
        query.registerStoredProcedureParameter("anio_publicacion", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("error", String.class, ParameterMode.OUT);
        
        query.setParameter("anio_publicacion", anio_publicacion);
        
        query.execute();
        System.out.println((String) query.getOutputParameterValue("error"));
        
        return query.getResultList();
    }
}
