/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.util.Date;

/**
 *
 * @author tegui
 */
public class DTOUniversidad {
    
    private int id;
    private String nombre;
    private String escudo;
    private String extension;
    private Date fundacion;

    public DTOUniversidad() {
    }

    public DTOUniversidad(int id, String nombre, String escudo, String extension, Date fundacion) {
        this.id = id;
        this.nombre = nombre;
        this.escudo = escudo;
        this.extension = extension;
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

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }
    
    
    
}
