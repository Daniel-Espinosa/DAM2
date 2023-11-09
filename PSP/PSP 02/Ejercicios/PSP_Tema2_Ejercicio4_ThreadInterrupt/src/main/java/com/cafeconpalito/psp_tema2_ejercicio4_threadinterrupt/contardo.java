/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio4_threadinterrupt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class contardo extends Thread {

    public contardo(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        try {

            System.out.println("Iniciando id: " + getName());

            for (int i = 0; i < 5 && !Thread.interrupted(); i++) {

                System.out.println("Iteracion: " + getName() + " " + (i + 1));
                sleep(2000);
            }

            System.out.println("Terminado id:" + getName());

        } catch (InterruptedException e) {
            System.out.println();
        }

    }

}
