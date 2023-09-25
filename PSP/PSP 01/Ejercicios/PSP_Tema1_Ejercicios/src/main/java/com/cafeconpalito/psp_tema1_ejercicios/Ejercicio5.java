/*
5. Utilizando la clase ProcessBuilder ejecuta el comando “CMD /c ver” y redirige la salida
estándar a un fichero llamado “salida.txt” y la salida de error a un fichero llamado “error.txt”.
Para ello, utiliza los métodos redirectOutput y redirectError de ProcessBuilder. Ejecuta después
un comando que no exista como por ejemplo “CMD /c verr”.
*/
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Ejercicio5 {
  
    public static void MetodoProcessBuilder (){
        ProcessBuilder pb = new ProcessBuilder("CMD", "/c" , "ver" );
        //ProcessBuilder pb = new ProcessBuilder("CMD", "/c" , "verr" );
        
        
        pb.redirectOutput(new File("salida.txt"));
        pb.redirectError(new File("error.txt"));
        
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
