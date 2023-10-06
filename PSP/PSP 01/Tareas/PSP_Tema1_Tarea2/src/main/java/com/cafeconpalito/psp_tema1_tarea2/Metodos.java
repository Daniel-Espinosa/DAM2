/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema1_tarea2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Metodos {

    /**
     * Metodo que recibe un entero para saber el numero de ficheros a generar y
     * la cantidad de numeros que este generara en el fichero.
     * @param numFicheros numero de ficheros que se quieren crear
     * @param cantNumeros cantidad de numeros que se quieren añadir
     */
    public static void generadorDeFicheros(int numFicheros, int cantNumeros) {

        String nombreFichero = null;

        for (int i = 0; i < numFicheros; i++) {

            nombreFichero = "contabilidad" + (i + 1) + ".txt";

            File archivo = new File(nombreFichero);
            if (archivo.exists()) {
                archivo.delete();
            }

            try (FileWriter fw = new FileWriter(archivo, true);) {

                for (int j = 0; j < cantNumeros; j++) {
                    //System.out.println((int) (Math.random() * 50));
                    fw.write((int) (Math.random() * 50) + "\n");
                }

            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * Metodo que suma los numeros contenidos en un fichero. recibe por
     * argumento el nombre del fichero el cual se quiere leer y genera un nuevo
     * archivo con el nombre del fichero recibido mas las extencion .res
     * @param nombreFichero nombre del fichero que se quiere leer
     */
    public static void suma(String nombreFichero) {

        int suma = 0;
        String cadena = null;

        File fichero = new File(nombreFichero);
        File ficheroSuma = new File(nombreFichero + ".res");

        //si el fichero.res ya existe lo borra.
        if (ficheroSuma.exists()) {
            ficheroSuma.delete();
        }

        //Lectura del fichero recibido por argumento, leyendo linea a linea para calcular la suma total de ese fichero y generar el fichero .res
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero)); FileWriter fw = new FileWriter(ficheroSuma, true)) {

            while ((cadena = br.readLine()) != null) {
                suma += Integer.parseInt(cadena);
            }

            //Muestra por pantalla la suma.
            System.out.println("La suma es: " + suma);

            //escribe en el fichero la el total de la suma.
            fw.write(suma + "");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Realiza la suma total de manera secuencial de los ficheros que se deseen
     * sumar pasados como argumento utilizando un bucle for
     * @param argumentos recibe en un Array de Strings el nombre de los ficheros
     * que se quieren leer.
     */
    public static void sumaTotalesSecuencial(String[] argumentos) {

        long startTime = System.nanoTime(); // Captura el tiempo al iniciar el proceso para controlar el tiempo de ejecucion
        int sumaTotal = 0;

        // por cada argumento pasado (nombre del fichero) inicializa el proceso y espera a que el proceso termine 
        for (String argumento : argumentos) {
            try {
                //asignamos las variables para ejecutar el .Jar
                ProcessBuilder pb = new ProcessBuilder("CMD", "/c", "java -jar suma.jar " + argumento);
                Process p = pb.start();
                //espera a que el proceso termine
                p.waitFor();
                
                String linea = null;

                //Lectura de los ficheros .res, leyendo linea a linea para calcular la suma total de todos los ficheros
                try (BufferedReader br = new BufferedReader(new FileReader(argumento + ".res"))) {
                    while ((linea = br.readLine()) != null) {
                        sumaTotal += Integer.parseInt(linea);
                    }
                } catch (Exception e) {
                }

            } catch (IOException e) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
            } catch (InterruptedException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("El total de la suma es: " + sumaTotal); //muestra por pantalla la suma total de los ficheros.
        long endTime = System.nanoTime(); //Captura el tiempo al finalizar el proceso para controlar el tiempo de ejecucion
        long timeElapsed = endTime - startTime; //Calcula los nanosegundos transcurridos.
        System.out.println("Suma Secuencial, Tiempo de ejecucion en milisegundos: " + timeElapsed / 1000000); // muestra por pantalla los milisegundos transcurridos

    }

    /**
     * Realiza la suma total de manera paralela de los ficheros que se deseen
     * sumar pasados como argumento.
     * Se inicializan todos los procesos hijos dentro de un bucle for
     * Se espera a que todos los procesos hijos terminen dentro de otro bucle for
     * Se calculan las sumas de los totales dentro de otro bucle for.
     * @param argumentos recibe en un Array de Strings el nombre de los ficheros que se quieren leer.
     */
    public static void sumaTotalesParalela(String[] argumentos) {

        long startTime = System.nanoTime(); // Captura el tiempo al iniciar el proceso para controlar el tiempo de ejecucion
        int sumaTotal = 0;

        ProcessBuilder pb = null; 
        Process[] p = new Process[argumentos.length];
        //Lanza todos los procesos hijos para que comiencen a ejecutarce.
        for (int i = 0; i < argumentos.length; i++) {
            try {
                pb = new ProcessBuilder("CMD", "/c", "java -jar suma.jar " + argumentos[i]);
                p[i]= pb.start();
            } catch (IOException e) {
            }
        }
        //Espere a que todos los hijos terminen. (espera a que el sumar.Jar termine para cada argumento y genere el fichero)
        for (Process i_p : p) {
            try {
                i_p.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Realiza la suma de ficheros .res generados para calcular el total
        for (String argumento : argumentos) {
            String linea = null;
            try (BufferedReader br = new BufferedReader(new FileReader(argumento + ".res"))) {
                while ((linea = br.readLine()) != null) {
                    sumaTotal += Integer.parseInt(linea);
                }
            } catch (Exception e) {
            }
        }
        System.out.println("El total de la suma es: " + sumaTotal);
        long endTime = System.nanoTime(); //Captura el tiempo al finalizar el proceso para controlar el tiempo de ejecucion
        long timeElapsed = endTime - startTime; //Calcula los nanosegundos transcurridos.
        System.out.println("Suma Paralela, Tiempo de ejecucion en milisegundos: " + timeElapsed / 1000000);// muestra por pantalla los milisegundos transcurridos
    }
    

}
