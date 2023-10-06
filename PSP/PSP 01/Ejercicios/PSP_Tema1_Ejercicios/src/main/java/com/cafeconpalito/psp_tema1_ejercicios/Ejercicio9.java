/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.BufferedReader;
import java.io.File;
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
public class Ejercicio9 {

    /*
        9. En este ejercicio el estudiante debe realizar un ejercicio que lance el comando:
        • Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
        • Esperamos 5 segundos.
        • Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
        • Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
        • Esperamos tres segundos.
        • Imprimimos “Las redes parecen que van bien".
     */
    public static void ejercicio9() {

        try {
            String os = System.getProperty("os.name").toLowerCase();
            //• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
            System.out.println("Sistema Operativo: " + os);

            //• Esperamos 5 segundos.
            System.out.println("\nEsperando 5 segundos");
            Thread.sleep(5000);

            //• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
            //• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
            String command1 = null;
            String command2 = null;
            String command3 = null;
            if (os.contains("win")) {
                command1 = "CMD";
                command2 = "/c";
                command3 = "ipconfig/all";
            } else if (os.contains("nux")) {
                command1 = "/bin/bash";
                command2 = "-c";
                command3 = "ifconfig -a";
            } else if (os.contains("mac")) {
                command1 = "/bin/bash";
                command2 = "-c";
                command3 = "ifconfig -a";
            }

            System.out.println("\nImprimiendo por pantalla la Configuracion IP");

            //Creando un PB al cual controlaremos el flujo de salida (retorno de la consola para leerlo mostrarlo por pantalla y escribirlo en un fichero)           
            ProcessBuilder pb = new ProcessBuilder(command1, command2, command3);

            Process p = pb.start();

            //Flujo de lectura
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            //Inicio de lectura linea a linea
            String linea = null;
            linea = br.readLine();

            //Creamos el archivo, si ya existe borra el archivo y genera uno nuevo
            File archivo = new File("prueba.txt");
            FileWriter fw = null;
            if (archivo.exists()) {
                archivo.delete();
            }

            //comienza a capturar el retorno del CMD y lo imprime por pantalla y lo escribe en el fichero.
            try {
                fw = new FileWriter(archivo, true);
                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
                    fw.write(linea + "\n");
                    linea = br.readLine();
                }

            } catch (IOException e) {
                System.err.println("IOException");
            } finally {
                try {
                    br.close();
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    System.err.println("IOException cierre flujo");
                }
            }

            //• Esperamos tres segundos.
            System.out.println("\nEsperando 3 segundos");
            Thread.sleep(3000);

            //• Imprimimos “Las redes parecen que van bien"
            System.out.println("\nLas redes parecen que van bien");

        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

    }

    //ATENCIÓN!!. : Modifica haz otra versión del ejercicio utilizando el bloque “try-with-resources”.
    public static void ejercicio9_v2() {

        try {
            String os = System.getProperty("os.name").toLowerCase();
            //• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
            System.out.println("Sistema Operativo: " + os);

            //• Esperamos 5 segundos.
            System.out.println("\nEsperando 5 segundos");
            Thread.sleep(5000);

            //• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
            //• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
            String command1 = null;
            String command2 = null;
            String command3 = null;
            if (os.contains("win")) {
                command1 = "CMD";
                command2 = "/c";
                command3 = "ipconfig/all";
            } else if (os.contains("nux")) {
                command1 = "/bin/bash";
                command2 = "-c";
                command3 = "ifconfig -a";
            } else if (os.contains("mac")) {
                command1 = "/bin/bash";
                command2 = "-c";
                command3 = "ifconfig -a";
            }
            
            
            System.out.println("\nImprimiendo por pantalla la Configuracion IP");

            //Creando un PB al cual controlaremos el flujo de salida (retorno de la consola para leerlo mostrarlo por pantalla y escribirlo en un fichero)           
            ProcessBuilder pb = new ProcessBuilder(command1, command2, command3);

            Process p = pb.start();

            //Damos nombre al archivo donde guardaremos la informacion
            File archivo = new File("prueba2.txt");

            //Creamos el archivo, si ya existe borra el archivo y genera uno nuevo
            if (archivo.exists()) {
                archivo.delete();
            }

            //creamos un String para almacenar linea a linea
            String linea = null;
            
            // declaramos los Flujos dentro del Try con "try-with-resources" para que cierre los flujos al finalizar el Try.
            try (FileWriter fw = new FileWriter(archivo, true); 
                    InputStream is = p.getInputStream(); 
                    BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                //Inicio de lectura linea a linea
                linea = br.readLine();

                //comienza a capturar el retorno del CMD y lo imprime por pantalla y lo escribe en el fichero.
                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
                    fw.write(linea + "\n");
                    linea = br.readLine();
                }

            } catch (IOException e) {
                System.err.println("IOException");
            }

            //• Esperamos tres segundos.
            System.out.println("\nEsperando 3 segundos");
            Thread.sleep(3000);

            //• Imprimimos “Las redes parecen que van bien"
            System.out.println("\nLas redes parecen que van bien");
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //ATENCIÓN2!!: Añade al ejercicio anterior el código necesario para imprimir también la salida de error estándar sterr.
    public static void ejercicio9_v3() {

        try {
            String os = System.getProperty("os.name").toLowerCase();
            //• Imprime el sistema operativo donde estamos (ver en enlace del ejercicio 2).
            System.out.println("Sistema Operativo: " + os);

            //• Esperamos 5 segundos.
            System.out.println("\nEsperando 5 segundos");
            Thread.sleep(5000);

            //• Si estamos en Windows, abre ipconfig e imprime su salida por pantalla y en un fichero.
            //• Si estamos en Linux o Mac OS abrimos ifconfig e imprimimos su salida por pantalla y en un fichero.
            String command1 = null;
            String command2 = null;
            String command3 = null;
            if (os.contains("win")) {
                command1 = "CMD";
                command2 = "/c";
                command3 = "ifconfig/all"; //ERROR PROVOCADO A POSTA!
            } else if (os.contains("nux")) {
                command1 = "/bin/bash";
                command2 = "-c";
                command3 = "ifconfigASD -a"; //ERROR PROVOCADO A POSTA!
            } else if (os.contains("mac")) {
                command1 = "/bin/bash";
                command2 = "-c";
                command3 = "ifconfigASD -a"; //ERROR PROVOCADO A POSTA!
            }

            System.out.println("\nImprimiendo por pantalla la Configuracion IP");

            //Creando un PB al cual controlaremos el flujo de salida (retorno de la consola para leerlo mostrarlo por pantalla y escribirlo en un fichero)           
            ProcessBuilder pb = new ProcessBuilder(command1, command2, command3);

            Process p = pb.start();

            File archivo = new File("prueba3.txt");
            File archivoError = new File("pruebaError3.txt");

            //Creamos el archivo, si ya existe borra el archivo y genera uno nuevo
            if (archivo.exists()) {
                archivo.delete();
            }
            
            if (archivoError.exists()) {
                archivoError.delete();
            }
            
            String linea = null;
            String lineaError = null;
            

            // declaramos los Flujos dentro del Try con "try-with-resources" para que cierre los flujos al finalizar el Try.
            try (FileWriter fw = new FileWriter(archivo, true);
                    InputStream is = p.getInputStream(); 
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    
                    FileWriter fwError = new FileWriter(archivoError, true);
                    InputStream isError = p.getErrorStream(); 
                    BufferedReader brError = new BufferedReader(new InputStreamReader(isError))
                    ) {

                //Inicio de lectura linea a linea
                linea = br.readLine();
                //comienza a capturar el retorno del CMD y lo imprime por pantalla y lo escribe en el fichero.
                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
                    fw.write(linea + "\n");
                    linea = br.readLine();
                }

                //Inicio de lectura ERRORES linea a linea
                lineaError = brError.readLine();
                //comienza a capturar el retorno del CMD y lo imprime por pantalla y lo escribe en el fichero.
                while (lineaError != null) {
                    //mostrando las lineas por consola
                    System.out.println(lineaError);
                    fwError.write(lineaError + "\n");
                    lineaError = brError.readLine();
                }
                
            } catch (IOException e) {
                System.err.println("IOException");
            }

            //• Esperamos tres segundos.
            System.out.println("\nEsperando 3 segundos");
            Thread.sleep(3000);

            //• Imprimimos “Las redes parecen que van bien"
            System.out.println("\nLas redes parecen que van bien");
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio9.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
