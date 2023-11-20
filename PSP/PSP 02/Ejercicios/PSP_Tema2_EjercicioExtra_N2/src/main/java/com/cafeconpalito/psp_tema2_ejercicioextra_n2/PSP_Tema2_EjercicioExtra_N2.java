package com.cafeconpalito.psp_tema2_ejercicioextra_n2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class PSP_Tema2_EjercicioExtra_N2 {

    public static void main(String[] args) {
        
        Producto p = new Producto();
        
        Productor p1 = new Productor("Daniel", 300, p); //7000
        Consumidor c1 = new Consumidor("Ramiro", 300, p); //5000
        Consumidor c2 = new Consumidor("Albano", 300, p); //8000
        
        c1.setPriority(Thread.MAX_PRIORITY);
        c2.setPriority(Thread.NORM_PRIORITY);
        
        System.out.println("Inicia la produccion");
        
        p1.start();
        c1.start();
        c2.start();
        
        try {
            p1.join();
            c1.join();
            c2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP_Tema2_EjercicioExtra_N2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        System.out.println("Termina la produccion");       
        
    }
}
