/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Examen;

import com.sun.source.tree.Tree;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class App {

    public static void main(String[] args) {
        
        System.out.println("Hola, El usuario Daniel Espinosa Garcia esta haciendo la aplicacion para el RA2");
        System.out.println("------------------------------- STAR WARS --------------------------------------");
        
        System.out.println("\nHace mucho tiempo en una galaxia muy muy lejana...");
        System.out.println("\nSe esta librando una horrible batalla en las afueras de la galaxia entre las flotas rebeldes e imperiales");
        System.out.println("--------------------------------------------------------------------------------\n");
        DispositivoDrones d = new DispositivoDrones(3, 6);
        
        Ingeniero ing = new Ingeniero("Beslu Palug", 600, 100, d);
        
        Oficial of1 = new Oficial("Daor Ban",5000, 20, d); //5000
        of1.setPriority(10); // Dando Prioridad 10 a Daor Ban
        
        Oficial of2 = new Oficial("Maza Aho", 8000, 20, d); //8000
        of2.setPriority(5); //Dando Prioridad 5 a Maza Aho
        
        ing.start();
        of1.start();
        of2.start();
        
        try {
            ing.join();
            of1.join();
            of2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("");
        ing.batallaTermino();
        of1.batallaTermino();
        of2.batallaTermino();
        
        System.out.println("");
        of1.recuentoDrones();
        of2.recuentoDrones();
        
        
        System.out.println("\nFin");
        
    }
}
