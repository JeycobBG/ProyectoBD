/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Genero;
import cr.ac.una.ProyectoFinalBD.domain.Libro;
import cr.ac.una.ProyectoFinalBD.service.LibroService;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/guardar")
    public String guardar() {

        /*
        @RequestParam("ISBN") String isbn,
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopsis") String sinopsis,
            @RequestParam("fecha_publicacion") Date fechaPublicacion,
            @RequestParam("cantidad") Integer cantidad,
            @RequestParam("id_autor") Integer idAutor,
            @RequestParam("id_editorial") Integer idEditorial,
            @RequestParam("id_generos") Integer idGeneros
        *//*
            String isbn = "isbn3";
            String titulo = "titulo3";
            String sinopsis = "sinopsis3";
            Date fechaPublicacion = Date.from(Instant.now());
            Integer cantidad = 3;
            Integer idAutor = 11;
            Integer idEditorial = 1;
            String idGeneros = "1,2,3,4";
            
        String resultado = libroService.insertar(
                isbn,
                titulo,
                sinopsis,
                fechaPublicacion,
                cantidad,
                idAutor,
                idEditorial,
                idGeneros);
        
        System.out.println("resultado = " + resultado);*/
        return "Libro/CrearLibro";
    }

    @GetMapping("/leer")
    public String leer(Model modelo) {
/*
        String error = "";
        List<Libro> libros = libroService.leer();

        if (error.isBlank()) {
            modelo.addAttribute("libros", libros);

            for (Libro lib : libros) {
                List<Genero> generos = lib.getGeneros();
                System.out.print("Nuevo libro> " + lib.getTitulo() + " con generos: ");

                for (Genero gen : generos) {
                    System.out.print(gen.getNombre() + ", ");
                }

                System.out.print("\n");
            }
        } else {
            modelo.addAttribute("error", error);
            System.out.println("error = " + error);
        }

        modelo.addAttribute("libros", libros);
*/
        return "Libro/MostrarLibro";
    }

    @GetMapping("/actualizar")
    public String actualizar() {

        /*
        @PathVariable("id_libro") Integer id_libro,
        @RequestParam("ISBN") String isbn,
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopsis") String sinopsis,
            @RequestParam("fecha_publicacion") Date fechaPublicacion,
            @RequestParam("cantidad") Integer cantidad,
            @RequestParam("id_autor") Integer idAutor,
            @RequestParam("id_editorial") Integer idEditorial,
            @RequestParam("id_generos") Integer idGeneros
         */
        Integer id_libro = 1;
        String isbn = "Modificado";
        String titulo = "Modificado";
        String sinopsis = "Modificado";
        Date fechaPublicacion = Date.from(Instant.now());
        Integer cantidad = 1;
        Integer idAutor = 1;
        Integer idEditorial = 1;
        String idGeneros = "1,2,3,4";

        String resultado = libroService.actualizar(
                id_libro,
                isbn,
                titulo,
                sinopsis,
                fechaPublicacion,
                cantidad,
                idAutor,
                idEditorial,
                idGeneros);

        System.out.println("resultado = " + resultado);
        return "/";
    }

    @GetMapping("/eliminar")
    public String eliminar() {
        /*
        @PathVariable("id_libro") Integer id_libro
         */

        Integer id_libro = 2;
        String resultado = libroService.eliminar(id_libro);
        System.out.println("resultado = " + resultado);

        return "/";
    }

    // filtros -----------------------------------------------------------------
    @GetMapping("/filtrarPorEditorial")
    public String filtrarPorEditorial(Model modelo) {

        /*
        @RequestParam("editorial")String editorial
         */
        String editorial = "editorial2";
        String error = "";

        List<Libro> libros = libroService.librosPorEditorial(editorial, error);

        for (Libro libro : libros) {
            System.out.println("libro por editorial: " + libro.getEditorial().getNombre());
        }

        modelo.addAttribute("libros", libros);
        return "/";
    }

    @GetMapping("/filtrarPorGenero")
    public String filtrarPorGenero(Model modelo) {

        /*
        @RequestParam("genero")String genero
         */
        String genero = "No Ficción";
        String error = "";

        List<Libro> libros = libroService.librosPorGenero(genero, error);

        for (Libro libro : libros) {
            System.out.println("libro por genero: " + libro.getTitulo());
        }

        modelo.addAttribute("libros", libros);
        return "/";
    }

    @GetMapping("/filtrarPorISBN")
    public String filtrarPorISBN(Model modelo) {

        /*
        @RequestParam("ISBN")String ISBN
         */
        String ISBN = "isbn2";
        String error = "";

        List<Libro> libros = libroService.librosPorISBN(ISBN, error);

        for (Libro libro : libros) {
            System.out.println("libro por ISBN: " + libro.getIsbn());
        }
        modelo.addAttribute("libros", libros);
        return "/";
    }

    @GetMapping("/filtrarPorMasPrestamos")
    public String filtrarPorMasPrestamos(Model modelo) {

        String error = "";

        List<Libro> libros = libroService.librosPorMasPrestamos(error);

        for (Libro libro : libros) {
            System.out.println("libro por más prestamos: " + libro.getTitulo());
        }

        modelo.addAttribute("libros", libros);
        return "/";
    }

    @GetMapping("/filtrarPorTitulo")
    public String filtrarPorTitulo(Model modelo) {

        /*
        @RequestParam("titulo")String titulo
         */
        String titulo = "titulo2";
        String error = "";

        List<Libro> libros = libroService.librosPorTitulo(titulo, error);

        for (Libro libro : libros) {
            System.out.println("libro por titulo: " + libro.getTitulo());
        }

        modelo.addAttribute("libros", libros);
        return "/";
    }

    @GetMapping("/filtrarPorAutor")
    public String filtrarPorAutor(Model modelo) {

        /*
        @RequestParam("nombre_autor")String nombre_autor,
        @RequestParam("primer_apellido_autor")String primer_apellido_autor
         */
        String nombre_autor = "autor2";
        String primer_apellido_autor = "apellido2";
        String error = "";

        List<Libro> libros = libroService.librosPorAutor(nombre_autor, primer_apellido_autor, error);

        for (Libro libro : libros) {
            System.out.println("libro por autor: " + libro.getTitulo());
        }

        modelo.addAttribute("libros", libros);
        return "/";
    }

    @GetMapping("/filtrarPorAnioPublicacion")
    public String filtrarPorAnioPublicacion(Model modelo) {

        /*
        @RequestParam("anio_publicacion")String anio_publicacion
         */
        Integer anio_publicacion = 2024;
        String error = "";

        List<Libro> libros = libroService.librosPorAnioPublicacion(anio_publicacion, error);

        for (Libro lib : libros) {
            System.out.println("libro por año: " + lib.getTitulo());
        }

        modelo.addAttribute("libros", libros);
        return "/";
    }
    
    
    // Método de prueba de filtrados
    
    @GetMapping("/filtrar")
    public String filtrarLibros(@RequestParam("tipoFiltro") String tipoFiltro, @RequestParam("valorFiltro") String valorFiltro, Model modelo) {
        List<Libro> libros = new ArrayList<>();
        String error = "";
        try {
            switch (tipoFiltro) {
                case "editorial":
                    libros = libroService.librosPorEditorial(valorFiltro, error);
                    break;
                case "genero":
                    libros = libroService.librosPorGenero(valorFiltro, error);
                    break;
                case "ISBN":
                    libros = libroService.librosPorISBN(valorFiltro, error);
                    break;
                case "masPrestamos":
                    libros = libroService.librosPorMasPrestamos(error);
                    break;
                case "titulo":
                    libros = libroService.librosPorTitulo(valorFiltro, error);
                    break;
                case "autor":
                    libros = libroService.librosPorAutor(valorFiltro, valorFiltro, error);
                    break;
                case "anioPublicacion":
                    libros = libroService.librosPorAnioPublicacion(Integer.parseInt(valorFiltro), error);
                    break;
            }
        } catch (Exception e) {
            error = "Error al filtrar: " + e.getMessage();
        }

        modelo.addAttribute("libros", libros);
        modelo.addAttribute("error", error);
        return "Libro/MostrarLibro";  
    }

}
