/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

/**
 *
 * @author tegui
 */
public class DTOEstudiante {
    
    private int id;
    private String nombre;
    private String foto;
    private String edad;

    public DTOEstudiante() {
    }

    public DTOEstudiante(int id, String nombre, String foto, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.edad = edad;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
    
}
