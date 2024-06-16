/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Multa;
import cr.ac.una.ProyectoFinalBD.repositorio.IMultaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class MultaService implements IMultaService{
    @Autowired
    IMultaRepositorio multaRepo;

    @Override
    public String guardar(Double monto, Integer dias_atraso, Boolean cancelada, Integer id_prestamo) {
        return multaRepo.insertar(monto, dias_atraso, cancelada, id_prestamo);
    }   
    
    @Override
    public List<Multa> leer() {
        return multaRepo.leer();
    }
    
    @Override
    public String actualizar (Integer id_multa, Double monto, Integer dias_atraso, Boolean cancelada) {
        return multaRepo.actualizar(id_multa, monto, dias_atraso, cancelada);
    }   

}
