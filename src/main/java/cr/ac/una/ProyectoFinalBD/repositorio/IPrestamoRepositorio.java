/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.repositorio;

import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jamyr
 */
public interface IPrestamoRepositorio {
    
    public String insertar(Date fecha_prestamo, Date fecha_devolucion_prevista, Integer id_libro, Integer id_socio);
    public List<Prestamo> leer();
    public String actualizar(Integer id_prestamo, Date fecha_prestamo, Date fecha_devolucion_prevista, Integer id_libro, Integer id_socio);
    public String eliminar(Integer id_prestamo);
            
}
