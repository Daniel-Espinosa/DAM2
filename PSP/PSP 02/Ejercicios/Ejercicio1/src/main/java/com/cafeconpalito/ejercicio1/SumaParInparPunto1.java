/*
*1.- Realiza un programa en java que ejecute dos hilos de forma concurrente. Uno
*de ellos debe sumar los números pares del 1 al 1000 y el otro los impares.
 */
package com.cafeconpalito.ejercicio1;

/**
 *
 * @author damt207
 */
public class SumaParInparPunto1 extends Thread {

    public static boolean parInp = false;
    public int suma = 0;

    @Override
    public void run() {
        if (parInp) {
            parInp = false;
            sumarPares();
        } else {
            parInp = true;
            sumarImpares();
        }        

    }

    public void sumarPares() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                suma += i;
            }
        }
        System.out.println("la suma de los pares es: " + suma );
    }

    public void sumarImpares() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 != 0) {
                suma += i;
            }
        }
        System.out.println("la suma de los impares es: " + suma);
    }

}
