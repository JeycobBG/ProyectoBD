/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Devolucion;
import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
import cr.ac.una.ProyectoFinalBD.service.DevolucionService;
import cr.ac.una.ProyectoFinalBD.service.PrestamoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    public String guardar(@RequestParam("fecha_devolucion_efectuada") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_devolucion_efectuada,
            @RequestParam("id_prestamo")Integer id_prestamo, Model modelo){
        
        String[] resultado = devolucionService.insertar(fecha_devolucion_efectuada, id_prestamo);
        
        if(resultado[1]!=null){
            System.out.print("Error: " + resultado[1] + "\n");
            modelo.addAttribute("mensajeAlerta", resultado[1]);
        }
        
        return "redirect:/devolucion/leer";
    }
    
    @GetMapping("/guardar")
    public String agregar(Model modelo){
        List<Prestamo> prestamos = prestamoService.leer();
        List<Prestamo> prestamosSinDevolucion = new ArrayList<>();
        
        for(Prestamo pres : prestamos){
            if(pres.getDevolucion() == null){
                prestamosSinDevolucion.add(pres);
            }
        }
             
        modelo.addAttribute("prestamos", prestamosSinDevolucion); 
        return "Devolucion/CrearDevolucion";
    }
    
    @GetMapping("/leer")
    public String leer(Model modelo){
       List<Devolucion> devoluciones = devolucionService.leer();
       
       for(Devolucion dev : devoluciones){
           System.out.print("Nueva devolucion: " + dev.getPrestamo().getSocio().getPersona().getNombre() + "\n");
       }
       
       modelo.addAttribute("devoluciones", devoluciones);
       return "Devolucion/MostrarDevolucion";
    }
    
    @PostMapping("/actualizar")
    public String actualizar(@RequestParam("id_prestamo")Integer id_prestamo,
            @RequestParam("fecha_devolucion_efectuada") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha_devolucion_efectuada){
        
        String[] resultado = devolucionService.actualizar(id_prestamo, fecha_devolucion_efectuada);
        
        System.out.println("resultado = " + resultado[0] + " advertencia? " + resultado[1]);
        return "redirect:/devolucion/leer";
    }
    
    @PostMapping("/actualizarForm")
    public String actualizar(@RequestParam("id") Integer id, Model modelo){
        Devolucion devolucion = devolucionService.buscar(id);         
        List<Prestamo> prestamos = prestamoService.leer();         
        List<Prestamo> prestamosSinDevolucion = new ArrayList<>();
        
        for(Prestamo pres : prestamos){
            if(pres.getDevolucion() == null){
                prestamosSinDevolucion.add(pres);
            }
        }
        
        modelo.addAttribute("devolucion", devolucion);        
        modelo.addAttribute("prestamos", prestamosSinDevolucion); 
        return "Devolucion/ActualizarDevolucion";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") Integer id){
        Devolucion devolucion = devolucionService.buscar(id);
        String resultado = devolucionService.eliminar(devolucion.getPrestamo().getId());
        System.out.println("resultado = " + resultado);
        return "redirect:/devolucion/leer";
    }
    
}
