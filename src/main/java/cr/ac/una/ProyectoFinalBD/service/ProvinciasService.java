/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.service;

import cr.ac.una.ProyectoFinalBD.domain.Provincia;
import cr.ac.una.ProyectoFinalBD.repositorio.ProvinciasRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEYCOB
 */
@Service
public class ProvinciasService implements IProvinciasService{

    @Autowired
    ProvinciasRepositorio provinciasRepo;
    
    @Override
    public List<Provincia> cargarProvincias(String error) {
        return provinciasRepo.cargarProvincias(error);
    }
    
}
