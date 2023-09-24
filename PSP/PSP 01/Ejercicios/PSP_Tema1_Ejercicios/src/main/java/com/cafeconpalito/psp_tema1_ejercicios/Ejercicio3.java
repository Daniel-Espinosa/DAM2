/*
3. Modifica el programa del ejercicio 1 que lanzaba el Notepad de Windows. Ahora, el padre,
mientras el hijo se está́ejecutando, debe realizar una tarea sencilla que consiste en generar 10
números aleatorios entre el 0 y el 9. ¿qué ocurre y por qué? 
 */
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Ejercicio3 {

    public static void pruebaRuntime(){
    Runtime rt = Runtime.getRuntime();
    //String[] comando = {"notepad.exe", argumento};
    String[] comando = {"notepad.exe"};
        try {
            Process p = rt.exec(comando);
            p.destroy();
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
