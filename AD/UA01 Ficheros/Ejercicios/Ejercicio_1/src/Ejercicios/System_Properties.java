/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Ejercicios;


/**
 *
 * @author damt207
 */
public class System_Properties {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("\nDirectorio del Trabajo");
        System.out.println(System.getProperty("user.dir"));
        System.out.println("\nDirectorio del Usuario");
        System.out.println(System.getProperty("user.home"));
        System.out.println("\nNombre de Usuario");
        System.out.println(System.getProperty("user.name"));
        
    }
    
}
