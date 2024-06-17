/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
import cr.ac.una.ProyectoFinalBD.service.PrestamoService;
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
@RequestMapping("/prestamo")
public class PrestamoController {
    @Autowired
    PrestamoService prestamoService;
    
    @PostMapping("/guardar")
    public String guardar(@RequestParam("fecha_prestamo")Date fecha_prestamo,
            @RequestParam("fecha_devolucion_prevista")Date fecha_devolucion_prevista,
            @RequestParam("id_libro")Integer id_libro,
            @RequestParam("id_socio")Integer id_socio, 
            @RequestParam("error")String error){
        
        
        String resultado = prestamoService.guardar(fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio);
       
        System.out.println("resultado = "+  resultado);
        return "redirect:/prestamo/leer";
    }
    
    @GetMapping("/guardar")
    public String agregar(){
        
        return "Prestamo/CrearPrestamo";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
        
       List<Prestamo> prestamos = prestamoService.leer();
       
       for(Prestamo prest : prestamos){
           System.out.print("Nuevo prestamo de: " + prest.getSocio().getPersona().getNombre());
           System.out.print("\n");
       }
       
       modelo.addAttribute("prestamos", prestamos);
        
       return "Prestamo/MostrarPrestamo";
        
    }
    
    @GetMapping("/actualizar")
    public String actualizar(){
        /*
            @PathVariable("id") Integer id_prestamo,
            @RequestParam("fecha_prestamo")Date fecha_prestamo,
            @RequestParam("fecha_devolucion_prevista")Date fecha_devolucion_prevista,
            @RequestParam("id_libro")Integer id_libro,
            @RequestParam("id_socio")Integer id_socio, 
            @RequestParam("error")String error);
        */
        Integer id_prestamo = 1;
        Date fecha_prestamo = Date.from(Instant.now());
        Date fecha_devolucion_prevista = Date.from(Instant.now());
        Integer id_libro = 2;
        Integer id_socio = 1;
        
        String resultado = prestamoService.actualizar(id_prestamo, fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio);
        
        System.out.println("resultado = "+  resultado);
        
        return "/";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(){
        /*
        @PathVariable("id") Integer id_prestamo
        */
        Integer id_prestamo = 1;
        String resultado = prestamoService.eliminar(id_prestamo);
        System.out.println("resultado = "+  resultado);
        
        return "/";
    }
    
}
