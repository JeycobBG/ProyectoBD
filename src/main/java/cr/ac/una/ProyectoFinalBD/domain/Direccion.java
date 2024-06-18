/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEYCOB
 */
@Entity
@Table(name = "tb_direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private int id;
    
    private String codigoPostal;
    private String descripcion;
    
    @OneToMany(mappedBy = "direccion", fetch = FetchType.LAZY)
    private List<Persona> persona;
    
    @OneToMany(mappedBy = "direccion", fetch = FetchType.LAZY)
    private List<Editorial> editorial;
    
    @ManyToOne
    @JoinColumn(name = "id_distrito")
    private Distrito distrito;
    
    public Direccion(){
        persona = new ArrayList<>();
        editorial = new ArrayList<>();
    }

    public Direccion(int id, String codigoPostal, String descripcion, Distrito distrito) {
        this.id = id;
        this.codigoPostal = codigoPostal;
        this.descripcion = descripcion;
        this.distrito = distrito;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public List<Persona> getPersona() {
        return persona;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }

    public List<Editorial> getEditorial() {
        return editorial;
    }

    public void setEditorial(List<Editorial> editorial) {
        this.editorial = editorial;
    }
}