/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Multa;
import cr.ac.una.ProyectoFinalBD.jpa.MultaRepository;
import cr.ac.una.ProyectoFinalBD.repositorio.IMultaRepositorio;
import java.util.List;
import java.util.Optional;
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
    
    @Autowired
    MultaRepository multaRepository;

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
    
    @Override
    public String eliminar(Integer id_multa){
        return multaRepo.eliminar(id_multa);
    }
    
    @Override
    public Multa buscar(Integer id){
        Optional<Multa> multaOptional = multaRepository.findById(id);
        return multaOptional.get(); 
    }

    @Override
    public List<Multa> multasPorSociosMasMultados(Integer top_n, String error) {
        return multaRepo.multasPorSociosMasMultados(top_n, error);
    }

}
