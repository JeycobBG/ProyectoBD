/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.DevolucionService;
import java.time.Instant;
import java.util.Date;
import javax.xml.crypto.Data;
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
    public String add(){
        
        /*
            @RequestParam("fecha_devolucion_efectuada")Data fecha_devolucion_efectuada,
            @RequestParam("id_prestamo")Integer id_prestamo,
            @RequestParam("error")String error,
            @RequestParam("advertencia_multa")String advertencia_multa
        */
        
        Date fecha_devolucion_efectuada = Date.from(Instant.now());
        Integer id_prestamo = 1;
        String error = "";
        String advertencia_multa = "";
        
        boolean resultado = devolucionService.add(fecha_devolucion_efectuada, id_prestamo, error, advertencia_multa);
        
        System.out.println("resultado = " + resultado);
        
        return "Devolucion/CrearDevolucion";
    }
}
