/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Prestamo;
import cr.ac.una.ProyectoFinalBD.repositorio.IPrestamoRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class PrestamoService implements IPrestamoService {

    @Autowired
    IPrestamoRepositorio prestamoRepo;
    
    @Override
    public String guardar(Date fecha_prestamo, Date fecha_devolucion_prevista, Integer id_libro, Integer id_socio){
        return prestamoRepo.insertar(fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio);
    }
    
    @Override
    public List<Prestamo> leer(){
        return prestamoRepo.leer();
    }
    
    @Override
    public String actualizar(Integer id_prestamo, Date fecha_prestamo, Date fecha_devolucion_prevista, Integer id_libro, Integer id_socio) {
        return prestamoRepo.actualizar(id_prestamo, fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio);
    }
    
    @Override
    public String eliminar(Integer id_prestamo){
        return prestamoRepo.eliminar(id_prestamo);
    }
    
}
