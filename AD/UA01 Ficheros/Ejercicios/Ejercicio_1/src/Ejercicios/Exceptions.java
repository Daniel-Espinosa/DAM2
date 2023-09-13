/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author damt207
 */
public class Exceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int valor1,valor2;
        
        valor1 = 10;
        valor2 = 0;
        
        try {
            
            System.out.println(valor1/valor2);

            
        } catch (ArithmeticException e) {
            System.err.println("No puedes dividir entre 0");
            
        }
        
        
    }
    
}
