/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicioextra_carrerade8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Carrera {

    int atletas = 0;
    boolean pistoletazo = false;

    public Carrera() {

    }

    public synchronized void esperar() {
        while (atletas < 7) {
            atletas++;
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (!pistoletazo) {
            pistoletazo = true;
            try {
                System.out.println("Preparados");
                Thread.sleep(1000);
                System.out.println("Listos");
                Thread.sleep(1000);
                System.out.println("PUMMMMMM");
                //System.out.println("Hilo Muerto!"); //jajaja
            } catch (InterruptedException ex) {
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
            }
            notifyAll();
        }

    }

    public void iniciaCarrera(int dorsal) {

        int tiempo = (int) ((Math.random() * (11000 - 9000 + 1) + 9000));
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Corredor dorsal: " + dorsal + " termino carreda " + System.currentTimeMillis());

    }

}
