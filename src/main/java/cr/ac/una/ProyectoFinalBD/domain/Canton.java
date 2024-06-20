/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.ProyectoFinalBD.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tb_canton")
public class Canton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_canton")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "canton", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Distrito> distrito;
    
    @ManyToOne()
    @JoinColumn(name = "id_provincia")
    private Provincia provincia;

    public Canton(){
        distrito = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCanton() {
        return nombre;
    }

    public void setCanton(String nombre) {
        this.nombre = nombre;
    }

    public List<Distrito> getDistrito() {
        return distrito;
    }

    public void setDistrito(List<Distrito> distrito) {
        this.distrito = distrito;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
    
}
