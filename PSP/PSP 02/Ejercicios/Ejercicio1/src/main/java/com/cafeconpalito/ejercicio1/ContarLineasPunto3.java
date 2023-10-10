/*
 2.- Realiza un programa en java que reciba como argumento el nombre de un
fichero de texto. El programa debe crear un hilo. El hilo debe contar cuantas
líneas hay en el fichero de texto. El programa principal espera a que el hilo
termine de ejecutarse y se despide.
 */
package com.cafeconpalito.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class ContarLineasPunto3 extends Thread {

    public String nombreFichero;

    public ContarLineasPunto3(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    @Override
    public void run() {

        int suma = 0;

        File fichero = new File(nombreFichero);

        if (fichero.exists()) {

            try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {

                while ((br.readLine()) != null) {
                    suma += 1;
                }

                //Muestra por pantalla la cantidad de lineas.
                System.out.println("El fichero " + nombreFichero + " tiene: " + suma + " lineas");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ContarLineasPunto3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ContarLineasPunto3.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("el fichero no existe");
        }

    }

}
