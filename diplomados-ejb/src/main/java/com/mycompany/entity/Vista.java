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
@NamedQueries({
    @NamedQuery(name = "view", query = "SELECT u.nombre, u.extension, d.nombre, d.fecha_inicio, d.fecha_fin, e.nombre, e.foto FROM Universidad u JOIN u.listaDiplomados d JOIN d.listaEstudiante e")
})
public class Vista implements Serializable{
    
    @Id
    @Column
    private String nombre_universidad;
    @Column
    private String ext;
    @Column
    private String nombre_diplomado;
    @Column
    private String fecha_inicio;
    @Column
    private String fecha_fin;
    @Column
    private String nombre_estudiante;
    @Column
    private String foto;

    public Vista() {
    }

    public Vista(String nombre_universidad, String ext, String nombre_diplomado, String fecha_inicio, String fecha_fin, String nombre_estudiante, String foto) {
        this.nombre_universidad = nombre_universidad;
        this.ext = ext;
        this.nombre_diplomado = nombre_diplomado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.nombre_estudiante = nombre_estudiante;
        this.foto = foto;
    }

    public String getNombre_universidad() {
        return nombre_universidad;
    }

    public void setNombre_universidad(String nombre_universidad) {
        this.nombre_universidad = nombre_universidad;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getNombre_diplomado() {
        return nombre_diplomado;
    }

    public void setNombre_diplomado(String nombre_diplomado) {
        this.nombre_diplomado = nombre_diplomado;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    

    
}
