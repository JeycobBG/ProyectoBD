package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.domain.Genero;
import cr.ac.una.ProyectoFinalBD.service.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JEYCOB
 */
@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    GeneroService generoService;

    @PostMapping("/guardar")
    public String add(@RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion) {

        String error = "";
        String resultado = generoService.add(nombre, descripcion, error);

        System.out.println("resultado = " + resultado);
        return "redirect:/genero/leer";
    }

    @GetMapping("/guardar")
    public String agregar() {

        return "Genero/CrearGenero";
    }

    @PostMapping("/actualizar")
    public String update(@RequestParam("id")Integer id,
        @RequestParam("nombre")String nombre, 
            @RequestParam("descripcion")String descripcion) {

        String error = "";
        String resultado = generoService.update(id, nombre, descripcion, error);

        System.out.println("resultado = " + resultado);
        return "redirect:/genero/leer";
    }
    
    @PostMapping("/actualizarForm")
    public String actualizar(@RequestParam("id") Integer id, Model modelo){
        Genero genero = generoService.buscar(id);
        
        modelo.addAttribute("genero", genero);
        return "Genero/ActualizarGenero";
    }

    @GetMapping("/eliminar")
    public String delete(@RequestParam("id")Integer id) {
        String resultado = generoService.delete(id, "");
        System.out.println("resultado = " + resultado);
        return "redirect:/genero/leer";
    }

    @GetMapping("/leer")
    public String leer(Model modelo) {

        
        
        //@RequestParam("top_n")Integer top_n
        
        
        String error = "";
        
        List<Genero> generos = generoService.leer(error);
        
        for(Genero genero: generos){
            System.out.println("genero: " + genero.getNombre());
        }
        
        modelo.addAttribute("generos", generos);  
         
        return "Genero/MostrarGenero";
    }

    // Filtro

    @GetMapping("/filtrarConMasLibrosPublicados")
    public String filtrarConMasLibrosPublicados(Model modelo, @RequestParam(value = "top_n") Integer top_n) {
        List<Genero> generos = generoService.filtrarConMasLibrosPublicados(top_n, "");
        
        for (Genero genero : generos) {
            System.out.println("género con más libros publicados: " + genero.getNombre());
        }
        
        modelo.addAttribute("generos", generos);
        return "Genero/MostrarGenero";  
    }

}
