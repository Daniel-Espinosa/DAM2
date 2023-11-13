/*
1. Aplicación Java que cuenta coches en un garaje. Sincroniza los hilos con un monitor.
• El garaje tiene dos puertas, una de entrada y otra de salida. La capacidad del garaje es de
200 coches.
• Si el garaje está lleno, los coches que van a entrar deben esperar a que alguno salga.
• Unos hilos simularán la entrada y otros hilos la salida del garaje.
• Todos los hilos van compartir el garaje, a través de la variable cuenta, que aumenta o
disminuye su valor en uno cada vez que hay una entrada o salida del garaje.
• Partimos de una situación inicial con 100 coches en el garaje.
• El programa principal simulará la entrada de 150 coches y la salida de 60.
• El programa principal, una vez hayan salido y entrado todos los coches, deberá imprimir
"GARAJE CERRADO

*/

package com.cafeconpalito.psp_tema2_ejercicio5_garaje;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class PSP_Tema2_Ejercicio5_Garaje {

    public static void main(String[] args) {
        
        try {
            Garaje g = new Garaje();
                       
            ArrayList<Thread> lista = new ArrayList<>();
                    
            System.out.println("Abre garaje");
            
            //Hilos Entrada
            for (int i = 0; i < 150; i++) {
                hiloEntradaCoche hec = new hiloEntradaCoche(g, i);
                Thread t = new Thread(hec);
                lista.add(t);
            }
            
            //Hilos Salida
            for (int i = 0; i < 60; i++) {
                hiloSalidaCoche hsc = new hiloSalidaCoche(g, i);
                Thread t = new Thread(hsc);
                lista.add(t);
            }

            for (Thread t : lista) {
                t.start();
            }
            
            for (Thread t : lista) {
                t.join();
            }


            System.out.println("Cierra garaje");
        } catch (InterruptedException ex) {
            Logger.getLogger(PSP_Tema2_Ejercicio5_Garaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
