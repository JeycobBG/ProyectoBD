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
    public String add(){
        
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
            String isbn = "isbn1";
            String titulo = "titulo1";
            String sinopsis = "sinopsis1";
            Date fechaPublicacion = Date.from(Instant.now());
            Integer cantidad = 1;
            Integer idAutor = 1;
            Integer idEditorial = 1;
            String idGeneros = "1,2,3";
            String error = "";
            
        boolean resultado = libroService.add(
                isbn,
                titulo,
                sinopsis,
                fechaPublicacion,
                cantidad,
                idAutor,
                idEditorial,
                idGeneros,
                error);
        
        System.out.println("resultado = " + resultado);
        return "/";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
       String error = "";
       ArrayList<Libro> libros = libroService.leer(error);
       
       for(Libro lib : libros){
           List<Genero> generos = lib.getGeneros();
           System.out.print("Nuevo libro> " + lib.getTitulo() + " con generos: ");
           
           for(Genero gen : generos){
               System.out.print(gen.getNombre() + ", ");
           }
           
           System.out.print("\n");
       }
       
       return "/";
    }
    
}
