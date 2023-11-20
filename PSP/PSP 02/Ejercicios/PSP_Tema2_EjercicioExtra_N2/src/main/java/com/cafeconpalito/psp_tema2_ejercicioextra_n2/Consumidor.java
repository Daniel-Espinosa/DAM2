/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicioextra_n2;

/**
 *
 * @author damt207
 */
public class Consumidor extends Thread{
    
    String consumidor;
    int tiempo;
    Producto p;

    public Consumidor(String consumidor, int tiempo, Producto p) {
        this.consumidor = consumidor;
        this.tiempo = tiempo;
        this.p = p;
    }

    
    @Override
    public void run() {
        while (!p.termino) {            
            p.consumir(consumidor, tiempo);
        }
        
        System.out.println(consumidor + " ¡TERMINO! Consumidor");
    }
    
}
