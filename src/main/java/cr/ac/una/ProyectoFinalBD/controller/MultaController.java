/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/multa")
public class MultaController {
    @Autowired
    MultaService multaService;
    
    @GetMapping("/guardar")
    public String add(){
        
        /*
            @RequestParam("monto")Double monto,
            @RequestParam("dias_atraso")Integer dias_atraso,
            @RequestParam("cancelada")Boolean cancelada,
            @RequestParam("id_prestamo")Integer id_prestamo, 
            @RequestParam("error")String error
        */
        
        Double monto = 0.0;
        Integer dias_atraso = 2;
        Boolean cancelada = true;
        Integer id_prestamo = 1;
        String error = "";
        
        /*boolean resultado = multaService.add(monto, dias_atraso, cancelada, id_prestamo, error);
        
        System.out.println("resultado = " + resultado);*/
        return "Multa/CrearMulta";
    }
    
    @GetMapping("/actualizar")
    public String update(){
        
        /*
        @PathVariable("id") Integer id_multa,
            @RequestParam("monto")Double monto,
            @RequestParam("dias_atraso")Integer dias_atraso,
            @RequestParam("cancelada")Boolean cancelada,
            @RequestParam("id_prestamo")Integer id_prestamo, 
            @RequestParam("error")String error
        */
        
        Integer id_multa = 1;
        Double monto = 12000.0;
        Integer dias_atraso = 2;
        Boolean cancelada = true;
        String error = "";
        
        boolean resultado = multaService.update(id_multa, monto, dias_atraso, cancelada, error);
        
        System.out.println("resultado = " + resultado);
        return "/";
    }
    
     //Esto es una prueba para ver las tablas, Atte Jamel
    @GetMapping("/mostrar")
    public String verTabla(){
        return "Multa/MostrarMulta";
    }
    
}
