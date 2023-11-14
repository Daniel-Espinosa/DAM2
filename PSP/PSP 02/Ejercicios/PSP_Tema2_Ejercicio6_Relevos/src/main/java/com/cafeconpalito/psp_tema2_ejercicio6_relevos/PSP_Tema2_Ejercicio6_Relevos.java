/*
1. Escribe una clase Relevos que simule una carrera de relevos de la siguiente forma:
• Crea 4 hilos, cada hilo simulará el comportamiento de un corredor.
o Primero, espera en la salida hasta que hayan llegado los otros corredores. Para 
contar el número de corredores preparados, se puede usar una variable que 
cuente el número de corredores en la salida.
o Cuando empieza la carrera, uno de los corredores coge el relevo y empieza a 
correr. Para simular que tarda un tiempo, el hilo se dormirá un tiempo entre 0 
y 2 segundos.
o Cuando un hilo termina de correr pone un mensaje en pantalla, pasando el 
relevo a otro de los hilos para que comience a correr, y terminado su ejecución 
propia.
• Cuando el último hilo termine de correr, el hilo padre (main) mostrará un mensaje
*/

package com.cafeconpalito.psp_tema2_ejercicio6_relevos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class PSP_Tema2_Ejercicio6_Relevos {

    public static void main(String[] args) {
        
        System.out.println("Inicia la Carrera");
        
        Relevos r = new Relevos();
        
        ArrayList<Thread> lista = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            Corredor c = new Corredor(r, i+1);
            Thread t = new Thread(c);
            lista.add(t);
        }
        
        for (Thread thread : lista) {
            thread.start();
        }
        
        for (Thread thread : lista) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Tema2_Ejercicio6_Relevos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Termino la Carrera");
        
    }
}
