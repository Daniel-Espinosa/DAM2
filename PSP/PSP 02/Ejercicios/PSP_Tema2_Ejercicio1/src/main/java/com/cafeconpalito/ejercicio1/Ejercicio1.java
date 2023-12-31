/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.ejercicio1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Ejercicio1 {

    public static void main(String[] args) {
       
        
        
        
        Thread t = Thread.currentThread();
        
        /*
        //Punto1
        //Un metodo para cada hilo
        sumaPar m1 = new sumaPar();
        sumaImpar m2 = new sumaImpar();
        m1.start();
        m2.start();
        */
        
        /*
        //Punto1 v2
        //Un solo metodo para cada hilo
        SumaParInparPunto1 m3 = new SumaParInparPunto1();
        SumaParInparPunto1 m4 = new SumaParInparPunto1();
        m3.start();
        m4.start();
        */
        
        /*
        
        //Punto2
        System.out.println("Inicio (Punto2)");
        ContarLineasPunto2 cont1= new ContarLineasPunto2("texto.txt");
        
        cont1.start();
               
        try {
            cont1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Adios! (Punto2)");
        
        */
        
        
        
        
        
        //Punto3
        //CARGAR COMO ARGUMENTOS texto1.txt texto2.txt texto3.txt texto4.txt
        System.out.println("Inicio (punto3)");
        
        ArrayList <ContarLineasPunto3> lista = new ArrayList();
        for (int i = 0; i < args.length; i++) {
            ContarLineasPunto3 e = new ContarLineasPunto3(args[i]);
            lista.add(e);
        }
        
        for (ContarLineasPunto3 i : lista) {
            i.run();
        }
        
        for (ContarLineasPunto3 i : lista) {
            try {
                i.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Adios! (punto3)");
        
        
                
    }
}
