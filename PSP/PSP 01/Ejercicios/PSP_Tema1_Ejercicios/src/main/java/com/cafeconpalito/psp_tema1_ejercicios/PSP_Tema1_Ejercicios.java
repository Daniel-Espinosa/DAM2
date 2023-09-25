/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.psp_tema1_ejercicios;

/**
 *
 * @author produccion
 */
public class PSP_Tema1_Ejercicios {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        
        
        System.out.println("\nEjercicio 1");
        Ejercicio1.pruebaRuntime(args[0]);
        
        
        System.out.println("\nEjercicio 2");
        Ejercicio2.propiedadesDelSistema();
    
        System.out.println("\nEjercicio 3");
        Ejercicio3.pruebaRuntime();
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random()*9));
        }
        
        System.out.println("\nEjercicio 4");
        //NO ENTENDEMOS EL ENUNCIADO
        
        System.out.println("\nEjercicio 5");
        Ejercicio5.MetodoProcessBuilder();
    
    }
}
