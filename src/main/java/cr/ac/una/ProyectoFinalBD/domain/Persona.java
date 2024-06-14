/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.domain;

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
@Table(name = "tb_persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String identificacion;
    
    @ManyToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;
    
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Telefono> telefono;
    
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<CorreoElectronico> correoElectronico;
    
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Autor> autor;
    
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Socio> socio;
    
    public Persona(){
        telefono = new ArrayList<>();
        correoElectronico = new ArrayList<>();
        autor = new ArrayList<>();
        socio = new ArrayList<>();
    }

    public Persona(int id, String nombre, String primerApellido, String segundoApellido, String identificacion, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Telefono> getTelefono() {
        return telefono;
    }

    public void setTelefono(List<Telefono> telefono) {
        this.telefono = telefono;
    }

    public List<CorreoElectronico> getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(List<CorreoElectronico> correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public List<Socio> getSocio() {
        return socio;
    }

    public void setSocio(List<Socio> socio) {
        this.socio = socio;
    }
}