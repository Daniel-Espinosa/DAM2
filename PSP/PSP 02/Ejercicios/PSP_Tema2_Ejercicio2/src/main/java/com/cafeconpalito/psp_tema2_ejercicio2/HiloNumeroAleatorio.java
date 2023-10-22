/*
 * El primer hilo genera un número aleatorio (número a adivinar), tiene una 
variable booleana y va pidiendo el número por teclado. Si adivina el número,
cambia el valor de la booleana y muestra mensaje “Ganaste”.
 */
package com.cafeconpalito.psp_tema2_ejercicio2;

import java.util.Scanner;

/**
 *
 * @author produccion
 */
public class HiloNumeroAleatorio extends Thread {

    private boolean acertar = false;

    public boolean isAcertar() {
        return acertar;
    }


    @Override
    public void run() {

        String numAleat = "" + ((int)(Math.random() * 10) + 1);
        System.out.println("El numero aleatorio es: " + numAleat);

        Scanner sc = new Scanner(System.in);

        System.out.println("Adivina el numero aleatorio");
        while (!acertar) {

            if (numAleat.equalsIgnoreCase(sc.nextLine())) {
                acertar = true;
            } else {
                System.out.println("Vuelve a intentarlo!");
            }

        }
        
        System.out.println("Ganaste!");
    }

}
