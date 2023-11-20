/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicioextra_n2;

/**
 *
 * @author damt207
 */
public class Productor extends Thread{

    String productor;
    int tiempo;
    Producto p;

    public Productor(String productor, int tiempo, Producto p) {
        this.productor = productor;
        this.tiempo = tiempo;
        this.p = p;
    }
    
    @Override
    public void run() {
        while (!p.termino) {            
            p.producir(productor, tiempo);
        }   
        
        System.out.println(productor + " ¡TERMINO! Productor");
    }


    
}
