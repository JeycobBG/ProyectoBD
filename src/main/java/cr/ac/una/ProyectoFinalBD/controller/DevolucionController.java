/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Devolucion;
import cr.ac.una.ProyectoFinalBD.service.DevolucionService;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/devolucion")
public class DevolucionController {
    @Autowired
    DevolucionService devolucionService;
    
    @GetMapping("/guardar")
    public String guardar(){
        
        /*
            @RequestParam("fecha_devolucion_efectuada")Data fecha_devolucion_efectuada,
            @RequestParam("id_prestamo")Integer id_prestamo,
            @RequestParam("error")String error,
            @RequestParam("advertencia_multa")String advertencia_multa
        */
        
        Date fecha_devolucion_efectuada = Date.from(Instant.now());
        Integer id_prestamo = 4;
        String[] resultado = devolucionService.insertar(fecha_devolucion_efectuada, id_prestamo);
        
        System.out.println("resultado = " + resultado[0] + " advertencia? " + resultado[1]);
        
        return "/";
    }
    
    @GetMapping("/leer")
    public String leer(){
       String error = "";
       List<Devolucion> devoluciones = devolucionService.leer();
       
       for(Devolucion dev : devoluciones){
           System.out.print("Nueva devolucion: " + dev.getPrestamo().getSocio().getPersona().getNombre() + "\n");
       }
        
       return "/";
    }
    
    @GetMapping("/actualizar")
    public String actualizar(){
        
        /*
            @RequestParam("id_prestamo")Integer id_prestamo,
            @RequestParam("fecha_devolucion")Data fecha_devolucion,
            @RequestParam("error")String error
        */  
        
        Integer id_prestamo = 1;
        Date fecha_devolucion_efectuada = Date.from(Instant.now());
        String[] resultado = devolucionService.actualizar(id_prestamo, fecha_devolucion_efectuada);
        
        System.out.println("resultado = " + resultado[0] + " advertencia? " + resultado[1]);
        
        return "/";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(){
        /*
        @PathVariable("id_prestamo") Integer id_prestamo
        */
        Integer id_prestamo = 1;
        String resultado = devolucionService.eliminar(id_prestamo);
        System.out.println("resultado = " + resultado);
        
        return "/";
    }
}
