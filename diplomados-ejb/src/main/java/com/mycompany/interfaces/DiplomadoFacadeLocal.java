/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTODiplomado;
import com.mycompany.entity.Diplomado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tegui
 */
@Local
public interface DiplomadoFacadeLocal {

    void create(Diplomado diplomado);

    void edit(Diplomado diplomado);

    void remove(Diplomado diplomado);

    Diplomado find(Object id);

    List<Diplomado> findAll();

    List<Diplomado> findRange(int[] range);

    int count();
    
    public void crear(DTODiplomado dipl);
    
    public void editar(DTODiplomado dipl);
    
}
