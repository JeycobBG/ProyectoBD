/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.SocioService;
import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/socio")
public class SocioController {
    @Autowired
    SocioService socioService;
    
    @GetMapping("/guardar")
    public String add(){
        
        /*
        @RequestParam("nombre")String nombre,                     @RequestParam("primer_apellido")String primer_apellido,
            @RequestParam("segundo_apellido")String segundo_apellido, @RequestParam("identificacion") String identificacion,
            @RequestParam("codigo_postal")String codigo_postal,       @RequestParam("descripcion_direccion") String descripcion_direccion,
            @RequestParam("id_distrito")Integer id_distrito,          @RequestParam("numero_telefono") String numero_telefono,
            @RequestParam("email")String email,                       @RequestParam("fecha_registro")Date fecha_registro
        */
        
        String nombre = "socio3";
        String primer_apellido = "apellido3";
        String segundo_apellido = "apellido3";
        String identificacion = "identificacion3";
        String codigo_postal = "codigo3";
        String descripcion_direccion = "direccion3";
        Integer id_distrito = 1;
        String numero_telefono = "33333333";
        String email = "socio3@gmail.com";
        Date fecha_registro = Date.from(Instant.now());
        String error_message = "";
        
        
        boolean resultado = socioService.add(
        nombre,
        primer_apellido,
        segundo_apellido,
        identificacion,
        codigo_postal,
        descripcion_direccion,
        id_distrito,
        numero_telefono,
        email,
        fecha_registro,
        error_message
        );
        
        System.out.println("resultado = " + resultado);
        return "/";
    }
    
    @GetMapping("/actualizar")
    public String update(){
        
        /*
        @PathVariable("id") Integer id,
        @RequestParam("nombre")String nombre,                     @RequestParam("primer_apellido")String primer_apellido,
            @RequestParam("segundo_apellido")String segundo_apellido, @RequestParam("identificacion") String identificacion,
            @RequestParam("codigo_postal")String codigo_postal,       @RequestParam("descripcion_direccion") String descripcion_direccion,
            @RequestParam("id_distrito")Integer id_distrito,          @RequestParam("numero_telefono") String numero_telefono,
            @RequestParam("email")String email,                       @RequestParam("fecha_registro")Date fecha_registro
        */
        Integer id = 1;
        String nombre = "modificado";
        String primer_apellido = "modificado";
        String segundo_apellido = "modificado";
        String identificacion = "modificado";
        String codigo_postal = "modificado";
        String descripcion_direccion = "modificado";
        Integer id_distrito = 1;
        String numero_telefono = "11111111";
        String email = "modificado@gmail.com";
        Date fecha_registro = Date.from(Instant.now());
        String error_message = "";
        
        
        boolean resultado = socioService.update(
        id,
        nombre,
        primer_apellido,
        segundo_apellido,
        identificacion,
        codigo_postal,
        descripcion_direccion,
        id_distrito,
        numero_telefono,
        email,
        fecha_registro,
        error_message
        );
        
        System.out.println("resultado = " + resultado);
        return "/";
    }
    
    @GetMapping("/eliminar")
    public String delete(){
        
        /*
        @PathVariable("id")Integer id_socio
        
        */
        
        Integer id_socio = 1;
        String error_message = "";
        
        boolean resultado = socioService.delete(id_socio, error_message);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
}
