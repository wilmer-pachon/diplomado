/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.DTOUniversidad;
import com.mycompany.entity.Universidad;
import com.mycompany.interfaces.UniversidadFacadeLocal;

import com.mycompany.utility.FotoString;
import java.io.*;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.*;
import org.modelmapper.ModelMapper;
import org.primefaces.event.*;
import org.primefaces.model.*;

/**
 *
 * @author tegui
 */
@Named
@ViewScoped
public class UniversidadC implements Serializable {

    @EJB
    private UniversidadFacadeLocal universidadFacade;
    
    private List<Universidad> lista;
    private UploadedFile file;//una variable de tipo archivo que vamos a usar para poder enviar los parametros del file y as[i lograr almacenarlos
    private String nombre;
    private String extension;
    private String escudo;
    private Date fundacion;

    DTOUniversidad dtoUniversidad = new DTOUniversidad();

    @Inject
    private DiplomadoC diplomadoc;

    public UniversidadC() {
        lista = new ArrayList<>();
    }
    
    @PostConstruct
    public void _init(){
        lista = universidadFacade.findAll();
    }

    public List<Universidad> getLista() {
        return lista;
    }

    public void setLista(List<Universidad> lista) {
        this.lista = lista;
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

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }

    public DiplomadoC getDiplomadoc() {
        return diplomadoc;
    }

    public void setDiplomadoc(DiplomadoC diplomadoc) {
        this.diplomadoc = diplomadoc;
    }
    
    public void crearUniversidad() {
        try {
            if (file != null) {//verificamos que exista un archivo
                FotoString add = new FotoString();
                String foto = add.copyFile(file.getFileName(), file.getInputstream());//obtenemos el nombre de la imagen almacenada
                dtoUniversidad.setNombre(nombre);
                dtoUniversidad.setExtension(extension);
                dtoUniversidad.setEscudo(foto);
                dtoUniversidad.setFundacion(fundacion);

                universidadFacade.crear(dtoUniversidad);
                diplomadoc.llenarLista();
                FacesContext fCtx = FacesContext.getCurrentInstance();
                fCtx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado",
                        "Universidad " + nombre + " agregada"));
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No hay archivos cargados.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        ModelMapper model = new ModelMapper();
        DTOUniversidad dtoUni = model.map(event.getObject(), DTOUniversidad.class);
        universidadFacade.editar(dtoUni);

        FacesContext fCtx = FacesContext.getCurrentInstance();
        fCtx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado",
                "Universidad Editada"));
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesContext fCtx = FacesContext.getCurrentInstance();
        fCtx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelado",
                "Edicion cancelada"));
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        if (event != null) {
            file = event.getFile();
        }
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + "La foto ha sido cargada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
