/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.EditorialService;
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
@RequestMapping("/editorial")
public class EditorialController {
    @Autowired
    EditorialService editorialService;
    
    @GetMapping("/guardar")
    public String add(){
        
        /*
        @RequestParam("nombre")String nombre,                     
        @RequestParam("fecha_fundacion")Date fecha_fundacion,
        @RequestParam("codigo_postal")String codigo_postal, 
        @RequestParam("descripcion_direccion") String descripcion_direccion,
        @RequestParam("id_distrito")Integer id_distrito, 
        @RequestParam("error")String error);
        */
        
        String nombre = "editorial1";
        Date fecha_fundacion = Date.from(Instant.now());
        String codigo_postal = "codigo1";
        String descripcion_direccion = "descipcion1";
        Integer id_distrito = 1;
        String error = "";
        
        
        /*boolean resultado = editorialService.add(nombre, fecha_fundacion, codigo_postal,
                descripcion_direccion, id_distrito, error);
        
        System.out.println("resultado = " + resultado);*/
        
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
        
        
        boolean resultado = editorialService.update(id, nombre, fecha_fundacion, codigo_postal,
                descripcion_direccion, id_distrito, error);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
}
