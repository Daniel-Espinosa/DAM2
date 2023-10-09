/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ejemplo2mihilothread;

/**
 *
 * @author damt207
 */
public class Ejemplo2MiHiloThread {

    public static int suma = 0;
    
    public static void main(String[] args) {
                
        System.out.println("Hilo Principal , iniciando");
        
        Thread t = Thread.currentThread();
        System.out.println("Hilo PAPA: " + t);
        
        MiHiloThread m1 = new MiHiloThread("Hilo 1");
        MiHiloThread m2 = new MiHiloThread("Hilo 2");
        MiHiloThread m3 = new MiHiloThread("Hilo 3");
        //MiHiloThread m4 = new MiHiloThread("Hilo 4");
        
        m1.start();
        m2.start();
        m3.start();
        System.out.println("Hilo 1 " + m1.toString());
        System.out.println("Hilo 2 " + m2.toString());
        System.out.println("Hilo 3 " + m3.toString());
        
        for (int i = 0; i < 50; i++) {
            System.out.println(".");
        }
        
        
        while (m1.isAlive()||m2.isAlive()||m3.isAlive()) {            
            t.interrupt();
        }
        
        //t.notify();
        
        System.out.println("Hilo principal Finalizando");
        System.out.println("suma " + suma);
        
        
    }
}
