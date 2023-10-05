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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Metodos {

    /**
     * Metodo que recibe un entero para saber el numero de ficheros a generar.
     *
     * @param numFicheros
     */
    public static void generadorDeFicheros(int numFicheros) {

        String nombreFichero = null;

        for (int i = 0; i < numFicheros; i++) {

            nombreFichero = "contabilidad" + (i + 1) + ".txt";

            File archivo = new File(nombreFichero);
            if (archivo.exists()) {
                archivo.delete();
            }

            try (FileWriter fw = new FileWriter(archivo, true);) {

                for (int j = 0; j < 10; j++) {
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
     * argumento el nombre del fichero el cual se quiere leer
     *
     * @param nombreFichero
     */
    public static void suma(String nombreFichero) {

        int suma = 0;
        String cadena = null;

        File fichero = new File(nombreFichero);
        File ficheroSuma = new File(nombreFichero + ".res");

        if (ficheroSuma.exists()) {
            ficheroSuma.delete();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero)); FileWriter fw = new FileWriter(ficheroSuma, true)) {

            while ((cadena = br.readLine()) != null) {
                suma += Integer.parseInt(cadena);
            }

            System.out.println("La suma es: " + suma);

            fw.write(suma + "");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void sumaTotales(String[] argumentos) {

        for (String argumento : argumentos) {
            try {
                //asignamos las variables para ejecutar el .Jar
                String command1 = "CMD";
                String command2 = "/c";
                String command3 = "java -jar PSP_Tema1_Tarea2_SUMA.jar " + argumento;
                ProcessBuilder pb = new ProcessBuilder(command1, command2, command3);
                Process p = pb.start();
                

            }catch (IOException e) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

}
