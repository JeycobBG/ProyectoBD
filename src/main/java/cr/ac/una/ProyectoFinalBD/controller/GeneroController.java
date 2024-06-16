/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/genero")
public class GeneroController {
    @Autowired
    GeneroService generoService;
    
    @GetMapping("/guardar")
    public String add(){
        
        /*
        @RequestParam("nombre")String nombre, 
            @RequestParam("descripcion")String descripcion
        */
        
        String nombre = "eliminar";
        String descripcion = "eliminar";
        String error = "";

        String resultado = generoService.add(nombre, descripcion, error);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
    @GetMapping("/actualizar")
    public String update(){
        
        /*
        @PathVariable("id")Integer id,
        @RequestParam("nombre")String nombre, 
            @RequestParam("descripcion")String descripcion
        */
        Integer id = 1;
        String nombre = "modificado";
        String descripcion = "modificado";
        String error = "";

        String resultado = generoService.update(id, nombre, descripcion, error);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
    
    @GetMapping("/eliminar")
    public String delete(){
        
        /*
        @PathVariable("id")Integer id,
            @RequestParam("descripcion")String descripcion
        */
        Integer id = 1;
        String error = "";

        String resultado = generoService.delete(id, error);
        
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
}
