/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Genero;
import cr.ac.una.ProyectoFinalBD.domain.Libro;
import cr.ac.una.ProyectoFinalBD.service.LibroService;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String guardar(){
        
        /*
        @RequestParam("ISBN") String isbn,
            @RequestParam("titulo") String titulo,
            @RequestParam("sinopsis") String sinopsis,
            @RequestParam("fecha_publicacion") Date fechaPublicacion,
            @RequestParam("cantidad") Integer cantidad,
            @RequestParam("id_autor") Integer idAutor,
            @RequestParam("id_editorial") Integer idEditorial,
            @RequestParam("id_generos") Integer idGeneros
        */
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
        
        System.out.println("resultado = " + resultado);
        return "/";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
       String error = "";
       List<Libro> libros = libroService.leer();
       
       if(error.isBlank()){
           modelo.addAttribute("libros", libros);
           
           for(Libro lib : libros){
           List<Genero> generos = lib.getGeneros();
           System.out.print("Nuevo libro> " + lib.getTitulo() + " con generos: ");
           
           for(Genero gen : generos){
               System.out.print(gen.getNombre() + ", ");
           }
           
           System.out.print("\n");
       }
       }else{
           modelo.addAttribute("error", error);
           System.out.println("error = " + error);
       }
       
       return "/";
    }
    
    @GetMapping("/actualizar")
    public String actualizar(){
        
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
    public String eliminar(){
        /*
        @PathVariable("id_libro") Integer id_libro
        */
        
        Integer id_libro = 2;
        String resultado = libroService.eliminar(id_libro);
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
}
