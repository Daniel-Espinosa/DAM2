/*
3. Modifica el programa del ejercicio 1 que lanzaba el Notepad de Windows. Ahora, el padre,
mientras el hijo se está́ejecutando, debe realizar una tarea sencilla que consiste en generar 10
números aleatorios entre el 0 y el 9. ¿qué ocurre y por qué? 

7. Crea un programa igual el ejercicio 3, pero justo después de crear el proceso hijo el padre
espera a que termine antes de generar los números aleatorios. ¿Qué ocurre? Por último, obtén
el valor de salida.

Hasta que no matas al proceso hijo no continua  con el programa.

¿¿¿¿VALOR DE SALIDA???

 */
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author produccion
 */
public class Ejercicio7 {

    public static void pruebaRuntime() {
        Runtime rt = Runtime.getRuntime();
        //String[] comando = {"notepad.exe", argumento};
        String[] comando = {"notepad.exe"};
        try {
            Process p = rt.exec(comando);
            p.waitFor();
            for (int i = 0; i < 10; i++) {
                System.out.println((int) (Math.random() * 9));
            }
            System.out.println("Valor de Salida: "+p.exitValue());
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
