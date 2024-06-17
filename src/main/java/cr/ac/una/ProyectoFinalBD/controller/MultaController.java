/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Multa;
import cr.ac.una.ProyectoFinalBD.service.MultaService;
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
@RequestMapping("/multa")
public class MultaController {
    @Autowired
    MultaService multaService;
    
    @PostMapping("/guardar")
    public String guardar(@RequestParam("monto")Double monto,
            @RequestParam("dias_atraso")Integer dias_atraso,
            @RequestParam("cancelada")Boolean cancelada,
            @RequestParam("id_prestamo")Integer id_prestamo){
        
        String resultado = multaService.guardar(monto, dias_atraso, cancelada, id_prestamo);
        
        System.out.println("resultado = " + resultado);
        return "redirect:/multa/leer";
    }
    
    @GetMapping("/guardar")
    public String guardar(){
        
        return "Multa/CrearMulta";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
        
        List<Multa> multas = multaService.leer();
        
        for(Multa mul : multas){
            System.out.print("Nueva multa: " + mul.getPrestamo().getLibro().getTitulo());
        }
        
        System.out.print("\n");
        
        modelo.addAttribute("multas", multas);
        return "Multa/MostrarMulta";
    }
    
    @GetMapping("/actualizar")
    public String actualizar(){
        
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
        
        String resultado = multaService.actualizar(id_multa, monto, dias_atraso, cancelada);
        
        System.out.println("resultado = " + resultado);
        return "/";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(){
        /*
        @PathVariable("id") Integer id_multa,
        */
        Integer id_multa = 1;
        String resultado = multaService.eliminar(id_multa);
        System.out.print("resultado = " + resultado);
        
        return "/";
    }
    
    // Filtro
    @GetMapping("/filtrarPorSociosMasMultados")
    public String filtrarPorSociosMasMultados(Model modelo){
        
        String error = "";
        
        List<Multa> multas = multaService.multasPorSociosMasMultados(error);
        
        for(Multa multa: multas){
            System.out.println("editorial: " + multa.getMonto());
        }
        
        modelo.addAttribute("multas", multas);  
        return "/";
    }
}
