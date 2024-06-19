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
    public String update(@RequestParam("id") Integer id_autor,
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
        return "redirect:/autor/leer";
    }
    
    @PostMapping("/actualizarForm")
    public String actualizar(@RequestParam("id") Integer id, Model modelo){
        Autor autor = autorService.buscar(id);
        
        modelo.addAttribute("autor", autor);
        return "Autor/ActualizarAutor";
    }
    
    @GetMapping("/eliminar")
    public String delete(@RequestParam("id") Integer id){
        String resultado = autorService.delete(id, "");
        System.out.println("resultado = " + resultado);
        return "redirect:/autor/leer";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
        List<Autor> autores = autorService.leer("");
        
        for(Autor autor: autores){
            System.out.println("autor: " + autor.getPersona().getNombre());
            
            System.out.println("\n");
        }
        
        modelo.addAttribute("autores", autores);
        return "Autor/MostrarAutor";
    }
}
