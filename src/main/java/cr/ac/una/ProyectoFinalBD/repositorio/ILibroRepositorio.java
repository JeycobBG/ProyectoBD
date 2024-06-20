/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Libro;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jamyr
 */
public interface ILibroRepositorio {
    
    public String insertar(String ISBN, String titulo, String sinopsis, Date fecha_publicacion, Integer cantidad, Integer id_autor, Integer id_editorial, String id_generos);
    public List<Libro> leer();
    public String actualizar(Integer id_libro, String ISBN, String titulo, String sinopsis, Date fecha_publicacion, Integer cantidad, Integer id_autor, Integer id_editorial, String id_generos);
    public String eliminar(Integer id_libro);
    
    //filtros
    public List<Libro> librosPorEditorial(String editorial, String error);
    
    public List<Libro> librosPorGenero(String genero, String error);
    
    public List<Libro> librosPorISBN(String ISBN, String error);
    
    public List<Libro> librosPorMasPrestamos(Integer cantidad, String error);
    
    public List<Libro> librosPorTitulo(String titulo, String error);
    
    public List<Libro> librosPorAutor(String nombre_autor, String error);
    
    public List<Libro> librosPorAnioPublicacion(Integer anio_publicacion, String error);
}
