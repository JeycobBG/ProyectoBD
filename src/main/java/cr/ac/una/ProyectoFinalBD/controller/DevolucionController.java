/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Devolucion;
import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
import cr.ac.una.ProyectoFinalBD.service.DevolucionService;
import cr.ac.una.ProyectoFinalBD.service.PrestamoService;
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
@RequestMapping("/devolucion")
public class DevolucionController {
    @Autowired
    DevolucionService devolucionService;
    
    @Autowired
    PrestamoService prestamoService;
    
    @PostMapping("/guardar")
    public String guardar(@RequestParam("fecha_devolucion_efectuada")Date fecha_devolucion_efectuada,
            @RequestParam("id_prestamo")Integer id_prestamo,
            @RequestParam("error")String error,
            @RequestParam("advertencia_multa")String advertencia_multa){
        
        String[] resultado = devolucionService.insertar(fecha_devolucion_efectuada, id_prestamo);
        
        System.out.println("resultado = " + resultado[0] + " advertencia? " + resultado[1]);
        return "redirect:/devolucion/leer";
    }
    
    @GetMapping("/guardar")
    public String agregar(){
        
        return "Devolucion/CrearDevolucion";
    }
    
    @GetMapping("/leer")
    
    public String leer(Model modelo){
       
       String error = "";
       List<Devolucion> devoluciones = devolucionService.leer();
       
       for(Devolucion dev : devoluciones){
           System.out.print("Nueva devolucion: " + dev.getPrestamo().getSocio().getPersona().getNombre() + "\n");
       }
       
       modelo.addAttribute("devoluciones", devoluciones);
       
       return "Devolucion/MostrarDevolucion";
    }
    
    @PostMapping("/actualizar")
    public String actualizar(@RequestParam("id_prestamo")Integer id_prestamo,
            @RequestParam("fecha_devolucion")Date fecha_devolucion_efectuada){
        
        String[] resultado = devolucionService.actualizar(id_prestamo, fecha_devolucion_efectuada);
        
        System.out.println("resultado = " + resultado[0] + " advertencia? " + resultado[1]);
        return "redirect:/devolucion/leer";
    }
    
    @GetMapping("/actualizar")
    public String actualizar(@RequestParam("id") Integer id, Model modelo){
        Devolucion devolucion = devolucionService.buscar(id);
        List<Prestamo> prestamos = prestamoService.leer();
        
        modelo.addAttribute("devolucion", devolucion);
        modelo.addAttribute("prestamos", prestamos);
        return "Devolucion/ActualizarDevolucion";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(){
        /*
        @PathVariable("id_prestamo") Integer id_prestamo
        */
        Integer id_prestamo = 1;
        String resultado = devolucionService.eliminar(id_prestamo);
        System.out.println("resultado = " + resultado);
        
        return "Devolucion/CrearDevolucion";
    }
    
}
