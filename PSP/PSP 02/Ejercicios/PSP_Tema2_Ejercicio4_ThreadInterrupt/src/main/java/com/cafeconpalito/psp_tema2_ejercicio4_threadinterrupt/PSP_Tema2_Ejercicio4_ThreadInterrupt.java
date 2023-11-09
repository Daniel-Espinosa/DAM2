/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.psp_tema2_ejercicio4_threadinterrupt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class PSP_Tema2_Ejercicio4_ThreadInterrupt {

    public static void main(String[] args){
        
        
        
        contardo c1 = new contardo("Daniel");
        contardo c2 = new contardo("Pepe");
        contardo c3 = new contardo("Paco");
        
        c1.setPriority(Thread.MAX_PRIORITY);
        c3.setPriority(Thread.MIN_PRIORITY);
        
        c1.start();
        c2.start();
        c3.start();
        
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP_Tema2_Ejercicio4_ThreadInterrupt.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        c2.interrupt();
        
        
    }
}
