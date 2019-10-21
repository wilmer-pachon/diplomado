/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.DTOEstudiante;
import com.mycompany.entity.Diplomado;
import com.mycompany.entity.Estudiante;
import com.mycompany.interfaces.DiplomadoFacadeLocal;
import com.mycompany.interfaces.EstudianteFacadeLocal;
import com.mycompany.interfaces.UniversidadFacadeLocal;

import com.mycompany.utility.FotoString;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import javax.annotation.*;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.*;

/**
 *
 * @author tegui
 */
@Named
@ViewScoped
public class EstudianteC implements Serializable {

    @EJB
    private UniversidadFacadeLocal universidadFacade;
    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    @EJB
    private DiplomadoFacadeLocal diplomadoFacade;

    private UploadedFile file;
    private String nombre;
    private String edad;
    private String foto;
    DTOEstudiante dtoEstudiante = new DTOEstudiante();
    private List<Diplomado> lista;
    private List<Estudiante> listaEstudiante;
    private int diplo;

    public EstudianteC() {
        lista = new ArrayList<>();
        listaEstudiante = new ArrayList<>();
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Diplomado> getLista() {
        return lista;
    }

    public void setLista(List<Diplomado> lista) {
        this.lista = lista;
    }

    public int getDiplo() {
        return diplo;
    }

    public void setDiplo(int diplo) {
        this.diplo = diplo;
    }

    public List<Estudiante> getListaEstudiante() {
        return listaEstudiante;
    }

    public void setListaEstudiante(List<Estudiante> listaEstudiante) {
        this.listaEstudiante = listaEstudiante;
    }
    
    @PostConstruct
    public void _init() {
        lista = diplomadoFacade.findAll();
        listaEstudiante = estudianteFacade.findAll();
    }
    
    public void llenarLista() {
        lista = diplomadoFacade.findAll();
    }
    
    public void crearEstudiante() {
        try {
            if (file != null) {
                FotoString add = new FotoString();
                foto = add.copyFile(file.getFileName(), file.getInputstream());
                Diplomado dip = diplomadoFacade.find(diplo);
                Estudiante est = new Estudiante(nombre, foto, edad, dip);
                List<Estudiante> listaEst = new ArrayList<>();
                listaEst.add(est);

                estudianteFacade.create(est);

                FacesContext fCtx = FacesContext.getCurrentInstance();
                fCtx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado",
                        "Estudiante " + nombre + " agregado"));
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No hay archivos cargados.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        if (event != null) {
            file = event.getFile();
        }
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " la foto ha sido cargada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
