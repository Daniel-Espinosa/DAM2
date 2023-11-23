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
public class Ingeniero extends Thread{
    
    String nombre;
    int tiempoIntetoConfiguracion;
    int tiempoConfiguracion;
    DispositivoDrones d;

    public Ingeniero(String nombre, int tiempoIntetoConfiguracion, int tiempoConfiguracion, DispositivoDrones d) {
        this.nombre = nombre;
        this.tiempoIntetoConfiguracion = tiempoIntetoConfiguracion;
        this.tiempoConfiguracion = tiempoConfiguracion;
        this.d = d;
    }

    @Override
    public void run() {
        
    while (d.continuaBatalla) { // comprueba que el booleano este a true (la batalla continua ya que la nave no ha sido destruida)
            
            try {
                Thread.sleep(tiempoIntetoConfiguracion); // tiempo de espera para el intento la configuracion del dron
            } catch (InterruptedException ex) {
                Logger.getLogger(Ingeniero.class.getName()).log(Level.SEVERE, null, ex);
            }
            d.setDron(nombre, tiempoConfiguracion); // metodo de preparacion del dron
            
        }
        
    }
    
    /**
     * metodo para mostrar por pantalla que la batalla termino.
     */
    public void batallaTermino(){
        System.out.println(nombre+ ": Si! La batalla ha terminado");
    }
    
    
    
}
