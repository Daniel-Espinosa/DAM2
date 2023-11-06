/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio3_sumacompartida;

/**
 *
 * @author damt207
 */
public class HiloSuma implements Runnable{

    private int id;
    private Contador c;
    
    public HiloSuma(int id, Contador c) {
        this.id = id;
        this.c = c;
    }
    
    /*
    //Metodo Sincronizando Segmento de codigo
    @Override
    public void run() {
    
        System.out.println("Entra el hilo suma " + id);
        for (int i = 0; i < 1000; i++) {
            synchronized(c){
                c.sumaContador(1);
            }
        }
        
        System.out.println("Termina el hilo suma " + id);
    }
    */

    @Override
    public void run() {
    
        System.out.println("Entra el hilo suma " + id);
        for (int i = 0; i < 1000; i++) {
            c.sumaContador(1);
        }
        
        System.out.println("Termina el hilo suma " + id);
    }
    
}
