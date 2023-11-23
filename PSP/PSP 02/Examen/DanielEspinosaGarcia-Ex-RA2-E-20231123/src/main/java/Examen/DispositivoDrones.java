/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class DispositivoDrones {
    
    private int numeroDeTubos;
    private int numeroDeTubosLibre;
    private int numeroGolpes;
    boolean continuaBatalla = true;

    public DispositivoDrones(int numeroDeTubos, int numeroGolpes) {
        this.numeroDeTubos = numeroDeTubos;
        this.numeroDeTubosLibre = numeroDeTubos;
        this.numeroGolpes = numeroGolpes;
    }
    
    /**
     * El ingeniero intenta introducir un dron
     * @param nombre nombre del hilo que esta preparando el dron
     * @param tiempo tiempo de preparacion del dron
     */
    public synchronized void setDron(String nombre, int tiempo){
        while (numeroDeTubosLibre == 0) { //Si el tubo esta lleno espera.
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DispositivoDrones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Beep Beep, crrrk, beep, ingeniero " + nombre + " he tomado el control");
        System.out.println("    Soy el ingeniero " + nombre + " y estoy configurando un nuevo dron asesino");
        try {
            Thread.sleep(tiempo); // Tiempo de preparacion del dron
        } catch (InterruptedException ex) {
            Logger.getLogger(DispositivoDrones.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("    Soy el ingeniero " + nombre + " !He configurado un nuevo dron¡");
        numeroDeTubosLibre--;
        
        System.out.println("Tubos libres: " + numeroDeTubosLibre);
        
        notifyAll();
        
    }
    
    /**
     * El oficial intenta controlar un dron
     * @param nombre nombre del hilo que esta intentando disparar
     * @param tiempo tiempo de realizacion del disparo
     */
    public synchronized int getDron(String nombre, int tiempo){
        while (numeroDeTubosLibre == 3 ) { try { //Si el tubo esta vacio espera
            wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(DispositivoDrones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Beep Beep, crrrk, beep, oficial " + nombre + " he tomado el control");
        System.out.println("    Soy el oficial " + nombre + " voy a coger un nuevo dron asesino");
        try {
            Thread.sleep(tiempo); // Tiempo de disparo del dron
        } catch (InterruptedException ex) {
            Logger.getLogger(DispositivoDrones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("    Soy el oficial " + nombre + " !He  disparado el dron asesino¡");
        
        numeroDeTubosLibre++;
        numeroGolpes--;
        System.out.println("Tubos libres: " + numeroDeTubosLibre);
        
        naveDestruida(); // compruebo que la nave a sido destruida
        
        notifyAll();
        
        return 1;
        
    }
    
    /**
     * metodo que comprueba si la nave enemiga aun tiene golpes de vida si llega a 0 pasa el booleano a falso.
     */
    private synchronized void naveDestruida(){
        if (numeroGolpes == 1) {
            continuaBatalla = false;
        }
    }
    
    
}
