/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicioextra_carrerade8;

/**
 *
 * @author damt207
 */
public class Atleta implements Runnable {

    private int dorsal;
    Carrera c;

    public Atleta(int dorsal, Carrera c) {
        this.dorsal = dorsal;
        this.c = c;
    }
    
    @Override
    public void run() {
        
        System.out.println("Corredor dorsal " + dorsal + " preparado");
        c.esperar();
        c.iniciaCarrera(dorsal);
        
    }

}
