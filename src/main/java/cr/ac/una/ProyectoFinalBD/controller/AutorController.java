/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorService autorService;
    
    @GetMapping("/guardar")
    public String add(){
        
        
        /*
        @RequestParam("nombre")String nombre,                     @RequestParam("primer_apellido")String primer_apellido,
            @RequestParam("segundo_apellido")String segundo_apellido, @RequestParam("identificacion") String identificacion,
            @RequestParam("codigo_postal")String codigo_postal,       @RequestParam("descripcion_direccion") String descripcion_direccion,
            @RequestParam("id_distrito")Integer id_distrito,          @RequestParam("numero_telefono") String numero_telefono,
            @RequestParam("email")String email,                       @RequestParam("bibliografia")String bibliografia
        */
        
        String nombre = "eliminar";
        String primer_apellido = "eliminar";
        String segundo_apellido = "eliminar";
        String identificacion = "eliminar";
        String codigo_postal = "eliminar";
        String descripcion_direccion = "eliminar";
        Integer id_distrito = 1;
        String numero_telefono = "44444444";
        String email = "eliminar@gmail.com";
        String bibliografia = "eliminar";
        String error = "";
        
        
        String resultado = autorService.add(nombre, primer_apellido, segundo_apellido,
                identificacion, codigo_postal, descripcion_direccion, id_distrito,
                numero_telefono, email, bibliografia, error);
        
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
    @GetMapping("/actualizar")
    public String update(){
        
        
        /*
        @PathVariable("id_autor") Integer id_autor,
        @RequestParam("nombre")String nombre,                     @RequestParam("primer_apellido")String primer_apellido,
            @RequestParam("segundo_apellido")String segundo_apellido, @RequestParam("identificacion") String identificacion,
            @RequestParam("codigo_postal")String codigo_postal,       @RequestParam("descripcion_direccion") String descripcion_direccion,
            @RequestParam("id_distrito")Integer id_distrito,          @RequestParam("numero_telefono") String numero_telefono,
            @RequestParam("email")String email,                       @RequestParam("bibliografia")String bibliografia
        */
        Integer id_autor = 1;
        String nombre = "modificado";
        String primer_apellido = "modificado";
        String segundo_apellido = "modificado";
        String identificacion = "modificado";
        String codigo_postal = "modificado";
        String descripcion_direccion = "modificado";
        Integer id_distrito = 1;
        String numero_telefono = "22222222";
        String email = "modificado@gmail.com";
        String bibliografia = "bibliografia1";
        String error = "";
        
        
        String resultado = autorService.update(id_autor, nombre, primer_apellido, segundo_apellido,
                identificacion, codigo_postal, descripcion_direccion, id_distrito,
                numero_telefono, email, bibliografia, error);
        
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
    @GetMapping("/actualizar")
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
}
