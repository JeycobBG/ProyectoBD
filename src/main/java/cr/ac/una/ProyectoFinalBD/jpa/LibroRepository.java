/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.jpa;

import cr.ac.una.ProyectoFinalBD.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jamyr
 */
public interface LibroRepository extends JpaRepository<Libro, Integer>{
    
   
}
