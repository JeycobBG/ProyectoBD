/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Libro;
import cr.ac.una.ProyectoFinalBD.repositorio.ILibroRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class LibroService implements ILibroService {
    
    @Autowired
    private ILibroRepositorio libroRepo;
    
    @Override
    public String insertar(String ISBN, String titulo, String sinopsis, Date fecha_publicacion, Integer cantidad, Integer id_autor, Integer id_editorial, String id_generos){
        return libroRepo.insertar(ISBN, titulo, sinopsis, fecha_publicacion, cantidad, id_autor, id_editorial, id_generos);
    }
    
    @Override
    public List<Libro> leer(){
        return libroRepo.leer();
    }
    
    @Override
    public String actualizar(Integer id_libro, String ISBN, String titulo, String sinopsis, Date fecha_publicacion, Integer cantidad, Integer id_autor, Integer id_editorial, String id_generos){
        return libroRepo.actualizar(id_libro, ISBN, titulo, sinopsis, fecha_publicacion,
                cantidad, id_autor, id_editorial, id_generos);
    }
    
    @Override
    public String eliminar(Integer id_libro){
        return libroRepo.eliminar(id_libro);
    }

    @Override
    public List<Libro> librosPorEditorial(String editorial, String error) {
        return libroRepo.librosPorEditorial(editorial, error);
    }

    @Override
    public List<Libro> librosPorGenero(String genero, String error) {
        return libroRepo.librosPorGenero(genero, error);
    }

    @Override
    public List<Libro> librosPorISBN(String ISBN, String error) {
        return libroRepo.librosPorISBN(ISBN, error);
    }

    @Override
    public List<Libro> librosPorMasPrestamos(Integer cantidad, String error) {
        return libroRepo.librosPorMasPrestamos(cantidad, error);
    }

    @Override
    public List<Libro> librosPorTitulo(String titulo, String error) {
        return libroRepo.librosPorTitulo(titulo, error);
    }

    @Override
    public List<Libro> librosPorAutor(String nombre_autor, String primer_apellido_autor, String error) {
        return libroRepo.librosPorAutor(nombre_autor, primer_apellido_autor, error);
    }

    @Override
    public List<Libro> librosPorAnioPublicacion(Integer anio_publicacion, String error) {
        return libroRepo.librosPorAnioPublicacion(anio_publicacion, error);
    }
    
    
}
