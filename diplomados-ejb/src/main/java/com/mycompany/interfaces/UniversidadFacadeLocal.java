/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.dto.DTOUniversidad;
import com.mycompany.entity.Universidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tegui
 */
@Local
public interface UniversidadFacadeLocal {

    void create(Universidad universidad);

    void edit(Universidad universidad);

    void remove(Universidad universidad);

    Universidad find(Object id);

    List<Universidad> findAll();

    List<Universidad> findRange(int[] range);

    int count();
    
    void crear(DTOUniversidad uni);
    
    void editar(DTOUniversidad uni);
    
}
