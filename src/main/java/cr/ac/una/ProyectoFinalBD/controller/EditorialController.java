/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Editorial;
import cr.ac.una.ProyectoFinalBD.service.EditorialService;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/editorial")
public class EditorialController {
    @Autowired
    EditorialService editorialService;
    
    @PostMapping("/guardar")
    public String add(@RequestParam("nombre")String nombre,                     
        @RequestParam("fecha_fundacion")Date fecha_fundacion,
        @RequestParam("codigo_postal")String codigo_postal, 
        @RequestParam("descripcion_direccion") String descripcion_direccion,
        @RequestParam("id_distrito")Integer id_distrito){
        
        String error = "";
        String resultado = editorialService.add(nombre, fecha_fundacion, codigo_postal,
                descripcion_direccion, id_distrito, error);
        
        System.out.println("resultado = " + resultado);
        return "redirect:/editorial/leer";
    }
    
    @GetMapping()
    public String agregar(){
        
        return "Editorial/CrearEditorial";
    }
    
    @GetMapping("/actualizar")
    public String update(){
        
        /*
        @PathVariable("id") Integer id,
        @RequestParam("nombre")String nombre,                     
        @RequestParam("fecha_fundacion")Date fecha_fundacion,
        @RequestParam("codigo_postal")String codigo_postal, 
        @RequestParam("descripcion_direccion") String descripcion_direccion,
        @RequestParam("id_distrito")Integer id_distrito, 
        @RequestParam("error")String error);
        */
        
        Integer id = 2;
        String nombre = "modificado";
        Date fecha_fundacion = Date.from(Instant.now());
        String codigo_postal = "modificado";
        String descripcion_direccion = "modificado";
        Integer id_distrito = 1;
        String error = "";
        
        
        String resultado = editorialService.update(id, nombre, fecha_fundacion, codigo_postal,
                descripcion_direccion, id_distrito, error);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
    @GetMapping("/eliminar")
    public String delete(){
        
        /*
        @PathVariable("id") Integer id,
        @RequestParam("error")String error);
        */
        
        Integer id_editorial = 2;
        String error = "";
        
        String resultado = editorialService.delete(id_editorial, error);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
        /*
        String error = "";
        
        List<Editorial> editoriales = editorialService.leer(error);
     
        for(int i = 0; i < editoriales.size(); i++){
            System.out.print("editorial: " + editoriales.get(i).getNombre());
        }
            
        
        modelo.addAttribute("editoriales", editoriales);  
        */
        return "Editorial/MostrarEditorial";
    }
    
    // Filtro
    @GetMapping("/filtrarConMasLibros")
    public String filtrarConMasLibros(@RequestParam(defaultValue = "5") Integer top_n, Model modelo){
     
        /*
        @RequestParam("top_n")Integer top_n
        */
        
        String error = "";
        
        List<Editorial> editoriales = editorialService.editorialConMasLibros(top_n, error);
     
        for(int i = 0; i < editoriales.size(); i++){
            System.out.print("editorial con mas libros: " + editoriales.get(i).getNombre());
        }
            
        
        modelo.addAttribute("editoriales", editoriales);  
        return "Editorial/MostrarEditorial";
    }
}
