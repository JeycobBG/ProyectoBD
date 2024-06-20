/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Autor;
import cr.ac.una.ProyectoFinalBD.domain.Editorial;
import cr.ac.una.ProyectoFinalBD.domain.Genero;
import cr.ac.una.ProyectoFinalBD.domain.Libro;
import cr.ac.una.ProyectoFinalBD.service.AutorService;
import cr.ac.una.ProyectoFinalBD.service.EditorialService;
import cr.ac.una.ProyectoFinalBD.service.GeneroService;
import cr.ac.una.ProyectoFinalBD.service.LibroService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @Autowired
    AutorService autorService;
    
    @Autowired
    EditorialService editorialService;
    
    @Autowired
    GeneroService generoService;

    @PostMapping("/guardar")
    public String guardar(@RequestParam("ISBN") String isbn,
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopsis") String sinopsis,
            @RequestParam("fecha_publicacion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaPublicacion,
            @RequestParam("cantidad") Integer cantidad,
            @RequestParam("id_autor") Integer idAutor,
            @RequestParam("id_editorial") Integer idEditorial,
            @RequestParam("id_generos") String idGeneros) {

            
        String resultado = libroService.insertar(
                isbn,
                titulo,
                sinopsis,
                fechaPublicacion,
                cantidad,
                idAutor,
                idEditorial,
                idGeneros);
        
        System.out.println("resultado = " + resultado);
        return "redirect:/libro/leer";
    }
    
    @GetMapping("/guardar")
    public String agregar(Model modelo) {
        List<Autor> autores = autorService.leer("");
        List<Editorial> editoriales = editorialService.leer("");
        List<Genero> generos = generoService.leer("");
                
        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);
        modelo.addAttribute("generos", generos);
        
        return "Libro/CrearLibro";
    }

    @GetMapping("/leer")
    public String leer(Model modelo) {
        List<Libro> libros = libroService.leer();
        modelo.addAttribute("libros", libros);
        return "Libro/MostrarLibro";
    }

    @PostMapping("/actualizarForm")
    public String actualizar(@RequestParam("id") Integer id, Model modelo) {
        Libro libro = libroService.buscar(id);
        List<Autor> autores = autorService.leer("");
        List<Editorial> editoriales = editorialService.leer("");
        List<Genero> generos = generoService.leer("");
                
        modelo.addAttribute("libro", libro);
        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);
        modelo.addAttribute("generos", generos);
        
        return "Libro/ActualizarLibro";
    }
    
    @PostMapping("/actualizar")
    public String actualizar (@RequestParam("id") Integer id_libro,
        @RequestParam("ISBN") String isbn,
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopsis") String sinopsis,
            @RequestParam("fecha_publicacion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaPublicacion,
            @RequestParam("cantidad") Integer cantidad,
            @RequestParam("id_autor") Integer idAutor,
            @RequestParam("id_editorial") Integer idEditorial,
            @RequestParam("id_generos") String idGeneros){
        
        
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
        return "redirect:/libro/leer";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") Integer id) {
        String resultado = libroService.eliminar(id);
        System.out.println("resultado = " + resultado);
        return "redirect:/libro/leer";
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
    public String filtrarPorMasPrestamos(@RequestParam("valorFiltro") String valorFiltro, Model modelo) {

        String error = "";

        List<Libro> libros = libroService.librosPorMasPrestamos(Integer.parseInt(valorFiltro), error);

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
                    libros = libroService.librosPorMasPrestamos(Integer.parseInt(valorFiltro), error);
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
