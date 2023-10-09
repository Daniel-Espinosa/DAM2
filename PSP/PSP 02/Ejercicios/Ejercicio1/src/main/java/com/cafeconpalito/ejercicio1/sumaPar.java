/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ejercicio1;

/**
 *
 * @author damt207
 */
public class sumaPar extends Thread{

    private int suma = 0;
    @Override
    public void run() {
    
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                suma += i;
            }
        }
        System.out.println("la suma de los pares es: " + suma );
    
    }
    
    
    
}
