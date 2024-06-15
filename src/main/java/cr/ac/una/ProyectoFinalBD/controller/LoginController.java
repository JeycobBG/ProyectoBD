package cr.ac.una.ProyectoFinalBD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/")
    public String showLoginForm(Model model) {
        return "Login/Login"; 
    }
    
    
}
