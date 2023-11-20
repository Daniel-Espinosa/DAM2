/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.cafeconpalito.ejerciciorepaso;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carra
 */
public class Principal {

    public static void main(String[] args) {
        try {
            System.out.println("Linea 1");
            System.out.println("Linea 2");
            System.out.println("Linea 3");

            Producto p = new Producto();

            Productor pr = new Productor(p, "Productor 1", 500);
            Consumidor c = new Consumidor(p, "Consumidor1", 500);
            Consumidor c2 = new Consumidor(p, "Consumidor2", 500);

            c.setPriority(Thread.MAX_PRIORITY);
            c2.setPriority(Thread.NORM_PRIORITY);

            pr.start();
            c.start();
            c2.start();

            c.join();
            c2.join();
            pr.join();
            
            c.finalizar();
            c2.finalizar();
            pr.finalizar();

            System.out.println("Linea Final");
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
