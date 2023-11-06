/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.psp_tema2_ejercicio3_sumacompartida;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class PSP_Tema2_Ejercicio3_SumaCompartida {

    public static void main(String[] args) {
        
        ArrayList<Thread> hilos = new ArrayList<>();
        Contador c = new Contador();
        
        System.out.println("inicio");
                
        for (int i = 0; i < 10; i++) {
            HiloSuma hs =new HiloSuma(i, c);
            Thread t= new Thread(hs);
            hilos.add(t);
        }
        
        for (int i = 0; i < 10; i++) {
            HiloResta hr =new HiloResta(i, c);
            Thread t= new Thread(hr);
            hilos.add(t);
        }
        
        for (Thread hilo : hilos) {
            hilo.start();
        }
        
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Tema2_Ejercicio3_SumaCompartida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("fin " + c.getNumero());
                
    }
}
