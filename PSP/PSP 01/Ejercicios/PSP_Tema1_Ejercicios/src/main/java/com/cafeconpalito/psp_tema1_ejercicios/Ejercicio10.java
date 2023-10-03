/*
 Crea dos programas en Java:
- El primero imprime por su salida estándar 10 números aleatorios. A continuación, genera un 
.jar del programa.
- El segundo tiene que ejecutar el .jar del primer programa y leer su salida estándar para 
calcular la suma de los 10 números aleatorios
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
public class Ejercicio10 {
    
    public static void ejercicio10_P1(){
        
        for (int i = 0; i < 10; i++) {
            System.out.println((int)(Math.random()*9));
        }
        
    }
    
    public static void ejercicio10_P2(){
        
        try {
            
            //asignamos las variables para ejecutar el .Jar
            String command1 = "CMD";
            String command2 = "/c";
            String command3 = "java -jar ejercicio10_P1.jar";

            //Creando un PB al cual controlaremos el flujo de salida (retorno de la consola para leerlo mostrarlo por pantalla y escribirlo en un fichero)           
            ProcessBuilder pb = new ProcessBuilder(command1, command2, command3);

            Process p = pb.start();

            File archivo = new File("ejercicio10.txt");
            File archivoError = new File("ejercicio10Error.txt");

            //Creamos el archivo, si ya existe borra el archivo y genera uno nuevo
            if (archivo.exists()) {
                archivo.delete();
            }
            
            if (archivoError.exists()) {
                archivoError.delete();
            }
            
            String linea = null;
            String lineaError = null;
            
            int suma = 0;
            
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
                    //System.out.println(linea);
                    //escribiendo en el fichero cada linea
                    //fw.write(linea + "\n");
                    
                    suma += Integer.parseInt(linea);
                    
                    linea = br.readLine();
                }

                    fw.write(Integer.toString(suma));
                    System.out.println("La suma de los numeros aleatorios es: " + suma);
                
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
                Logger.getLogger(Ejercicio10.class.getName()).log(Level.SEVERE, null, e);
            }

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
