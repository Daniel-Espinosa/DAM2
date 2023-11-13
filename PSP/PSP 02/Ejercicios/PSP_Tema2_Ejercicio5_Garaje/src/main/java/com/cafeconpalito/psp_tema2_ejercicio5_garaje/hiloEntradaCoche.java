/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio5_garaje;

/**
 *
 * @author damt207
 */
public class hiloEntradaCoche implements Runnable{

    private Garaje g;
    private int hEC_ID;

    public hiloEntradaCoche(Garaje g, int hEC_ID) {
        this.g = g;
        this.hEC_ID = hEC_ID;
    }
    
    @Override
    public void run() { // Entran 150
            g.puertaEntrada();
            System.out.println("Entra coche total = " + g.getCuenta());
    }
    
    
    
}
