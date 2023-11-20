/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.ejerciciorepaso;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Productor extends Thread{

    Producto p;
    String nombre;
    int tiempo;

    public Productor(Producto p, String nombre, int tiempo) {
        this.p = p;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        while (p.getNproductos() < 6) {
            p.producir(nombre, tiempo);
        }
        
    }
    
    public void finalizar(){
        System.out.println("Finalize");
    }

}
