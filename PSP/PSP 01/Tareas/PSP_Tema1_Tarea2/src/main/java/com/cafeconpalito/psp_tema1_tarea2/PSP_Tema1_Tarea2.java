/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.psp_tema1_tarea2;

/**
 *
 * @author damt207
 */
public class PSP_Tema1_Tarea2 {

    public static void main(String[] args) {
    
        //Metodo para Generar los ficheros que se quieren sumar
        Metodos.generadorDeFicheros(3,1000000);
    
        //Metodo de suma para solo sumar el total de un fichero y generar el archivo .res
        Metodos.suma(args[0]);
        
        //Metodo para realizar las sumas secuencialmente de los ficheros
        Metodos.sumaTotalesSecuencial(args);
        
        //Metodo para realizar las sumas de los ficheros en paralelo.
        Metodos.sumaTotalesParalela(args);
    }
}
