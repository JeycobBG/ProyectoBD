/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.PrestamoService;
import java.time.Instant;
import java.util.Date;
import static org.aspectj.bridge.MessageUtil.error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/prestamo")
public class PrestamoController {
    @Autowired
    PrestamoService prestamoService;
    
    @GetMapping("/guardar")
    public String add(){
        /*
            @RequestParam("fecha_prestamo")Date fecha_prestamo,
            @RequestParam("fecha_devolucion_prevista")Date fecha_devolucion_prevista,
            @RequestParam("id_libro")Integer id_libro,
            @RequestParam("id_socio")Integer id_socio, 
            @RequestParam("error")String error);
        */
        Date fecha_prestamo = Date.from(Instant.now());
        Date fecha_devolucion_prevista = Date.from(Instant.now());
        Integer id_libro = 3;
        Integer id_socio = 2;
        String error = "";
        
        boolean resultado = prestamoService.add(fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio, error);
        
        System.out.println("resultado = "+  resultado);
        
        return "/";
    }
    
    @GetMapping("/actualizar")
    public String update(){
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
        String error = "";
        
        boolean resultado = prestamoService.update(id_prestamo, fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio, error);
        
        System.out.println("resultado = "+  resultado);
        
        return "/";
    }
}
