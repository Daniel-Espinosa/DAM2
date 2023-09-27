/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author msola
 */
public class Operaciones {
    
    public static void save (String filename, int resultado){
        //Desarrollar el método para guardar en el fichero el resultado
        
        File archivo = new File(filename);

        FileWriter fw = null;
        
        try {
            fw = new FileWriter(archivo);
            fw.write(""+resultado);
        } catch (IOException e) {
            System.err.println("IOException");
        } finally {
            try {
                if (fw!=null) {
                    fw.close();
                }
            } catch (IOException e) {
                System.err.println("IOException cierre flujo");
            }
        }
        
        
    }
    
    
}
