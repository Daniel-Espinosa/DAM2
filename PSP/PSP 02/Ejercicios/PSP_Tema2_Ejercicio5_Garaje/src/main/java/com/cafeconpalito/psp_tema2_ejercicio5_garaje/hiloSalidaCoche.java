/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio5_garaje;

/**
 *
 * @author damt207
 */
public class hiloSalidaCoche implements Runnable{

    private Garaje g;
    private int hSC_ID;

    public hiloSalidaCoche(Garaje g, int hSC_ID) {
        this.g = g;
        this.hSC_ID = hSC_ID;
    }

    @Override
    public void run() { // Salen 60
            g.puertaSalida();
            System.out.println("Sale Coche total = " +g.getCuenta());
    }

}
