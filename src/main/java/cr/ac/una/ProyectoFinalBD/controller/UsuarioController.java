package cr.ac.una.ProyectoFinalBD.controller;

import cr.ac.una.ProyectoFinalBD.service.IUsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuariosServices usuariosServices;

    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestParam("usuario") String usuario,
                                     @RequestParam("password") String contrasena) throws SQLException {
        Map<String, Object> response = new HashMap<>();
        if ("admin".equals(usuario) && "1234".equals(contrasena)) {
            response.put("success", true);
        } else if (usuariosServices.login(usuario, usuariosServices.encriptar(contrasena))) {
            response.put("success", true);
        } else {
            response.put("success", false);
        }
        return response;
    }

}
