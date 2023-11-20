/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ejerciciorepaso;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Producto {

    private int nproductos = 1;
    private boolean hayproducto = false;

    public Producto() {
    }

    public synchronized int getNproductos() {
        return nproductos;
    }

    public synchronized void setNproductos(int nproductos) {
        this.nproductos = nproductos;
    }
    
    

    public synchronized void producir(String nombre, int tiempo) {
        while (hayproducto) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Empiezo la produccion" + nombre);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Finzalizo la produccion" + nombre);
        hayproducto=true;
        notifyAll();
        
        

    }

    public synchronized void consumir(String nombre,int tiempo) {

        while (!hayproducto) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hayproducto=false;
        System.out.println("Empiezo a consumir" + nombre);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Termino de consumir" + nombre);
        System.out.println("Numero de productos"+ nproductos);
        notifyAll();
        
    }

}
