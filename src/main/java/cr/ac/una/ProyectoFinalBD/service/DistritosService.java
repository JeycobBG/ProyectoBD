/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Distrito;
import cr.ac.una.ProyectoFinalBD.repositorio.DistritosRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class DistritosService implements IDistritosService{

    @Autowired
    DistritosRepositorio provinciasRepo;
    
    @Override
    public List<Distrito> cargarDistritos(String error) {
        return provinciasRepo.cargarDistritos(error);
    }
    
}
