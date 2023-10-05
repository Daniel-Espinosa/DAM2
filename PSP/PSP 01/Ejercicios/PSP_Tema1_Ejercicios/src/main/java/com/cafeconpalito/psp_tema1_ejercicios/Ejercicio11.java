/*
11. Escribir en la entrada estándar de un proceso.
Crea dos programas en Java:

- El primero lee dos cadenas de texto desde la entrada estándar. Para hacerlo utiliza la 
clase BufferedReader y su método readLine(). Para redirigir la entrada estándar 
(System.in) a BufferedReader hay que hacer el código siguiente:
Pídelas al usuario con los mensajes: “Introduce la primera cadena” e “introduce la 
segunda cadena”.
Cada cadena leída la tienes que imprimir por pantalla (salida estándar).
Por último, crea un .jar de la aplicación.

- El segundo programa debe lanzar un proceso con el .jar anterior y debe pasarle por su 
entrada estándar las dos cadenas para que las lea. A continuación, comprobar que 
funciona deberás obtener la salida estándar del proceso para imprimirla por pantalla
 */
package com.cafeconpalito.psp_tema1_ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class Ejercicio11 {

    public static void ejercicio11_p1() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            //Este programa espera por consola que se le envie informacion
            //La cual se la suministrara el siguiente programa.
            System.out.println("Introduce la primera cadena");
            System.out.println(br.readLine());
            System.out.println("Introduce la segunda cadena");
            System.out.println(br.readLine());

        } catch (Exception e) {
        }

    }

    public static void ejercicio11_p2() {

        try {

            //asignamos las variables para ejecutar el .Jar
            String command1 = "CMD";
            String command2 = "/c";
            String command3 = "java -jar ejercicio11_P1.jar";

            //Creando un PB al cual controlaremos el flujo de salida (retorno de la consola para leerlo mostrarlo por pantalla y escribirlo en un fichero)           
            ProcessBuilder pb = new ProcessBuilder(command1, command2, command3);
            Process p = pb.start();
            
            //Hace que el padre envie al Hijo las dos lineas de texto que espera.
            try (OutputStream os = p.getOutputStream(); BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));){
                
                bw.write("Enviando del padre al hijo la 1º Linea");
                bw.newLine();
                bw.write("Enviando del padre al hijo la 2º Linea");

            } catch (Exception e) {
            }
            
            String linea = null;
            
            // declaramos los Flujos dentro del Try con "try-with-resources" para que cierre los flujos al finalizar el Try.
            try (InputStream is = p.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
                
                
                //Inicio de lectura linea a linea
                linea = br.readLine();
                //comienza a capturar el retorno del CMD y lo imprime por pantalla y lo escribe en el fichero.
                
                while (linea != null) {
                    //mostrando las lineas por consola
                    System.out.println(linea);
                    //escribiendo en el fichero cada linea
                    //fw.write(linea + "\n");
                    linea = br.readLine();
                    
                }
                

            } catch (IOException e) {
                Logger.getLogger(Ejercicio11.class.getName()).log(Level.SEVERE, null, e);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio11.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
