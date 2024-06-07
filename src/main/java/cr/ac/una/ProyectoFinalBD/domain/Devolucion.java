/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author JEYCOB
 */
@Entity
@Table(name = "tbDevolucion")
public class Devolucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private Date fechaDevolucionEfectuada;
    
    @OneToOne
    @JoinColumn(name = "prestamo")
    private Prestamo prestamo;
    
    public Devolucion(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaDevolucionEfectuada() {
        return fechaDevolucionEfectuada;
    }

    public void setFechaDevolucionEfectuada(Date fechaDevolucionEfectuada) {
        this.fechaDevolucionEfectuada = fechaDevolucionEfectuada;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}