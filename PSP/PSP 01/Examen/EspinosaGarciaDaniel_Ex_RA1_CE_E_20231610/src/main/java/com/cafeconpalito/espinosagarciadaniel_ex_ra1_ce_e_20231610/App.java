/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.espinosagarciadaniel_ex_ra1_ce_e_20231610;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class App {

    public static void main(String[] args) {
         
        
        //Punto1
        BannerWorld.imprimirDatosAlumnoExamen();
        
        //Punto2
        try {
            //duerme un segundo
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //punto3
        BannerWorld.generandoFichero();
        
        
        //punto 4 y 5
        //Creo un proceso y le paso parametros
        ProcessCreator p = new ProcessCreator(args[0], args[1], args[2]);
                
        p.launchProcessGenerator();
        //p.blockProcess(p);
        
        p.launchCreandoCopia();
        
        //punto6
        BannerWorld.creandoCopia();
        
        
        
        
        
        //punto8
        BannerWorld.abriendoFichero();
                
        try {
            //duerme un segundo
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        p.launchAbriendoCopia();
        
    }
}
