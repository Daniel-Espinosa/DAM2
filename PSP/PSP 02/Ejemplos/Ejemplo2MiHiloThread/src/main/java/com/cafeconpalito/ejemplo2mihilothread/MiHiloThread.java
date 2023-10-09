/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ejemplo2mihilothread;

/**
 *
 * @author damt207
 */
public class MiHiloThread extends Thread{

    
    String nombreHilo;

    public MiHiloThread(String nombre) {
        this.nombreHilo=nombre;
    }
    
    
    
    @Override
    public void run() {
        System.out.println("Comenzando " + nombreHilo);
        
        for (int i = 0; i < 1000000; i++) {
            System.out.println("En: " + nombreHilo + ", el recuento " + i );
            Ejemplo2MiHiloThread.suma += 1;
        
        }
        
        
        System.out.println("Terminando Hilo " + nombreHilo);
    }


}
