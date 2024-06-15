/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.PrestamoRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class PrestamoService implements IPrestamoService {

    @Autowired
    PrestamoRepository prestamoRepo;
    
    @Override
    public boolean add(
            Date fecha_prestamo,
            Date fecha_devolucion_prevista,
            Integer id_libro,
            Integer id_socio,
            String error) {
        
        try {
            prestamoRepo.insertar(fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    @Override
    public boolean update(
            Integer id_prestamo,
            Date fecha_prestamo,
            Date fecha_devolucion_prevista,
            Integer id_libro,
            Integer id_socio,
            String error) {
        
        try {
            prestamoRepo.actualizar(id_prestamo, fecha_prestamo,fecha_devolucion_prevista, id_libro, id_socio, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}
