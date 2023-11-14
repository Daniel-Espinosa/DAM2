/*
Implementar una carrera de 100m lisos:
 Tenemos 8 Atletas dispuestos a correr
 Cada uno tiene un atributo dorsal
 Tenemos una clase principal Carrera
 Indica el pistoletazo de salida y el resultado de la carrera
 Todos los Atletas comienzan pero se quedan parados
esperando el pistoletazo de salida
 Luego comienzan a correr (tardan entre 9 y 11s)
 Al llegar a meta notifican a la carrera su dorsal y terminan
 La Carrera escribe “preparados” y espera 1s, luego escribe
“listos” y espera 1s, finalmente escribe “ya!” y notifica a los
hilos de los Atletas
 Cada vez que un atleta le notifica su dorsal, escribe por
pantalla: dorsal+” tarda “+System.currentTimeMillis()
*/

package com.cafeconpalito.psp_tema2_ejercicioextra_carrerade8;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class PSP_Tema2_EjercicioExtra_CarreraDe8 {

    public static void main(String[] args) {
        
        ArrayList<Thread> lista = new ArrayList<>();
        Carrera c = new Carrera();
        
        for (int i = 0; i < 8; i++) {
            Atleta a = new Atleta(i+1, c);
            Thread t = new Thread(a);
            lista.add(t);
        }
        
        System.out.println("Preparando Carrera");
        
        for (Thread t : lista) {
            t.start();
        }
        
        
        for (Thread t : lista) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(PSP_Tema2_EjercicioExtra_CarreraDe8.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Carrera Terminda");
        
    }
}
