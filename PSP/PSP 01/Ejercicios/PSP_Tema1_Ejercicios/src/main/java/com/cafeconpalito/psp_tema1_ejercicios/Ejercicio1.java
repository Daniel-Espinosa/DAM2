/*
1. Utilizando la clase Runtime, realiza un programa que lance un proceso hijo que ejecute el
notepad de Windows pasándole como argumento un fichero de texto para que lo abra (crea un
fichero de ejemplo en la raíz del proyecto para probarlo). Los argumentos se pasan a través de
la línea de comandos (String[] args). 
 */
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Ejercicio1 {

    public static void pruebaRuntime(String argumento){
    Runtime rt = Runtime.getRuntime();
    String[] comando = {"notepad.exe", argumento};
    //String[] comando = {"notepad.exe"};
        try {
            Process p = rt.exec(comando);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
