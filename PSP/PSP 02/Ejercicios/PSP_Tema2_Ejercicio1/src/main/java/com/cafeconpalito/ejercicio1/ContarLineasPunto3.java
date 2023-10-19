/*
3.- Modifica el programa anterior para que lea el número de líneas de todos los 
ficheros pasados como argumentos. El programa creará un array de hilos con 
tantos elementos como ficheros pasados como argumentos. El programa 
principal esperará a que termine la ejecución de todos los hilos.
En este caso se creará un hilo por fichero a leer las líneas. Por cada hilo se 
guardará una referencia en un array para hacer al final un join de todos los hilos
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
