/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author tegui
 */

@Entity
@Table
public class Estudiante implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column
    private String nombre;
    @Column
    private String foto;
    @Column
    private String edad;
    @ManyToOne
    @JoinColumn(name = "id_diplomado", nullable = false)
    private Diplomado diplomado;

    public Estudiante() {
    }

    public Estudiante(String nombre, String foto, String edad, Diplomado diplomado) {
        this.nombre = nombre;
        this.foto = foto;
        this.edad = edad;
        this.diplomado = diplomado;
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

    public Diplomado getDiplomado() {
        return diplomado;
    }

    public void setDiplomado(Diplomado diplomado) {
        this.diplomado = diplomado;
    }
    
    
    
}
