/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema2_ejercicio5_garaje;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Garaje {
    
    /*
    • El garaje tiene dos puertas, una de entrada y otra de salida. La capacidad del garaje es de
    200 coches.
    */
    
    private int cuenta = 100;
    private boolean lleno;

    public int getCuenta() {
        return cuenta;
    }
        
    public synchronized void puertaEntrada(){
        while(cuenta >= 200){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Garaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        cuenta++;
        notifyAll();
    }
    
    public synchronized void puertaSalida(){
        while(cuenta <= 0){ 
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Garaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cuenta--;
        notifyAll();
        
    }
    
    
    private void islleno(){
        if (cuenta == 200) {
            lleno = true;
        } else {
            lleno = false;
        }
        
    }     
    
}
