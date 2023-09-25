/*
6. Crea un programa en Java que imprima ¿qué pasa?, 10 veces esperando un segundo cada
vez.
*/
package com.cafeconpalito.psp_tema1_ejercicios;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Ejercicio6 {
    
    public static void quePasa (){
        
        
        
        for (int i = 0; i < 10; i++) {
            System.out.println("¿qué pasa?");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio6.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
