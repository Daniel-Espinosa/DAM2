/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio3_sumacompartida;

/**
 *
 * @author damt207
 */
public class HiloResta implements Runnable{
    
    private int id;
    private Contador c;
    
    public HiloResta(int id, Contador c) {
        this.id = id;
        this.c = c;
    }
    
    /*
    @Override
    //Metodo Sincronizando Segmento de codigo
    public void run() {
    
        System.out.println("Entra el hilo Resta " + id);
        for (int i = 0; i < 100; i++) {
            synchronized (c) {
               c.restaContador(1); 
            }
            
        }
        System.out.println("Termina el hilo Resta " + id);
    
    }
    */
    
    @Override
    public void run() {
    
        System.out.println("Entra el hilo Resta " + id);
        for (int i = 0; i < 100; i++) {
               c.restaContador(1); 
        }
        System.out.println("Termina el hilo Resta " + id);
    
    }
    
}
    
