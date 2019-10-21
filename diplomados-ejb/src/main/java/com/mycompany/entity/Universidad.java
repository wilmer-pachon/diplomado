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
public class Universidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column
    private String nombre;
    @Column
    private String extension;
    @Column
    private String escudo;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fundacion;
    @OneToMany(mappedBy = "universidad", cascade = CascadeType.ALL)
    private List<Diplomado> listaDiplomados;

    public Universidad() {
    }

    public Universidad(String nombre, String extension, String escudo, Date fundacion) {
        this.nombre = nombre;
        this.extension = extension;
        this.escudo = escudo;
        this.fundacion = fundacion;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public List<Diplomado> getListaDiplomados() {
        return listaDiplomados;
    }

    public void setListaDiplomados(List<Diplomado> listaDiplomados) {
        this.listaDiplomados = listaDiplomados;
    }

}
