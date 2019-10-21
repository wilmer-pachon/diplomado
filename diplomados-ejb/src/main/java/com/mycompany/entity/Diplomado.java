/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author tegui
 */

@Entity
@Table
public class Diplomado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column
    private String nombre;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_inicio;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_fin;
    @Column
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_universidad", nullable = false)
    private Universidad universidad;
    @OneToMany(mappedBy = "diplomado", cascade = CascadeType.ALL)
    private List<Estudiante> listaEstudiante;

    public Diplomado() {
    }

    public Diplomado(String nombre, Date fecha_inicio, Date fecha_fin, String descripcion, Universidad universidad) {
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
        this.universidad = universidad;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    public List<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }
    
    
    
}
