/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.jpa.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class MultaService implements IMultaService{
    @Autowired
    MultaRepository multaRepo;

    @Override
    public boolean add(Double monto, Integer dias_atraso, Boolean cancelada, Integer id_prestamo, String error) {
        try {
            multaRepo.insertar(monto, dias_atraso, cancelada, id_prestamo, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }   
    
    @Override
    public boolean update(Integer id_multa, Double monto, Integer dias_atraso, Boolean cancelada, String error) {
        try {
            multaRepo.actualizar(id_multa, monto, dias_atraso, cancelada, error);
            return true;
        } catch (Exception e) {
        }
        return false;
    }   
}
