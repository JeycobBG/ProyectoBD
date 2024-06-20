/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cr.ac.una.ProyectoFinalBD.domain.Distrito;
import cr.ac.una.ProyectoFinalBD.service.DistritosService;
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
@RequestMapping("/distritos")
public class DistritosController {
    
    @Autowired
    DistritosService distritosService;
    
    @GetMapping("/cargar")
    public String cargarProvincias() throws JsonProcessingException{
        String error = "";
        
        //List<String> provincias = new ArrayList<>();
        //provincias.add("{provincia:Heredia,{canton:Sarapiquí,{distrito:Puerto Viejo}}");
        
        ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writeValueAsString(distritosService.cargarDistritos(error));
        
        return json;
    }
}
