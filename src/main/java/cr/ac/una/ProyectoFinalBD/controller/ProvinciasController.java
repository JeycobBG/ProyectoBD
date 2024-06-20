/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Provincia;
import cr.ac.una.ProyectoFinalBD.service.ProvinciasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JEYCOB
 */
@RestController
@RequestMapping("/provincias")
public class ProvinciasController {
    
    @Autowired
    ProvinciasService provinciasService;
    
    @GetMapping("/cargar")
    public List<Provincia> cargarProvincias(){
        String error = "";
        return provinciasService.cargarProvincias(error);
    }
}
