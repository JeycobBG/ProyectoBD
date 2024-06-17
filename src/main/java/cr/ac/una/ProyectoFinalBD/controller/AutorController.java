    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Autor;
import cr.ac.una.ProyectoFinalBD.service.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService autorService;
    
    @PostMapping("/guardar")
    public String add(@RequestParam("nombre")String nombre,                     @RequestParam("primer_apellido")String primer_apellido,
            @RequestParam("segundo_apellido")String segundo_apellido, @RequestParam("identificacion") String identificacion,
            @RequestParam("codigo_postal")String codigo_postal,       @RequestParam("descripcion_direccion") String descripcion_direccion,
            @RequestParam("id_distrito")Integer id_distrito,          @RequestParam("numero_telefono") String numero_telefono,
            @RequestParam("email")String email,                       @RequestParam("bibliografia")String bibliografia){   
       
        String error = "";
        String resultado = autorService.add(nombre, primer_apellido, segundo_apellido,
                identificacion, codigo_postal, descripcion_direccion, id_distrito,
                numero_telefono, email, bibliografia, error);
        
        System.out.println("resultado = " + resultado);
        return "redirect:/autor/leer";
    }
    
    @GetMapping("/guardar")
    public String guardar(){  
        
        return "Autor/CrearAutor";
    }
    
    @PostMapping("/actualizar")
    public String update(@PathVariable("id_autor") Integer id_autor,
        @RequestParam("nombre")String nombre,                     @RequestParam("primer_apellido")String primer_apellido,
            @RequestParam("segundo_apellido")String segundo_apellido, @RequestParam("identificacion") String identificacion,
            @RequestParam("codigo_postal")String codigo_postal,       @RequestParam("descripcion_direccion") String descripcion_direccion,
            @RequestParam("id_distrito")Integer id_distrito,          @RequestParam("numero_telefono") String numero_telefono,
            @RequestParam("email")String email,                       @RequestParam("bibliografia")String bibliografia){
        
        String error = "";
        
        String resultado = autorService.update(id_autor, nombre, primer_apellido, segundo_apellido,
                identificacion, codigo_postal, descripcion_direccion, id_distrito,
                numero_telefono, email, bibliografia, error);
        
        
        System.out.println("resultado = " + resultado);
        return "/";
    }
    
    @GetMapping("/actualizar")
    public String actualizar(){
        
        return "Autor/ActualizarLibro";
    }
    
    @GetMapping("/eliminar")
    public String delete(){
        /*
        @PathVariable("id_autor") Integer id_autor
        */
        Integer id_autor = 1;
        String error = "";
        
        String resultado = autorService.delete(id_autor, error);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
        
        String error = "";
        
        List<Autor> autores = autorService.leer(error);
        
        for(Autor autor: autores){
            System.out.println("autor: " + autor.getPersona().getNombre());
            
            System.out.println("\n");
        }
        
        
        
        modelo.addAttribute("autores", autores);
        return "Autor/MostrarAutor";
    }
}
