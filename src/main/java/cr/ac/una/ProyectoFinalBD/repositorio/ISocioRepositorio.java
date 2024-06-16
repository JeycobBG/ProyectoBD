    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;
import cr.ac.una.ProyectoFinalBD.domain.Socio;
import java.util.Date;
import java.util.List;


/**
 *
 * @author JEYCOB
 */
public interface ISocioRepositorio {
    
    String insertar(String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, Date fecha_registro,
            String error_message);
    
    String actualizar(Integer id, String nombre, String primer_apellido, String segundo_apellido,
            String identificacion, String codigo_postal, String descripcion_direccion,
            Integer id_distrito, String numero_telefono, String email, Date fecha_registro,
            String error_message);
    
    List<Socio> leer(String error);
    
    String eliminar(Integer id_socio, String error_message);
}
