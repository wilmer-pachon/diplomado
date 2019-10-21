/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.beans;

import com.mycompany.interfaces.VistaFacadeLocal;
import com.mycompany.entity.Vista;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author tegui
 */
@Stateless
public class VistaFacade extends AbstractFacade<Vista> implements VistaFacadeLocal {
    @PersistenceContext(unitName = "diplo")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VistaFacade() {
        super(Vista.class);
    }
    
    @Override
    public List<Vista> view(){
        TypedQuery<Vista> consulta = em.createNamedQuery("view", Vista.class);
        List<Vista> listaReporte = consulta.getResultList();
        
        List<Vista> listaTemp = new ArrayList();
        Iterator it = listaReporte.iterator();
        
        while(it.hasNext()){
            Object[] obj = (Object[]) it.next();
            Vista v = new Vista(String.valueOf(obj[0]), String.valueOf(obj[1]), String.valueOf(obj[2]), String.valueOf(obj[3]), String.valueOf(obj[4]), String.valueOf(obj[5]), String.valueOf(obj[6]));        
            listaTemp.add(v);
        }
        
        return listaTemp;
    }
    
}
