/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Devolucion;
import cr.ac.una.ProyectoFinalBD.repositorio.IDevolucionRepositorio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class DevolucionService implements IDevolucionService{

    @Autowired
    IDevolucionRepositorio devolucionRepo;
    
    @Override
    public String[] insertar(Date fecha_devolucion_efectuada, Integer id_prestamo) {
        return devolucionRepo.insertar(fecha_devolucion_efectuada, id_prestamo);
    }
    
    @Override
    public List<Devolucion> leer() {
        List<Devolucion> devoluciones = devolucionRepo.leer();
        return devoluciones;
    }
    
    @Override
    public String[] actualizar(Integer id_prestamo,Date fecha_devolucion_efectuada) {
        return devolucionRepo.actualizar(id_prestamo, fecha_devolucion_efectuada);
    }
    
}
