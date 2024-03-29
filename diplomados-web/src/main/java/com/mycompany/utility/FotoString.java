/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utility;

import java.io.*;
import java.text.*;
import java.util.Date;
import javax.faces.context.*;
import javax.servlet.ServletContext;

/**
 *
 * @author tegui
 */
public class FotoString implements Serializable {

    public FotoString() {
    }

    public String copyFile(String fileName, InputStream in) {
        String nombreA = "";//inicializamos una variable string para almacenar y luego retornar el nombre del archivo
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ServletContext scontext = (ServletContext) context.getExternalContext().getContext();
            System.out.println("Ruta Path: " + scontext.getRealPath("/"));
            String ruta = scontext.getRealPath("\\") + "/resources/";
            try (OutputStream out = new FileOutputStream(new File(ruta + fileName))) {
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.close();
                out.flush();
            }
            System.out.println("El archivo se ha creado con éxito!");

            DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss");
            Date date = new Date();
            String ruta1 = ruta + fileName;
            System.err.println("Ruta Inicial: " + ruta1);
            String ruta2 = ruta + dateFormat.format(date) + fileName;
            System.out.println("Archivo: " + ruta1 + "\nRenombrado a: " + ruta2);
            File archivo = new File(ruta1);
            archivo.renameTo(new File(ruta2));
            nombreA = dateFormat.format(date) + fileName;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return nombreA;
    }

}
