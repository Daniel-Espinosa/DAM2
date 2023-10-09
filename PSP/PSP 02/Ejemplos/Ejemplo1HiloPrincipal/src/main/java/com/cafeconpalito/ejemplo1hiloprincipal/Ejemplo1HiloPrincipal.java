/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ejemplo1hiloprincipal;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Ejemplo1HiloPrincipal {

    public static void main(String[] args) {
        
        Thread t = Thread.currentThread();
        
        //Obtner la referencia del hilo actual
        System.out.println("Hilo Actual: " + t);
        //Thread[main,5,main] "main" nombre del grupo, "5" prioridad del hilo , "main" grupo del hilo
        
        //NOMBRE DEL HILO Y CAMBIAR NOMBRE
        System.out.println("Nombre hilo: " + t.getName());
        t.setName("Mi Hilo"); //Cambiar nombre del Hilo
        System.out.println("Nombre hilo: " + t.getName());
        
        
        //Dormir un hilo
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejemplo1HiloPrincipal.class.getName()).log(Level.SEVERE, null, ex);    
            }
        }
        
        

    }
}
