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
public class Oficial extends Thread{
    
    String nombre;
    int tiempoIntentoDisparo;
    int tiempoDisparo;
    int numeroDisparosRealizados = 0;
    DispositivoDrones d;

    public Oficial(String nombre, int tiempoIntentoDisparo, int tiempoDisparo, DispositivoDrones d) {
        this.nombre = nombre;
        this.tiempoIntentoDisparo = tiempoIntentoDisparo;
        this.tiempoDisparo = tiempoDisparo;
        this.d = d;
    }




    @Override
    public void run() {
        while (d.continuaBatalla) { // comprueba que el booleano este a true (la batalla continua ya que la nave no ha sido destruida)  
            
            try {
                Thread.sleep(tiempoIntentoDisparo); // tiempo de espera entre intentos de disparo
            } catch (InterruptedException ex) {
                Logger.getLogger(Oficial.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            numeroDisparosRealizados += d.getDron(nombre, tiempoDisparo); // lanza el metodo de realizar disparo, si el oficial realiza un disparo aumenta el contador de sus disparos realizados
        }
        
    }
    
    
    /**
     * metodo para mostrar por pantalla que la batalla termino.
     */
    public void batallaTermino(){
        System.out.println(nombre+ ": Si! La batalla ha terminado");
    }
    
    /**
     * metodo que muestra por pantalla el numero de golpes que realizo el Oficial
     */
    public void recuentoDrones(){
        System.out.println(nombre+ " ha disparado: " + numeroDisparosRealizados + " drones");
    }
    
}
