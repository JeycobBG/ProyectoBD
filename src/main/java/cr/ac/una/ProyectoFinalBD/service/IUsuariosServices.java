package cr.ac.una.ProyectoFinalBD.service;

/**
 *
 * @author JEYCOB
 */

public interface IUsuariosServices {
    boolean login(String nombre, String contraseña);
    String encriptar(String passwordSinEncriptar);
}
