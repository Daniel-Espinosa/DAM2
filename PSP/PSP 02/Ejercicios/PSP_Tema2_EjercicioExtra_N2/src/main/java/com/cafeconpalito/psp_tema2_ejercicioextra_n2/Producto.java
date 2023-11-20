/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicioextra_n2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Producto {

    boolean producto = false;
    boolean termino = false;
    int nProductos = 1;

    public synchronized int getnProductos() {
        return nProductos;
    }

    public synchronized void setnProductos(int nProductos) {
        this.nProductos = nProductos;
    }

    public synchronized void producir(String usuario, int tiempo) {
        
        while (producto) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Produciendo
        System.out.println("Usuario " + usuario + " preparado para producir ");
        System.out.println(usuario + " Inicia produccion");
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(usuario + " Termina produccion");
        producto = true;
        notifyAll();
    }

    public synchronized void consumir(String usuario, int tiempo) {
        while (!producto) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Usuario " + usuario + " preparado para consumir ");
        System.out.println(usuario + " inicia el consumo");
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(usuario + " termina el consumo");
        System.out.println("Total de productos consumidos: " + nProductos);
        producto = false;
        nProductos++;
        finalizar();
        notifyAll();
    }

    public synchronized void finalizar(){
        if (nProductos == 6) {
            termino = true;
        }
    }
   
}
