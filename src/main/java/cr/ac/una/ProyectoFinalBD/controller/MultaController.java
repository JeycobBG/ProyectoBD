/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Multa;
import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
import cr.ac.una.ProyectoFinalBD.service.MultaService;
import cr.ac.una.ProyectoFinalBD.service.PrestamoService;
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
    
    @Autowired
    PrestamoService prestamoService;
    
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
    public String guardar(Model modelo){
        List<Prestamo> prestamos = prestamoService.leer();
        modelo.addAttribute("prestamos", prestamos);
        
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
    
    @PostMapping("/actualizar")
    public String actualizar(@RequestParam("id") Integer id_multa,
            @RequestParam("monto")Double monto,
            @RequestParam("dias_atraso")Integer dias_atraso,
            @RequestParam("cancelada")Boolean cancelada,
            @RequestParam("id_prestamo")Integer id_prestamo){
        
        
        String resultado = multaService.actualizar(id_multa, monto, dias_atraso, cancelada);
        System.out.println("resultado = " + resultado);
        return "redirect:/multa/leer";
    }
    
    @PostMapping("/actualizarForm")
    public String actualizar(@RequestParam("id") Integer id, Model modelo){
        Multa multa = multaService.buscar(id);
        List<Prestamo> prestamos = prestamoService.leer();
        
        modelo.addAttribute("multa", multa);
        modelo.addAttribute("prestamos", prestamos);
        return "Multa/ActualizarMulta";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") Integer id){
        String resultado = multaService.eliminar(id);
        System.out.print("resultado = " + resultado);
        return "redirect:/multa/leer";
    }
    
}
