/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio6_relevos;

/**
 *
 * @author damt207
 */
public class Corredor implements Runnable{
    
    Relevos r;
    int id;

    public Corredor(Relevos r, int id) {
        this.r = r;
        this.id = id;
    }

    
    
    @Override
    public void run() {
        System.out.println("Corredor " + id + " Preparado");
        r.espera();
        System.out.println("Corredor " + id + " Inicia la carrera");
        r.correr();
        System.out.println("Corredor " + id + " Pasa el testigo");
    }
    
    
    
    
}
