/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio6_relevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Relevos {

    private int corredores = 0;

    public Relevos() {

    }

    public synchronized void espera() {
        while (corredores < 3) {
            try {
                corredores++;
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Relevos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         
    }
    
    
    public synchronized void correr(int id){
        
        System.out.println("Corredor " + id + " Inicia la carrera");
        try {
            int tiempo = (int) (Math.random()*(2000-1000+1)+1000 );
            Thread.sleep(tiempo);
            System.out.println("Tiempo de carrera = " + tiempo + " milisegundos");
        } catch (InterruptedException ex) {
            Logger.getLogger(Relevos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Corredor " + id + " Pasa el testigo");
        notify();
        
    }
    
}
