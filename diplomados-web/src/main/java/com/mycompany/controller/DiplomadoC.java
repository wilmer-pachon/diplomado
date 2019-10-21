/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.dto.DTODiplomado;
import com.mycompany.dto.DTOUniversidad;
import com.mycompany.entity.Diplomado;
import com.mycompany.entity.Universidad;
import com.mycompany.interfaces.DiplomadoFacadeLocal;
import com.mycompany.interfaces.UniversidadFacadeLocal;

import java.io.Serializable;
import java.util.*;
import javax.annotation.*;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.*;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.modelmapper.ModelMapper;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author tegui
 */
@Named
@ViewScoped
public class DiplomadoC implements Serializable {

    @EJB
    private UniversidadFacadeLocal universidadFacade;
    @EJB
    private DiplomadoFacadeLocal diplomadoFacade;

    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Universidad> lista;
    private int uni;

    DTODiplomado dtoDiplomado = new DTODiplomado();
    DTOUniversidad dtoUniversidad = new DTOUniversidad();
    
    @Inject
    private EstudianteC estudianteC;

    public DiplomadoC() {
        lista = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Universidad> getLista() {
        return lista;
    }

    public void setLista(List<Universidad> lista) {
        this.lista = lista;
    }

    public int getUni() {
        return uni;
    }

    public void setUni(int uni) {
        this.uni = uni;
    }

    public EstudianteC getEstudianteC() {
        return estudianteC;
    }

    public void setEstudianteC(EstudianteC estudianteC) {
        this.estudianteC = estudianteC;
    }
    
    @PostConstruct
    public void _init(){
        lista = universidadFacade.findAll();
    }
    
    public void llenarLista(){
        lista = universidadFacade.findAll();
    }
    
    public List<Diplomado> listarDiplomado(){
        return diplomadoFacade.findAll();
    }
    
    public void crearDiplomado(){
        
        Universidad universidad = universidadFacade.find(uni);
        Diplomado dip = new Diplomado(nombre,  fechaInicio, fechaFin, descripcion, universidad);
        List<Diplomado> listaDiplomado = new ArrayList<>();
        listaDiplomado.add(dip);
        dip.setUniversidad(universidad);
        diplomadoFacade.create(dip);
        estudianteC.llenarLista();
        FacesContext fCtx = FacesContext.getCurrentInstance();
        fCtx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Agregado",
                        "Diplomado "+nombre+" agregado"));
    }
    
    public void onRowEdit(RowEditEvent event){
        ModelMapper model = new ModelMapper();
        DTODiplomado dtoDiplomado = model.map(event.getObject(), DTODiplomado.class);
        diplomadoFacade.editar(dtoDiplomado);
        FacesContext fCtx = FacesContext.getCurrentInstance();
        fCtx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado",
                        "Diplomado Editado"));
    }
    
    public void onRowCancel(RowEditEvent event){
        FacesContext fCtx = FacesContext.getCurrentInstance();
        fCtx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelado",
                        "Transacción cancelada por el usuario"));
    }

    
}
