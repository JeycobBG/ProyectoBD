package cr.ac.una.ProyectoFinalBD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class PrincipalController {

    @GetMapping
    public String showMainMenu() {
        return "index";  
    }
}
