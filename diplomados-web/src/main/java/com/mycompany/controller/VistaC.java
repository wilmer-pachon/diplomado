/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.entity.Vista;
import com.mycompany.interfaces.VistaFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.*;

/**
 *
 * @author tegui
 */
@Named
@SessionScoped
public class VistaC implements Serializable {

    @EJB
    private VistaFacadeLocal vistaFacade;
    
    private List<Vista> lista;

    public VistaC() {
        lista = new ArrayList<>();
    }
    
    @PostConstruct
    public void _init() {
        lista = vistaFacade.findAll();
    }
    
    public void llenarLista() {
        lista = vistaFacade.findAll();
    }

    public List<Vista> listarView() {
        return vistaFacade.view();
    }

    public List<Vista> getLista() {
        return lista;
    }

    public void setLista(List<Vista> lista) {
        this.lista = lista;
    }
    

}
