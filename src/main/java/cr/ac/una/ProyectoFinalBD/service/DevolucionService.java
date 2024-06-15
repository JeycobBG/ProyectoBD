/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.DevolucionRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class DevolucionService implements IDevolucionService{

    @Autowired
    DevolucionRepository devolucionRepo;
    
    @Override
    public boolean add(Date fecha_devolucion_efectuada, Integer id_prestamo, String error, String advertencia_multa) {
        try {
            devolucionRepo.insertar(fecha_devolucion_efectuada, id_prestamo, error, advertencia_multa);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    @Override
    public boolean update(Integer id_prestamo,Date fecha_devolucion, String error) {
        try {
            devolucionRepo.actualizar(id_prestamo, fecha_devolucion, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
}
